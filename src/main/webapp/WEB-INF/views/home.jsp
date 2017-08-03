<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<a href="/cadastroPaciente" style="padding-left: 5px">Cadastrar novo paciente</a>
	<a href="/listaPacientes" style="padding-left: 5px">Listar pacientes</a>
	<hr>
	<a href="#">Cadastrar novo Exame</a>
	<a href="#">Listar exames</a>
</body>
</html>