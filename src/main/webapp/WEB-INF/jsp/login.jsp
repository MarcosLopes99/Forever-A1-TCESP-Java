<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>

<c:set value="${pageContext.request.contextPath}" var="contextPath" />

<title>TCESP - Login</title>
<link rel="stylesheet" type="text/css"
	href="${contextPath}/css/login-cadastro.css">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/a81368914c.js"></script>
<link rel="shortcurt icon" href="${contextPath}/images/tce-logo2.png"
	type="${contextPath}/images/tce-logo2.png">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>

	<img class="wave" src="${contextPath}/images/wave.png">

	<div class="container">

		<div class="img">
			<img src="${contextPath}/images/background2.svg">
		</div>

		<div class="login-content">

			<form th:object="${usuarioModel}"
				action="${contextPath}/efetuarLogin" method="post">

				<img src="${contextPath}/images/tce-logo.png">

				<h2 class="title">Bem-vindo ao TCESP</h2>

				<div th:if="${mensagem != null}">
					<font color="red">${mensagem}</font>
				</div>

				<br>

				<div class="input-div one">

					<div class="i">
						<i class="fas fa-user"></i>
					</div>

					<div class="div">
						<h5>
							<label class="control-label" for="emailUser">Digite o
								e-mail</label>
						</h5>
						<input name="emailUser" type="email" id="emailUser" class="input"
							maxlength="70" size="70" />
					</div>

				</div>

				<div class="input-div pass">

					<div class="i">
						<i class="fas fa-lock"></i>
					</div>

					<div class="div">
						<h5>
							<label class="control-label" for="senhaUser">Digite a
								senha</label>
						</h5>
						<input name="senhaUser" type="password" id="senhaUser"
							class="input" maxlength="50" size="50" />
					</div>

					<input type="hidden" name="nomeUser" value="nome"> <input
						type="hidden" name="sobrenomeUser" value="sobrenome"> <input
						type="hidden" name="cpfUser" value="00000000000"> <input
						type="hidden" name="telefoneUser" value="1234">

				</div>

				<a href="${contextPath}/cadastro-novo-user">Clique aqui para se
					cadastrar...</a> <input type="submit" class="btn" value="LOGIN">

			</form>

		</div>

	</div>

	<script type="text/javascript"
		src="${contextPath}/js/login-cadastro.js"></script>

</body>

</html>