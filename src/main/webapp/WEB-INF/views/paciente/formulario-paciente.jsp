<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h3>Cadastrar Paciente</h3>
	<form action="/adicionaPaciente" method="post">
		Nome do paciente: <br /> 
		<input type="text" name="nome"> 
		<br />Idade: <br />
		<input type="number" name="quantity" min="0" max="200"> 
			
		<br />Sexo: <br />
		<input type="radio" name="sexo" value="masculino" checked> Masculino<br>
		<input type="radio" name="gender" value="feminino"> Feminino<br>
 
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>