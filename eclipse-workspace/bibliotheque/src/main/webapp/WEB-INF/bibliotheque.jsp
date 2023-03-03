<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BIBLIOTHEQUE</title>
</head>
<body>
	<form action="BibliothequeServlet">
	<c:forEach items="${model.lstAuteur}" var="auteur">
	<h4>${auteur.nom} ${auteur.prenom}</h4>
		<c:forEach items="${model.lstLivre}" var="livre">
		<p>${livre.titre} ${livre.resume} </p>
		</c:forEach>
	</c:forEach>
	
	</form>
</body>
</html>