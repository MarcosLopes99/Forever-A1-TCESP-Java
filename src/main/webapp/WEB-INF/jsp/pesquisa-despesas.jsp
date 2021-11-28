<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="pt-br">

<head>

<c:set value="${pageContext.request.contextPath}" var="contextPath" />

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">

<title>Pesquisa de Despesas de Municípios</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">

<!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Our project just needs Font Awesome solid + brand -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

<!-- Custom styles for this template -->
<link href="${contextPath}/css/pesquisa.css" rel="stylesheet">

<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.4.2/chosen.jquery.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.4.2/chosen.css">

</head>

<body>

<script type="text/javascript">
$(function() {
    $(".chosen").chosen();
});
</script>

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
						<li class="nav-item "><a class="nav-link text-muted  "
							aria-current="page" href="${contextPath}/home">INÍCIO</a></li>
						<li class="nav-item "><a class="nav-link active  text-danger"
							href="${contextPath}/pesquisa-despesas">PESQUISAR DESPESAS</a></li>
						<li class="nav-item"><a class="nav-link text-muted"
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
			<div class="mt-5">

				<h1 class="text-center">PREENCHA OS DADOS</h1>

			</div>

			<footer class="forms">

				<form:form modelAttribute="pesquisaModel"
					action="${contextPath}/pesquisa-despesas/resultado" method="get">

					<spring:hasBindErrors name="pesquisaModel">
						<div class="alert alert-danger" role="alert">
							<font color="red">Preencha todos os campos corretamente!</font>
						</div>
					</spring:hasBindErrors>

					<div class="mb-5">
						<form:select class="form-select chosen" id="municipio"
							aria-label="Example select with button addon" path="municipio">
							<form:option selected="true" disabled="true" value="">Selecione o Município...</form:option>
							<form:option value="bauru">Bauru</form:option>
							<form:option value="campinas">Campinas</form:option>
							<form:option value="carapicuiba">Carapicuíba</form:option>
							<form:option value="diadema">Diadema</form:option>
							<form:option value="guaruja">Guarujá</form:option>
							<form:option value="guarulhos">Guarulhos</form:option>
							<form:option value="itaquaquecetuba">Itaquaquecetuba</form:option>
							<form:option value="jundiai">Jundiaí</form:option>
							<form:option value="maua">Mauá</form:option>
							<form:option value="mogi-das-cruzes">Mogi das Cruzes</form:option>
							<form:option value="osasco">Osasco</form:option>
							<form:option value="piracicaba">Piracicaba</form:option>
							<form:option value="ribeirao-preto">Ribeirão Preto</form:option>
							<form:option value="santo-andre">Santo André</form:option>
							<form:option value="santos">Santos</form:option>
							<form:option value="sao-bernardo-do-campo">São Bernardo do Campo</form:option>
							<form:option value="sao-jose-do-rio-preto">São José do Rio Preto</form:option>
							<form:option value="sao-jose-dos-campos">São José dos Campos</form:option>
							<form:option value="sorocaba">Sorocaba</form:option>
							<form:option value="suzano">Suzano</form:option>
						</form:select>
					</div>

					<div class="input-group mb-5">
						<form:select class="form-select" id="exercicio"
							aria-label="Example select with button addon" path="exercicio">
							<form:option selected="true" disabled="true" value="">Selecione o Ano...</form:option>
							<form:option value="2014">2014</form:option>
							<form:option value="2015">2015</form:option>
							<form:option value="2016">2016</form:option>
							<form:option value="2017">2017</form:option>
							<form:option value="2018">2018</form:option>
							<form:option value="2019">2019</form:option>
							<form:option value="2020">2020</form:option>
							<form:option value="2021">2021</form:option>
						</form:select>
					</div>

					<div class="input-group mb-5">
						<form:select class="form-select" id="mes"
							aria-label="Example select with button addon" path="mes">
							<form:option selected="true" disabled="true" value="">Selecione o Mês...</form:option>
							<form:option value="1">Janeiro</form:option>
							<form:option value="2">Fevereiro</form:option>
							<form:option value="3">Março</form:option>
							<form:option value="4">Abril</form:option>
							<form:option value="5">Maio</form:option>
							<form:option value="6">Junho</form:option>
							<form:option value="7">Julho</form:option>
							<form:option value="8">Agosto</form:option>
							<form:option value="9">Setembro</form:option>
							<form:option value="10">Outubro</form:option>
							<form:option value="11">Novembro</form:option>
							<form:option value="12">Dezembro</form:option>
						</form:select>
					</div>

					<div class="d-grid gap-2 mx-auto">
						<input type="submit" class="btn btn-danger" value="PESQUISAR">
					</div>

				</form:form>

			</footer>

		</section>

	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>

	<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>
