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

<title>Início</title>

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
<link href="${contextPath}/css/home.css" rel="stylesheet">
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
							class="nav-link active  text-danger  " aria-current="page"
							href="${contextPath}/home">INÍCIO</a></li>
						<li class="nav-item"><a class="nav-link text-muted" href="${contextPath}/pesquisa-despesas">PESQUISAR
								DESPESAS</a></li>
						<li class="nav-item"><a class="nav-link text-muted"
							href="${contextPath}/tabela-checagem">TABELA DE CHECAGEM</a></li>

						<li class="nav-item"><a class="nav-link text-muted"
							href="${contextPath}/" tabindex="-1" aria-disabled="true">SAIR</a></li>
					</ul>
				</div>
			</div>
		</nav>


	</header>

	<section class="conteudo container-fluid">

		<div class=" container clearfix">
			<img src="${contextPath}/images/tce-home.png"
				class="col-md-6 float-md-end mb-3 ms-md-3 img-fluid" alt="...">

			<h3 class="text-center mb-5 fs-2">SOBRE O SITE</h3>

			<p>Este site é fruto de uma parceria entre o TCESP e o grupo Tec
				Tec Tech de alunos da FIAP (Faculdade de Informática e Administração
				Paulista). Ele faz parte do Projeto ForeverA1.</p>

			<p>Utilizando o menu no lado esquerdo da tela é possível
				pesquisar despesas de munícipios do estado de São Paulo através da
				opção "PESQUISAR DESPESAS".</p>

			<p>A opção "TABELA DE CHECAGEM" abre uma página tabela editável
				para manter o controle de quais munícipios tiveram suas despesas
				checadas, quais estão com problemas, etc.</p>
			<p>O "Acesso Rápido" abaixo permite chegar até outras redes do
				TCESP de maneira ágil e prática.</p>
		</div>

		<footer class="footer">

			<div class="card text-center">
				<div class="titulo-acesso">
					<h4 class="text-align-center text-light">Acesso Rápido</h4>
				</div>
				<div class="card-footer ">

					<div class="card text-center" style="width: 18rem;">
						<div class="card-body">
							<h5 class="card-title">SITE DO TCESP</h5>
							<p class="card-text">Site oficial do TCESP</p>
							<a href="https://www.tce.sp.gov.br" class="botao-mais"> <input
								class="mais" type="button" value="Mais...">
							</a>
						</div>
					</div>

					<div class="card text-center" style="width: 18rem;">
						<div class="card-body">
							<h5 class="card-title">FACEBOOK</h5>
							<p class="card-text">TCESP no Facebook</p>
							<a href="https://www.facebook.com/tcesp/" class="botao-mais">
								<input class="mais" type="button" value="Mais...">
							</a>
						</div>
					</div>

					<div class="card text-center" style="width: 18rem;">
						<div class="card-body">
							<h5 class="card-title">INSTAGRAM</h5>
							<p class="card-text">TCESP no Instagram</p>
							<a href="https://www.instagram.com/tcesp/?hl=pt"
								class="botao-mais"> <input class="mais" type="button"
								value="Mais...">
							</a>
						</div>
					</div>
				</div>
		</footer>

		</div>

	</section>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
		crossorigin="anonymous"></script>

</body>

</html>