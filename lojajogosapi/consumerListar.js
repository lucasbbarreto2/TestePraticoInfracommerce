$(function() {
	$(".js-load-games").on('click', function(){
		$.ajax ({
				url:"http://localhost:8080/jogos",
				type: "get",
				headers: {
					"Authorization" : "Basic bHVjYXNiYmFycmV0bzoxMjM0NQ=="
				},
				success: function(response) {
					desenhaTabela(response);
				}
		});
	})
});

 function desenhaTabela(dados){
	 $(".js-games-table-body tr").remove();
	 
	 for(var i=0; i< dados.length; i++){
		 desenhaLinha(dados[i]);
	 }
 }
 
 function desenhaLinha(linha){
	 var linhaTabela = $("<tr/>");
	 $(".js-games-table-body").append(linhaTabela);
	 linhaTabela.append("<td>" + linha.id + "</td>");
	 linhaTabela.append("<td>" + linha.nome + "</td>");
	 linhaTabela.append("<td>" + linha.categoria + "</td>");
	 linhaTabela.append("<td>" + linha.descricaoLonga + "</td>");
 }
