<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <link href="static/css/login.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="background-image"></div>

<div class="login-frame">
    <div class="login-container">
        <div class="header">
            <i class="fas fa-user-edit header-icon"></i>
            <h1>BIENVENUE JDBC</h1>
            <p class="subtitle">Gestion des articles en stock </p>
            <p class="subtitle">Preparer par KHAYATI & MOUDID </p>
        </div>

        <c:if test="${not empty AccountIncorrect}">
            <div class="error-message">${AccountIncorrect}</div>
        </c:if>

        <form class="login-form" action="${pageContext.request.contextPath}/login.do" method="post">
            <div class="form-group">
                <label for="username">Username/serial</label>
                <input type="text" id="username" name="username" placeholder="user1" required>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="••••••••" required>
            </div>

            <div class="options">
                <div class="remember-me">
                    <input type="checkbox" id="remember" name="remember">
                    <label for="remember">Remember me</label>
                </div>
                <a href="#" class="forgot-password">Forgot password?</a>
            </div>

            <button type="submit" class="btn-login">Login</button>
        </form>
    </div>
</div>
</body>
</html>