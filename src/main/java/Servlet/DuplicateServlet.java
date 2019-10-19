package Servlet;

import Service.DuplicateLetter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class DuplicateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("FizzBuzz.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = req.getParameter("input");
        DuplicateLetter duplicateLetter =new DuplicateLetter();
        String results = duplicateLetter.DuplicateLetter(result);

        req.setAttribute("result", results);
        doGet(req, resp);
    }
}