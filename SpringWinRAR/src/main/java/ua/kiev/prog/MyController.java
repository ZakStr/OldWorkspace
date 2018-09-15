package ua.kiev.prog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//1. Решить задачу про архиватор с помощью Spring MVC.

@Controller
@RequestMapping("/")
public class MyController {

    private Map<Long, File> rar = new HashMap<Long, File>();

    @RequestMapping("/")
    public String onIndex() {
        return "index";
    }

    @RequestMapping(value = "/load", method = RequestMethod.POST)
    public String onAddFiles(Model model, @RequestParam MultipartFile[] files) throws IOException, InterruptedException {
        if (files != null) {
            long id = System.currentTimeMillis();
//            File file = new File("C:\\Users\\Zakusylo.p\\Desktop\\WinRAR" + id + ".rar");
            File file = new File("/home/zakusylo/WinRAR" + id + ".rar");

            try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(file))) {

                for (MultipartFile multipartFile : files) {
                    ZipEntry entry1 = new ZipEntry(multipartFile.getOriginalFilename());
                    zout.putNextEntry(entry1);
                    // считываем содержимое файла в массив byte
                    byte[] buffer = multipartFile.getBytes();
                    // добавляем содержимое к архиву
                    zout.write(buffer);
                }
                // закрываем текущую запись для новой записи
                zout.closeEntry();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            rar.put(id, file);
            model.addAttribute("flag", true);
            model.addAttribute("files_id", id);
            model.addAttribute("files", files);

            Thread th = new Thread(new ThreadDelete(rar, id));
            th.setDaemon(true);
            th.start();

            return "index";
        } else {
            throw new FilesNotFoundException();
        }
    }

    @RequestMapping(value = "/download/{files_id}")
    public String download(HttpServletResponse response, @PathVariable("files_id") long files_id) throws IOException {
        if (rar.containsKey(files_id)) {
            InputStream is = new FileInputStream(rar.get(files_id));

            // MIME type of the file
            response.setContentType("application/octet-stream");
            // Response header
            response.setHeader("Content-Disposition", "attachment; filename=\"" + rar.get(files_id).getName() + "\"");
            // Read from the file and write into the response
            OutputStream os = response.getOutputStream();
            byte[] buffer = new byte[is.available()];
            int len;

            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

            os.flush();
            os.close();
            is.close();
            return "index";
        } else {
            throw new FileNotFoundException();
        }
    }
}
