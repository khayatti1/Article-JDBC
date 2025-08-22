<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Resultats de recherche</title>
    <link href="webjars/bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="common/header.jsp"%>

<div class="container mt-4">
    <h2>Resultats de recherche</h2>
    <c:if test="${empty articles}">
        <div class="alert alert-info">Aucun article trouve avec ces criteres</div>
    </c:if>
    <c:if test="${not empty articles}">
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Description</th>
                <th scope="col">Quantite</th>
                <th scope="col">Prix</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${articles}" var="article">
                <tr>
                    <th scope="row">${article.id}</th>
                    <td>${article.description}</td>
                    <td>${article.quantite}</td>
                    <td>${article.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <a href="${pageContext.request.contextPath}/searchArticles.do" class="btn btn-secondary">Nouvelle recherche</a>
    <a href="${pageContext.request.contextPath}/articles.do" class="btn btn-primary">Retour a la liste</a>
</div>

<%@include file="common/footer.jsp"%>

<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>
</body>
</html>