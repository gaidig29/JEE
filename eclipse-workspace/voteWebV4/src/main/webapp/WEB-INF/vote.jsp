<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Peux tu voter?</title>
</head>
<body>
<form action="VoteServlet" method="POST">
	NOM:<input type="text" name="nom" value="${votant.nom}"/><br>
	PRENOM:<input type="text" name="prenom" value="${votant.prenom}"/><br>
	DATE NAISSANCE:<input type="date" name="ddn" value="${votant.ddn}"/><br>
	NATIONALITE:<input type="text" name="nationalite" value="${votant.nationalite}"/><br>
	<input type="submit" name="BT_VALID" value="valider"/>
</form>
<h4>${message}</h4>
</body>
</html>