<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Recherche d'articles</title>
    <link href="webjars/bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="common/header.jsp"%>

<div class="container mt-5">
    <h2>Recherche d'articles</h2>
    <form action="${pageContext.request.contextPath}/searchArticles.do" method="post">
        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" class="form-control" id="description" name="description">
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="minPrice">Prix minimum:</label>
                <input type="number" step="0.01" class="form-control" id="minPrice" name="minPrice">
            </div>
            <div class="form-group col-md-6">
                <label for="maxPrice">Prix maximum:</label>
                <input type="number" step="0.01" class="form-control" id="maxPrice" name="maxPrice">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Rechercher</button>
        <a href="${pageContext.request.contextPath}/articles.do" class="btn btn-secondary">Retour</a>
    </form>
</div>

<%@include file="common/footer.jsp"%>

<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>
</body>
</html>