<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>

<c:set value="${pageContext.request.contextPath}" var="contextPath" />

<title>TCESP - Cadastro Novo Usuário</title>
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

			<form:form modelAttribute="usuarioModel"
				action="${contextPath}/cadastrar-usuario" method="post">

				<img src="${contextPath}/images/tce-logo.png">

				<h2 class="title">Preencha os dados</h2>

				<spring:hasBindErrors name="usuarioModel">
					<div class="alert alert-danger" role="alert">
						<font color="red"><form:errors path="*" class="has-error" /></font>
					</div>
				</spring:hasBindErrors>

				<br>

				<div class="input-div one">

					<div class="i">
						<i class="fas fa-user"></i>
					</div>

					<div class="div">
						<h5>
							<label class="control-label" for="nomeUser">Digite o nome</label>
						</h5>
						<form:input type="text" path="nomeUser" id="nomeUser"
							class="input" maxlength="50" size="50" />
					</div>

				</div>

				<div class="input-div one">

					<div class="i">
						<i class="fas fa-address-card"></i>
					</div>

					<div class="div">
						<h5>
							<label class="control-label" for="sobrenomeUser">Digite o
								sobrenome</label>
						</h5>
						<form:input type="text" path="sobrenomeUser" id="sobrenomeUser"
							class="input" maxlength="100" size="100" />
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
						<form:input type="password" path="senhaUser" id="senhaUser"
							class="input" maxlength="50" size="50" />
					</div>

				</div>

				<div class="input-div ">

					<div class="i">
						<i class="fas fa-envelope"></i>
					</div>

					<div class="div">
						<h5>
							<label class="control-label" for="emailUser">Digite o
								e-mail</label>
						</h5>
						<form:input type="email" path="emailUser" id="emailUser"
							class="input" maxlength="70" size="70" />
					</div>

				</div>

				<div class="input-div ">

					<div class="i">
						<i class="fas fa-phone"></i>
					</div>

					<div class="div">
						<h5>
							<label class="control-label" for="telefoneUser">Digite o
								telefone</label>
						</h5>
						<form:input type="tel" path="telefoneUser" id="telefoneUser"
							class="input" />
					</div>

				</div>

				<div class="input-div ">

					<div class="i">
						<i class="fas fa-id-card-alt"></i>
					</div>

					<div class="div">
						<h5>
							<label class="control-label" for="cpfUser">Digite o CPF</label>
						</h5>
						<form:input type="text" path="cpfUser" id="cpfUser" class="input"
							maxlength="11" size="11" />
					</div>

				</div>

				<a href="${contextPath}/">Já tem conta? Faça seu login...</a>
				<input type="submit" class="btn" value="CADASTRAR">

			</form:form>

		</div>

	</div>

	<script type="text/javascript"
		src="${contextPath}/js/login-cadastro.js"></script>

</body>

</html>