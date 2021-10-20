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
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Producto</title>
</head>
<body>
 <h1>Editar Producto</h1>
 <form action="MainController" method="post">
  <c:set var="empleado" value="${empleado}"></c:set>
  <input type="hidden" name="opcion" value="editar">
  <input type="hidden" name="id" value="${empleado.id}">
  <table border="1">
   <tr>
    <td>Nombre:</td>
    <td><input type="text" name="nombre" size="50" value="${empleado.nombre}"></td>
   </tr>
   <tr>
    <td>Dni:</td>
    <td><input type="text" name="dni" size="50" value="${empleado.dni}"></td>
   </tr>
   <tr>
    <td>Sexo:</td>
    <td><input type="text" name="sexo" size="50" value="${empleado.sexo}"></td>
   </tr>
      <tr>
    <td>Categoria:</td>
    <td><input type="text" name="categoria" size="50" value="${empleado.categoria}"></td>
   </tr>
      <tr>
    <td>Años:</td>
    <td><input type="text" name="annyo" size="50" value="${empleado.annyo}"></td>
   </tr>
  </table>
  <input type="submit" value="Guardar">
 </form>
</body>
</html>