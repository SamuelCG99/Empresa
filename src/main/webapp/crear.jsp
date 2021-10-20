<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Crear Producto</h1>
 <form action="MainController" method="post">
  <input type="hidden" name="opcion" value="guardar">
  <table border="1">
   <tr>
   <tr>
    <td>Nombre:</td>
    <td><input type="text" name="nombre" size="50"></td>
   </tr>
   <tr>
    <td>DNI:</td>
    <td><input type="text" name="dni" size="50"></td>
   </tr>
   <tr>
    <td>Sexo:</td>
    <td><input type="text" name="sexo" size="50"></td>
   </tr>
   <tr>
    <td>Categoria:</td>
    <td><input type="text" name="categoria" size="50"></td>
   </tr>
   <tr>
    <td>Años:</td>
    <td><input type="text" name="annyo" size="50"></td>
   </tr>
  </table>
  <input type="submit" value="Guardar">
 </form>
</body>
</html>