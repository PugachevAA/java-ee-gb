package ru.gb.lesson1.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "TestHttpServlet", urlPatterns = "testhttpservlet")
public class TestHttpServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(TestHttpServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New get request for TestHttpServlet");
        logger.info(req.getContextPath());
        logger.info(req.getServletPath());
        logger.info(req.getQueryString()); //localhost:8080/java-ee-gb/testhttpservlet?param1=val1&param2=val2
        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        resp.getWriter().println("<h1>New GET req</n1>");

        resp.getWriter().printf("<h1>New Get req with parameters param1 = %s; param2 = %s </h1>",
                req.getParameter("param1"),
                req.getParameter("param2"));

        getServletContext().getRequestDispatcher("/basicservlet/")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New POST req for TestHttpServlet");

        resp.getWriter().println("<h1>New POST req</n1>");
        resp.getWriter().printf("<h1>Echo: %s</n1>", readAllLines(req.getReader()));
    }

    private String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder content = new StringBuilder();

        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        return  content.toString();
    }
}
