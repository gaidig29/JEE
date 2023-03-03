<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculatrice</title>
</head>
<body>
	<form action="CalculatriceServlet" method="POST">
		a : <input type="text" name="a" /><br> 
		b : <input type="text"name="b" /><br>
		Opération : <br>
		<input type="radio" name="op" value="plus"/>+<br>
		<input type="radio" name="op" value="fois"/>*<br>
		<input type="radio" name="op" value="moins"/>-<br>
		<input type="radio" name="op" value="div"/>/
		<br>
		
		<input type="submit" name="BT_VALID" value="valider" />
	</form>
	<H4>${resultat}</H4>
</body>
</html>