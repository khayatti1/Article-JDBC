<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier un article</title>
    <link href="webjars/bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="common/header.jsp"%>

<div class="container mt-5">
    <h2>Modifier l'article</h2>
    <form action="${pageContext.request.contextPath}/editArticle.do" method="post">
        <input type="hidden" name="id" value="${article.id}">
        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" class="form-control" id="description" name="description"
                   value="${article.description}" required>
        </div>
        <div class="form-group">
            <label for="quantite">Quantite:</label>
            <input type="number" step="0.01" class="form-control" id="quantite" name="quantite"
                   value="${article.quantite}" required>
        </div>
        <div class="form-group">
            <label for="price">Prix:</label>
            <input type="number" step="0.01" class="form-control" id="price" name="price"
                   value="${article.price}" required>
        </div>
        <button type="submit" class="btn btn-primary">Mettre a jour</button>
        <a href="${pageContext.request.contextPath}/articles.do" class="btn btn-secondary">Annuler</a>
    </form>
</div>

<%@include file="common/footer.jsp"%>

<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>
</body>
</html>