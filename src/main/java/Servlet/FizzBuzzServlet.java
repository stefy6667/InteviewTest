package Servlet;

import Service.FizzBuzz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class FizzBuzzServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("FizzBuzz.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String result = req.getParameter("input");
        int n = Integer.parseInt(result);
        FizzBuzz fizbuzz = new FizzBuzz();
        String results = fizbuzz.FizzBuzz(n);

        req.setAttribute("result", results);
        doGet(req, resp);
    }
}