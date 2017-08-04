<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Alterar Exame</title>
</head>
<body>
	<c:import url="../cabecalho.jsp" />
	<h3>Alterar Exame</h3>
	<form action="/alteraExame" method="post">
		<input type="hidden" name="id" value="${exame.id}" />
		Nome do exame: <br /> 
		<input type="text" name="nome" value="${exame.nome}"> 
		
		<br />Descricao<br /> 
		<textarea name="descricao" rows="5" cols="80"></textarea>

		<br />Paciente: 
		<select name="paciente">
		<c:forEach items="${pacientes}" var="paciente">
			<option name="paciente" value="${paciente}">${paciente.id} - ${paciente.nome}</option>
		</c:forEach>
		</select> 
		<input type="submit" value="Alterar">
	</form>
</body>
</html>