package ma.formation.jdbc.presentation.controller;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formation.jdbc.service.IService;
import ma.formation.jdbc.service.ServiceImpl;
import ma.formation.jdbc.service.model.Article;

@WebServlet("/searchArticles.do")
public class SearchArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService service = new ServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/searchArticles.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String description = request.getParameter("description");
        Double minPrice = parseDouble(request.getParameter("minPrice"));
        Double maxPrice = parseDouble(request.getParameter("maxPrice"));

        List<Article> articles = service.searchArticles(description, minPrice, maxPrice);
        request.setAttribute("articles", articles);
        request.getRequestDispatcher("/view/searchResults.jsp").forward(request, response);
    }

    private Double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException | NullPointerException e) {
            return null;
        }
    }
}