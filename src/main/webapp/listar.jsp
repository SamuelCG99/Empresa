<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Listar Empleados</h1>
 <table border="1">
  <tr>
   <td>Id</td>
   <td>Nombre</td>
   <td>Dni</td>
   <td>Sexo</td>
   <td>Categoria</td>
   <td>Años</td>
   <td>Accion</td>
  </tr>
  <c:forEach var="empleado" items="${lista}">
  <tr>
    <td>
     <a href="MainController?opcion=editar&id=<c:out value="${empleado.id}"></c:out>">
      <c:out value="${empleado.id}"></c:out>
     </a>
    </td>
    <td><c:out value="${empleado.nombre}"></c:out></td>
    <td><c:out value="${empleado.dni}"></c:out></td>
    <td><c:out value="${empleado.sexo}"></c:out></td>
    <td><c:out value="${empleado.categoria}"></c:out></td>
    <td><c:out value="${empleado.annyo}"></c:out></td>
    <td>
     <a href="MainController?opcion=eliminar&id=<c:out value="${empleado.id}"></c:out>">
      Eliminar 
     </a>
    </td>
  </tr>
  </c:forEach>
 </table>
</body>
</html>