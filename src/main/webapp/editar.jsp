<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Contato</title>
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
</head>
<body>
	<div class="layout">
		<div class="layoutDentro">
			<h1>Editar o Contato</h1>
			<form action="update" name="frmContato">
				<table class="Contato">
					<tr>
						<td><input type="text" name="idcon" class="Caixa3"
							readonly="readonly"
							value="<%out.print(request.getAttribute("idcon"));%>"></td>
					</tr>
					<tr>
						<td><input type="text" name="nome" class="Caixa1"
							value="<%out.print(request.getAttribute("nome"));%>"></td>
					</tr>
					<tr>
						<td><input type="text" name="fone" class="Caixa2"
							value="<%out.print(request.getAttribute("fone"));%>"></td>
					</tr>
					<tr>
						<td><input type="text" name="email" class="Caixa1"
							value="<%out.print(request.getAttribute("email"));%>"></td>
					</tr>
				</table>
				<input type="button" value="Salvar" class="Botao1"
					onclick="validar()">
			</form>
		</div>
	</div>

	<script type="text/javascript" src="scripts/validador.js"></script>

</body>
</html>