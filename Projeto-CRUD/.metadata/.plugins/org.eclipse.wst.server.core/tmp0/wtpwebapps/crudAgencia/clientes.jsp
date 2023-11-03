<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read and Delete</title>
<!-- Inclua o link para o Bootstrap via CDN -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="text-center">
    <!-- Cabeçalho -->
    <header>
        <nav class="navbar navbar-expand-lg navbar-primary bg-dark text-primary">
            <div class="container">
                <a class="navbar-brand" href="#"> </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="./index.html">Home</a>
                        </li>
                       <li class="nav-item">
                            <a class="nav-link" href="cadastro.jsp">Cadastros</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ReadController">Lista de clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#sobre">Sobre</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#contato">Contato</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
	<h1 class="mt-5">Lista de Clientes</h1>
	<div class="container mt-5">
	<a href="./cadastro.jsp" class="btn btn-primary mb-5">Criar novo</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Login</th>
					<th>Senha</th>
					<th>Data de Nascimento</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clients}" var="client">
					<tr>
						<td>${client.id}</td>
						<td>${client.nome}</td>
						<td>${client.login}</td>
						<td>${client.senha}</td>
						<td>${client.dataNasc}</td>
						<td>
							<a href="UpdateController?id=${client.id}" class="btn btn-success">Editar</a>
							<a href="DeleteController?id=${client.id}" onClick = "excluir()" 
							class="btn btn-danger">Excluir</a>
					</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

    <footer class="bg-dark text-light text-center py-3 fixed-bottom">
        &copy; 2023 TravelTrails. Todos os direitos reservados.
    </footer>
	
	<script>
	function excluir(){
		window.confirm("Deseja excluir mesmo?");
	}
	</script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>