package ua.kiev.prog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/*1) Опишите класс квартира (ее свойствами будут — описание, количество комнат, адрес, этаж, стоимость). Также реализуйте класс
        который представляет собой список квартир на продажу (например для агентства недвижимости). Все данные о квартирах они
        хранят в XML документе. Реализуйте методы считывания данных о квартирах, изменение данных (например уменьшилась стоимость
        квартиры), удаление квартиры из списка продаж (например ее продали) с внесением изменений в XML документ. Также реализуйте
        методы получения списка квартир по критериям — диапазон цены (например от 30 000 — 50 000), и по количеству комнат
        (т. е. Из списка выбрать только 3 комнатные).
2) К этому проекту (а он уже должен быть создан, так как это д.з. первой лекции) напишите веб — интерфейс. Т.е. в
        браузере должен отображаться список действий которые можно выполнить (поиск, добавление, удаление квартиры и т.д.).
        И способы обработки данных запросов.*/

@WebServlet(name = "ApartmentServlet", urlPatterns = {"/apartment"})
public class ApartmentServlet extends HttpServlet {

    private static ApartmentList list = new ApartmentList();
    private static ApartmentList listRes = new ApartmentList();

    private static Boolean operations(String fileXML, String idA, String roomsA, String addressA, String floorA, String priceA, String idD,
                                      String idC, String priceC, String priceR1, String priceR2, String roomN, String path, HttpServletResponse response) throws IOException {
        if (fileXML != null) {
            list = ApartmentXMLWorker.loadFromXMLFile(new File(fileXML));
            return true;
        }
        if (idA != null && roomsA != null && addressA != null && floorA != null && priceA != null) {
            list.add(new Apartment(Integer.parseInt(idA), Integer.parseInt(roomsA), addressA, Integer.parseInt(floorA), Long.parseLong(priceA)));
            return true;
        }
        if (idD != null) {
            list.delete(Integer.parseInt(idD));
            return true;
        }
        if (idC != null && priceC != null) {
            list.change(Integer.parseInt(idC), Long.parseLong(priceC));
            return true;
        }
        if (priceR1 != null && priceR2 != null) {
            listRes = list.priseRange(Long.parseLong(priceR1), Long.parseLong(priceR2));
            return true;
        }
        if (roomN != null) {
            listRes = list.roomNumber(Integer.parseInt(roomN));
            return true;
        }
        if (path != null) {
            ApartmentXMLWorker.saveToXMLFile(list, new File(path));
            return true;
        }
        return false;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileXML = req.getParameter("fileXML");
        String idA = req.getParameter("idA");
        String roomsA = req.getParameter("roomsA");
        String addressA = req.getParameter("addressA");
        String floorA = req.getParameter("floorA");
        String priceA = req.getParameter("priceA");

        String idD = req.getParameter("idD");

        String idC = req.getParameter("idC");
        String priceC = req.getParameter("priceC");

        String priceR1 = req.getParameter("priceR1");
        String priceR2 = req.getParameter("priceR2");

        String roomsN = req.getParameter("roomsN");

        String path = req.getParameter("path");


        if (operations(fileXML, idA, roomsA, addressA, floorA, priceA, idD, idC, priceC, priceR1, priceR2, roomsN, path, resp)) {
            req.setAttribute("list", list);
            req.setAttribute("listResult", listRes);
            RequestDispatcher rDisp = getServletContext().getRequestDispatcher("/Apartment.jsp");
            rDisp.forward(req, resp);
        } else {
            RequestDispatcher rDisp = getServletContext().getRequestDispatcher("/index.jsp");
            rDisp.forward(req, resp);
        }

    }
}
