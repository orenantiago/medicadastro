<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<body>
  <c:import url="../cabecalho.jsp" />
  <a href="/cadastroExame">Adicionar outro exame</a> 

  <br /> <br />        

  <table>
  <tr>
    <th>Id</th>
    <th>Nome</th>
    <th>Descricao</th>
    <th>Data</th>
    <th>Paciente</th>
  </tr>
  <c:forEach items="${exames}" var="exame">
    <tr>
      <td>${exame.id}</td>
      <td>${exame.nome}</td>
      <td>${exame.descricao}</td>
      <td><fmt:formatDate value="${exame.data.time}"
						pattern="dd/MM/yyyy" /></td>
      <td>${exame.paciente.nome}</td>
      <td><a href="/removeExame?id=${exame.id}">Remover</a></td>
      <td><a href="/mostraExame?id=${exame.id}">Alterar</a></td>
    </tr>
  </c:forEach>
  </table>
</body>
</html>