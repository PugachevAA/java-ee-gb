package ru.gb.lesson1.servlet;

import ru.gb.lesson1.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductHttpServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productService.createProducts());
        getServletContext().getRequestDispatcher("/products.jsp").forward(req, resp);
    }
}
