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

<title>Resultado da Pesquisa</title>
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
							href="${contextPath}/home"> INÍCIO </a></li>
						<li class="nav-item  "><a class="nav-link text-danger"
							href="${contextPath}/pesquisa-despesas">PESQUISAR DESPESAS</a></li>
						<li class="nav-item"><a class="nav-link   text-muted"
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
				<a href="${contextPath}/pesquisa-despesas"
					class="btn  btn-outline-danger"> <i class="fa fa-arrow-left"></i>
					VOLTAR
				</a>
				</button>

				<h1 class="text-center mt-5">RESULTADO DA PESQUISA:</h1>

				<footer class="tabela table-responsive">

					<c:choose>
						<c:when test="${empty despesas}">
							<div class="alert alert-danger d-flex align-items-center my-5"
								role="alert">
								<span class=" fa fa-times"></span>
								<div>Não há resultados para a pesquisa!</div>
							</div>
							<br>
							<br>
						</c:when>
						<c:otherwise>

							<table class="table  align-middle ">

								<thead class="bg-danger text-light mb-3">
									<tr>
										<th scope="col">#</th>
										<th scope="col">Orgão</th>
										<th scope="col">Mês</th>
										<th scope="col">Evento</th>
										<th scope="col">Número Empenho</th>
										<th scope="col">ID Fornecedor</th>
										<th scope="col">Nome Fornecedor</th>
										<th scope="col">Data Emissão Despesa</th>
										<th scope="col">Valor da Despesa (R$)</th>
									</tr>
								</thead>

								<tbody>

									<c:set var="count" value="0" scope="page" />
									<c:forEach items="${despesas}" var="despesa">

										<tr class="mb-3">
											<td><c:set var="count" value="${count + 1}" scope="page" />${count}</td>
											<!-- ORGAO -->
											<td>${despesa.orgao}</td>
											<!-- MES -->
											<td>${despesa.mes}</td>
											<!-- EVENTO -->
											<td>${despesa.evento}</td>
											<!-- NUMERO EMPENHO -->
											<td>${despesa.nr_empenho}</td>
											<!-- ID FORNECEDOR -->
											<td>${despesa.id_fornecedor}</td>
											<!-- NOME FORNECEDOR -->
											<td>${despesa.nm_fornecedor}</td>
											<!-- DATA DE EMISSAO DESPESA -->
											<td>${despesa.dt_emissao_despesa}</td>
											<!-- VALOR DESPESA -->
											<td>${despesa.vl_despesa}</td>
										</tr>

									</c:forEach>
									</c:otherwise>
									</c:choose>

								</tbody>

							</table>
				</footer>
		</section>

	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>

</body>
</html>
