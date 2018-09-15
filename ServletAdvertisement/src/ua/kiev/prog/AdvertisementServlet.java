package ua.kiev.prog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by admin on 25.03.2017.
 */

/*1) Создайте веб приложение для работы с объявлениями. Т.е. у пользователя должна быть возможность добавлять объявление,
        просматривать все объявления которые добавили другие пользователи.Т.е. это должен быть веб интерфейс построенный
        с помощью jstl тегов.*/

@WebServlet(name = "AdvertiSementservlet", urlPatterns = "/advertisement")
public class AdvertisementServlet extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 1L;
    private static HashMap<String, String> users = new HashMap<>();
    private static MessageList list = new MessageList();

    private static void newMessage(String text, HttpServletRequest req) {
        Message message = new Message(text);
        list.addMessage(message);
        req.setAttribute("messageList", list.getMessageList());
    }

    private static void newUser(String name, String surname, String email, String newLogin, String newPassword) {
        User user = new User(name, surname, email, newLogin, newPassword);
        users.put(newLogin, newPassword);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String newLogin = req.getParameter("newLogin");
        String newPassword = req.getParameter("newPassword");
        String text = req.getParameter("text");

        if (login != null && password != null && name == null && surname == null && email == null && newLogin == null && newPassword == null) {
            Set<Map.Entry<String, String>> hms = users.entrySet();
            for (Map.Entry<String, String> hmse : hms) {
                if (hmse.getKey().equals(login) && hmse.getValue().equals(password)) {
                    HttpSession session = req.getSession(true);
                    session.setAttribute("user_login", login);
                    RequestDispatcher rDisp = getServletContext().getRequestDispatcher("/advertise.jsp");
                    rDisp.forward(req, resp);
                }
            }

        } else if (name != null && surname != null && email != null && newLogin != null && newPassword != null && login == null && password == null) {
            newUser(name, surname, email, newLogin, newPassword);

            HttpSession session = req.getSession(true);
            session.setAttribute("user_login", newLogin);
            RequestDispatcher rDisp = getServletContext().getRequestDispatcher("/advertise.jsp");
            rDisp.forward(req, resp);
        }
        if (text != null) {
            newMessage(text, req);
            RequestDispatcher rDisp = getServletContext().getRequestDispatcher("/advertise.jsp");
            rDisp.forward(req, resp);
        }
        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("a");
        HttpSession session = req.getSession(false);

        if ("exit".equals(a) && (session != null)) {
            session.removeAttribute("user_login");
        }
        resp.sendRedirect("index.jsp");
    }
}
