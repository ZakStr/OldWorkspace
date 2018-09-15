package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*Создайте веб — калькулятор. Т.е. два текстовых поля куда вводиться  числа и переключатель для действий между ними
        (т. е. 4 пункта «+», «-», «*» , «/». Ответ выводите в другой странице.*/

public class CalculatorServlet extends HttpServlet {
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
        Double first = Double.parseDouble(req.getParameter("first"));
        Double second = Double.parseDouble(req.getParameter("second"));
        Double result = 0.0;
        String answer = "";
        String attr = req.getParameter("select");

        if (!attr.equals("Nothing")) {
            if (attr.equals("+")) {
                result = first + second;
            } else if (attr.equals("-")) {
                result = first - second;
            } else if (attr.equals("*")) {
                result = first * second;
            } else if (attr.equals("/")) {
                if (second != 0.0) {
                    result = first / second;
                } else {
                    answer += "You can not divide by zero";
                }
            }
        } else {
            resp.sendRedirect("Calculator.html");
        }

        int result2 = (int) Math.round(result);
        double result3 = result % result2;
        if (result3 == 0.0) {
            answer += "Result &#61; " + result2;
        } else {
            answer += "Result &#61; " + result;
        }
        answer += "<br><br><h4> Click to calculate new numbers <a href ='/calculator?a=new'>&rArr; New calculations &lArr;</a></h4>";
        resp.getWriter().print(String.format(TEMPLATE, answer));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("a");
        if (str.equals("new")) {
            resp.sendRedirect("Calculator.html");
        }
    }
}
