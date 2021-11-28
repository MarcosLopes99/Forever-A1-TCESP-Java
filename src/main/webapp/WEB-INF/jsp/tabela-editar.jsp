<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="pt-br">

<head>

<c:set value="${pageContext.request.contextPath}" var="contextPath" />

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">

<title>Editar Município</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Our project just needs Font Awesome solid + brand -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

<!-- Custom styles for this template -->
<link href="${contextPath}/css/tabela.css" rel="stylesheet">

</head>

<body>

	<header>

		<nav class="navbar navbar-expand-sm bg-light  navbar-dark header ">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"><img
					src="${contextPath}/images/tce-logo2.png" alt=""></a>
				<button class="navbar-toggler   bg-dark" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse justify-content-end"
					id="navbarNav">
					<ul class=" navbar-nav nav ">
						<li class="nav-item "><a
							class="nav-link active  text-muted  " aria-current="page"
							href="${contextPath}/home">INÍCIO</a></li>
						<li class="nav-item  "><a class="nav-link text-muted  "
							href="${contextPath}/pesquisa-despesas">PESQUISAR DESPESAS</a></li>
						<li class="nav-item"><a class="nav-link text-danger"
							href="${contextPath}/tabela-checagem">TABELA DE CHECAGEM</a></li>

						<li class="nav-item"><a class="nav-link text-muted"
							href="${contextPath}/" tabindex="-1" aria-disabled="true">SAIR</a></li>
					</ul>
				</div>
			</div>
		</nav>

	</header>

	<main>

		<section class="container container-fluid">
			<div class="mt-5 mb-5">

				<h1 class="text-center text-muted">ALTERE O STATUS DO
					MUNICÍPIO:</h1>

				<spring:hasBindErrors name="municipioModel">
					<div class="alert alert-danger" role="alert">
						<font color="red"><form:errors path="*" class="has-error" /></font>
					</div>
				</spring:hasBindErrors>

			</div>

			<div class="container mb-5">
				<h3 class="text-align-center text-muted">NOME:
					${municipioModel.nomeMunicipio}</h3>
				<h3 class="text-align-center text-muted">
					ÚLTIMA CHECAGEM:
					<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss"
						value="${municipioModel.ultimaChecagemMunicipio}" />
				</h3>
				<h3 class="text-align-center text-muted">RESPONSÁVEL PELA
					CHECAGEM: ${municipioModel.userResponsavel.nomeUser}
					${municipioModel.userResponsavel.sobrenomeUser} | ID:
					${municipioModel.userResponsavel.idUser}</h3>
				<h3 class="text-align-center text-muted">
					STATUS DE CHECAGEM ATUAL: ${municipioModel.statusChecagemMunicipio}
					|
					<c:choose>
						<c:when
							test="${municipioModel.statusChecagemMunicipio=='CHECADO'}">
							<span class=" fa fa-check"></span>
						</c:when>
						<c:when
							test="${municipioModel.statusChecagemMunicipio=='NAO CHECADO'}">
							<span class=" fa fa-times"></span>
						</c:when>
						<c:otherwise>
							<span class=" fa fa-exclamation-triangle"></span>
						</c:otherwise>
					</c:choose>
				</h3>
			</div>

			<div class="container">
				<table class="table table-light table-borderless table-responsive">
					<thead>
						<tr>
							<th scope="col">STATUS</th>
							<th scope="col">DESCRIÇÃO</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row"><span class=" fa fa-check"></span></th>
							<td>Caso o município já TENHA sido checado e NÃO APRESENTA
								inconsistências</td>
						</tr>
						<tr>
							<th scope="row"><span class=" fa fa-times"></span></th>
							<td>Caso o município NÃO TENHA sido checado</td>
						</tr>
						<tr>
							<th scope="row"><span class=" fa fa-exclamation-triangle"></span></th>
							<td>Caso o município TENHA sido checado e APRESENTA
								inconsistências</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="container mt-5">
				<form:form modelAttribute="municipioModel"
					action="${contextPath}/tabela-checagem/${municipioModel.idMunicipio}"
					method="put">

					<div class="input-group mb-5">
						<form:select class="form-select" id="inputGroupSelect04"
							aria-label="Example select with button addon"
							path="statusChecagemMunicipio">
							<form:option disabled="true" value="">Selecione o Status do município...</form:option>
							<form:option value="CHECADO">CHECADO</form:option>
							<form:option value="NAO CHECADO">NAO CHECADO</form:option>
							<form:option value="INCONSISTENCIAS">INCONSISTENCIAS</form:option>
						</form:select>
					</div>
			</div>

			<form:input type="hidden" path="nomeMunicipio" id="nomeMunicpio"
				value="${municipioModel.nomeMunicipio}" />
			<form:input type="hidden" path="ultimaChecagemMunicipio"
				id="ultimaChecagemMunicipio"
				value="${municipioModel.ultimaChecagemMunicipio}" />

			<div class="d-grid gap-2 mb-3 mx-auto">
				<input type="submit" class="btn btn-danger"
					value="CONCLUIR ALTERAÇÃO">
			</div>

			</form:form>

			<div class="d-grid gap-2 mx-auto">
				<a href="${contextPath}/tabela-checagem" class="btn btn-danger">
					VOLTAR </a>
			</div>
		</section>
	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>

</body>
</html>
