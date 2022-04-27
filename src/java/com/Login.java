package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String email = (String)req.getParameter("email");
        String password = (String)req.getParameter("password");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        if (email.equals("mike11@hotmail.com") && password.equals("Mike123"))
        {
            session.setAttribute("email", email);
            session.setAttribute("password", password);
            resp.sendRedirect("Dashboard");
        }else
        {
//            out.println("<script>document.getElementById(\"errorMessage\").innerHTML=(\"wrong Username or Password\");</script>");
            out.append("<script>alert(\"Wrong email or Password\");</script>");
            req.getRequestDispatcher("index.html").include(req, resp);
        }
    }
}
