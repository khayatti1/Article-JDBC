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

@WebServlet("/addArticle.do")
public class AddArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IService service = new ServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/addArticle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String description = request.getParameter("description");
        String quantiteStr = request.getParameter("quantite");
        String priceStr = request.getParameter("price");

        try {
            int quantite = Integer.parseInt(quantiteStr);
            double price = Double.parseDouble(priceStr);

            if (quantite < 0) {
                request.setAttribute("errorMessage", "La quantité ne peut pas être négative.");
                request.getRequestDispatcher("/view/addArticle.jsp").forward(request, response);
                return;
            }

            Article article = new Article(null, description, quantite, price);
            service.createArticle(article);

            response.sendRedirect(request.getContextPath() + "/articles.do");

        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Veuillez entrer des valeurs numériques valides.");
            request.getRequestDispatcher("/view/addArticle.jsp").forward(request, response);
        }
    }
}
