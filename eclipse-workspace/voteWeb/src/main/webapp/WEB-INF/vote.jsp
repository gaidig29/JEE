<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Peux tu voter ?</title>
</head>
<body>
<form action="VoteServlet" method="POST">
	Nom : <input type="text" nom="nom" value="${votant.nom}"/></br>
	Prenom : <input type="text" nom="prrenom" value="${votant.prenom}"/></br>
	Date : <input type="text" nom="date" value="${votant.ddn}"/></br>
	Nationalite : <input type="text" nom="nationalite" value="${votant.nationalite}"/></br>
	<input type="submit" name="BT_VALID" value="valider"/>
</form>
<H4>${resultat}</H4>
</body>
</html>