<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Persona</title>
</head>
<body>
	<h1>Registrar Persona</h1>
	<form action="adminPersona?action=register" method="post">
		<table border="1" align="center">
		<tr>
			<td>C?dula:</a></td>		
			<td><input type="number" name="id"/></td>	
		</tr>
		<tr>
			<td>Nombre:</a></td>		
			<td><input type="text" name="nombre"/></td>	
		</tr>
		<tr>
			<td>Tel?fono:</a></td>		
			<td><input type="number" name="telefono"/></td>	
		</tr>
		<tr>
			<td>Fecha nacimiento:</a></td>		
			<td><input type="date" name="fechaNac"/></td>	
		</tr>		
		
	</table>
	<br>
	<table border="0" align="center">
		<tr>
		<td><input type="submit" value="Agregar" name="agregar"></td>	
		</tr>
	
	</form>
</body>
</html>