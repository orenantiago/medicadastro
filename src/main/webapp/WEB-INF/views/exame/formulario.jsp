<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Cadastrar Exame</title>
</head>
<body>
	<c:import url="../cabecalho.jsp" />
	<h3>Cadastrar Exame</h3>
	<form action="/adicionaExame" method="post">
		Nome do exame: <br /> 
		<input type="text" name="nome"> 
		
		<br />Descricao<br /> 
		<textarea name="descricao" rows="5" cols="80"></textarea>

		 <br />Paciente: 
		<select name="paciente">
		<c:forEach items="${pacientes}" var="paciente">
			<option name="idPaciente" value="${paciente.id}">${paciente.id} - ${paciente.nome}</option>
		</c:forEach>
		</select>
		<input type="date" name="data">
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>