<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="exo1" method="POST">
	a:<input type="number" name="a"></br>
	b:<input type="number" name="b"></br>
	operation:<input type="text" name="op"></br>
	<input type="submit" name="BT_CALC" value="calculer">
	
</form>
<h1>resultat :</h1>
${resultat}
</body>
</html>