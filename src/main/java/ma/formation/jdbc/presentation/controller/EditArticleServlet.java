package ma.formation.jdbc.presentation.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formation.jdbc.service.IService;
import ma.formation.jdbc.service.ServiceImpl;
import ma.formation.jdbc.service.model.Article;

@WebServlet("/editArticle.do")
public class EditArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService service = new ServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Article article = service.getArticleById(id);
        request.setAttribute("article", article);
        request.getRequestDispatcher("/view/editArticle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String description = request.getParameter("description");
        String quantiteStr = request.getParameter("quantite");
        String priceStr = request.getParameter("price");

        try {
            Long id = Long.parseLong(idStr);
            int quantite = Integer.parseInt(quantiteStr);
            double price = Double.parseDouble(priceStr);

            if (quantite < 0) {
                Article article = new Article(id, description, Math.abs(quantite), price);
                request.setAttribute("errorMessage", "La quantité ne peut pas être négative.");
                request.setAttribute("article", article);
                request.getRequestDispatcher("/view/editArticle.jsp").forward(request, response);
                return;
            }

            Article article = new Article(id, description, quantite, price);
            service.updateArticle(article);

            response.sendRedirect(request.getContextPath() + "/articles.do");

        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Veuillez entrer des valeurs numériques valides.");
            request.getRequestDispatcher("/view/editArticle.jsp").forward(request, response);
        }
    }
}
