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
import java.util.Timer;
import java.util.TimerTask;


public class LServlet extends HttpServlet {

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
            assert docBuilder != null;
            document = docBuilder.parse(new File("/home/andrei/Desktop/InteviewTest/src/main/resources/example.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        }

        NodeList nodeList = document.getElementsByTagName("user");



        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            int size = i;
            req.setAttribute("size",size);



            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(node.getTextContent());


                req.setAttribute("users"+size, node.getTextContent());
            }

        }

//
//
//
//        List<User>users = service.GetX(test);
//
//
//        for(int i = 0;i<users.size();i++){
//            int size = i;
//            req.setAttribute("size",size);
//            req.setAttribute("users"+size, users.get(i).toString());
//            System.out.println(users.get(i));
//        }



        doGet(req, resp);
    }
}
