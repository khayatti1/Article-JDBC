<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container mt-4">
    <div class="mb-3">
        <a href="${pageContext.request.contextPath}/addArticle.do" class="btn btn-success">Ajouter un article</a>
    </div>
    <table class="table table-striped">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Description</th>
            <th scope="col">Quantite</th>
            <th scope="col">Prix</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${articles}" var="article">
            <tr>
                <th scope="row">${article.id}</th>
                <td>${article.description}</td>
                <td>${article.quantite}</td>
                <td>${article.price}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/editArticle.do?id=${article.id}"
                       class="btn btn-primary btn-sm">Modifier</a>
                    <a href="${pageContext.request.contextPath}/deleteArticle.do?id=${article.id}"
                       class="btn btn-danger btn-sm"
                       onclick="return confirm('etes-vous sur de vouloir supprimer cet article?')">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>