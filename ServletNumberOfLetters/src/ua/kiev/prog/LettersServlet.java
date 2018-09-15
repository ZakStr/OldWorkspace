package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*Создайте веб приложение на стартовой странице которого будет текстовая область ввода и кнопка отправки , приложение должно считать
        текст из текстового поля и вывести на экран таблицу одним столбцом которой является буква, вторым столбцом сколько раз она
        встречалась в тексте. Первыми должны идти буквы которые встречаются чаще всего.*/

public class LettersServlet extends HttpServlet {
    static final String TEMPLATE = "<html>" +
            "<head>" +
            "<title>Prog.kiev.ua</title>" +
            "</head>" +
            "<body>" +
            "<h1>%s</h1>" +
            "</body>" +
            "</html>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        if (!text.equals(null)) {
            LettersRead lr = new LettersRead(text);
            ArrayList<Letters> list = lr.calculateLetter();
            String ansver = "<table border='2' cellpadding='5'>";
            ansver += "<tr><th>Letters</th>";
            for (Letters letters : list) {
                ansver += "<td>" + letters.getLetter() + "</td>";
            }
            ansver += "</tr>";
            ansver += "<th>Amount</th>";
            for (Letters letters : list) {
                ansver += "<td>"+letters.getNumber()+"</td>";
            }
            ansver += "</tr>";
            ansver += "</table>";

            ansver += "<br><h4> Click to analyze new text <a href ='/letters?a=new'>&rArr; New text &lArr;</a></h4>";
            resp.getWriter().println(String.format(TEMPLATE, ansver));
        } else {
            resp.sendRedirect("Letters.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("a");
        if (str.equals("new")) {
            resp.sendRedirect("Letters.html");
        }
    }
}