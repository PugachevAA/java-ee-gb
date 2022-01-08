package ru.gb.lesson1.servlet;

import ru.gb.lesson1.service.CatService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CatHttpServlet", urlPatterns = "/cat")
public class CatServlet extends HttpServlet {

    private final CatService catService = new CatService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cat", catService.createNewCat());
        getServletContext().getRequestDispatcher("/cat.jsp")
                .forward(req, resp);
    }
}
