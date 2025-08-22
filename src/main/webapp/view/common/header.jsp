<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
                   role="button" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Gestion des articles</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/articles.do">Consulter</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/addArticle.do">Ajouter</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/searchArticles.do">Rechercher</a>
                </div>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout.do">LogOut</a>
            </li>
        </ul>
    </div>
</nav>