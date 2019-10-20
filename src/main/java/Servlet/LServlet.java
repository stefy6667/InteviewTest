package Servlet;


import Model.User;
import Model.UserW;
import Service.UserService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.List;


public class LServlet extends HttpServlet {
    private int size;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("SearchUser.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int test = 0;
        if (name.equals("")) {
            test = 0;
        } else {
            test = Integer.parseInt(name);
        }
        UserService service = UserService.getInstance();

        service.GetX(test);


        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = docBuilder.parse(new File("/home/andrei/GeomantTest/src/main/resources/example.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        }

        NodeList nodeList = document.getElementsByTagName("x");



        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
             size=i;


            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(node.getTextContent());
                req.setAttribute("size",size);
                req.setAttribute("myname"+size, node.getTextContent());
            }

        }



        doGet(req, resp);
    }
}
