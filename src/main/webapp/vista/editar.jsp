<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Persona</title>
</head>
<body>
<h1>Actualizar Persona</h1>
	<form action="adminPersona?action=editar" method="post" >
		<table>
			<tr>
				<td><label>Cédula</label></td>
				<td><input type="number" name="id" value='<c:out value="${persona.idpersona}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Nombre</label></td>
				<td><input type="text" name="nombre" value='<c:out value="${persona.nombre}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Teléfono</label></td>
				<td><input type="number" name="telefono" value='<c:out value="${persona.telefono}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Fecha nacimiento</label></td>
				<td><input type="date" name="fechaNac" value='<c:out value="${persona.fechaNac }"></c:out>' ></td>
			</tr>
		
		</table>
	
		<input type="submit" name="editar" value="Editar"> 
	</form>

</body>
</html>