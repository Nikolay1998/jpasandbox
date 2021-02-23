package com.kraynov.jpasandbox.web;

import com.kraynov.jpasandbox.domain.User;
import com.kraynov.jpasandbox.services.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getParameter("login");
        String password = (String) req.getParameter("password");

        HttpSession session = req.getSession();
        LoginService service = new LoginService();
        User user = service.login(login, password);
        if (user == null) {
            session.setAttribute("invalidUsername", true);
        } else {
            session.setAttribute("user", user);
        }

        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp);
    }
}
