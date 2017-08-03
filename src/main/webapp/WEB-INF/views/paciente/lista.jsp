<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<body>
  
  <a href="/cadastroPaciente">Adicionar outro paciente</a> 

  <br /> <br />        

  <table>
  <tr>
    <th>Id</th>
    <th>Nome</th>
    <th>Idade</th>
    <th>Sexo</th>
  </tr>
  <c:forEach items="${pacientes}" var="paciente">
    <tr>
      <td>${paciente.id}</td>
      <td>${paciente.nome}</td>
      <td>${paciente.idade}</td>
      <td>${paciente.sexo}</td>
      <td><a href="/removePaciente?id=${paciente.id}">Remover</a></td>
      <td><a href="/mostraPaciente?id=${paciente.id}">Alterar</a></td>
    </tr>
  </c:forEach>
  </table>
</body>
</html>