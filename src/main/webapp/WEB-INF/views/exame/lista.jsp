<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<body>
  
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
  <c:forEach items="${exames}" var="exames">
    <tr>
      <td>${exames.id}</td>
      <td>${exames.nome}</td>
      <td>${exames.descricao}</td>
      <td><fmt:formatDate value="${exames.data.time}"
						pattern="dd/MM/yyyy" /></td>
      <td>${exames.paciente.getnome}</td>
    </tr>
  </c:forEach>
  </table>
</body>
</html>