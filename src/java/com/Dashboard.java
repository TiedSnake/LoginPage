package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        HttpSession session =req.getSession(false);
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<form action=\"Logout\" method=\"post\"style=\"text-align: center\"><strong>Welcome "+session.getAttribute("email")+" </strong><br>");
        out.println("<button name=logout value=\"logout\">Logout</button></form>");
        out.println("</body></html>");
    }
}
