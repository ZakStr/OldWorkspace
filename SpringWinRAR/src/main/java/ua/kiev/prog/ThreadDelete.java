package ua.kiev.prog;

import java.io.File;
import java.util.Map;

/**
 * Created by Zakusylo.p on 10.04.2017.
 */
public class ThreadDelete implements Runnable {
    private Map<Long, File> rar;
    private long files_id;

    public ThreadDelete(Map<Long, File> rar, long files_id) {
        this.rar = rar;
        this.files_id = files_id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(300000);
            if (rar.containsKey(files_id)) {
                rar.get(files_id).delete();
                rar.remove(files_id);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
