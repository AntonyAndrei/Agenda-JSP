/**
 * Confirmacao de Exclusao de Contato
 * @author Antony Andrei
 */
 
 function confirmar (idcon){
	let resposta = confirm("Confirma a Exclusao deste contato?");
	if (resposta === true) {
		//alert(idcon);
		window.location.href = "delete?idcon=" + idcon;
		alert("Contato Excluido com Sucesso!");
	}
}