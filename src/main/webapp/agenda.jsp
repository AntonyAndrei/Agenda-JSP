<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="layout">
		<div class="layoutDentro">
			<h1>Contatos Cadastrados</h1>
			<a href="novoContato.html" class=Botao1>Novo contato</a>
			<table class="tabela">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOME</th>
						<th>TELEFONE</th>
						<th>EMAIL</th>
						<th>OPCOES</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < lista.size(); i++) {
					%>
					<tr>
						<td><%=lista.get(i).getIdcon()%></td>
						<td><%=lista.get(i).getNome()%></td>
						<td><%=lista.get(i).getFone()%></td>
						<td><%=lista.get(i).getEmail()%></td>
						<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>"
							class="Botao1">Editar</a> <a
							href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)"
							class="Botao2">Excluir</a></td>
					</tr>
					<%}%>
				</tbody>
			</table>
		</div>
	</div>

	<script type="text/javascript" src="scripts/confirmador.js"></script>

</body>
</html>