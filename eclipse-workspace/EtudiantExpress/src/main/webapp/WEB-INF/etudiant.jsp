<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ECF</title>
</head>
<body>
	<form action="EtudiantServlet">
		<input type="text" name="nom"/>
		<input type="text" name="prenom"/>
		<input type="number" name="note"/>
		<input type="submit" name="BT_VALID" value="Ajouter"/>
	</form>
	<h4>liste des étudiants</h4>
	<c:forEach items="${model.lstEtudiants}" var="etudiant">
		<p>${etudiant.idEtudiant} : ${etudiant.nom} ${etudiant.prenom} ${etudiant.note} </p>
	</c:forEach>

	<h4>liste des étudiants au rattrapage</h4>
	<c:forEach items="${model.lstRattrapage}" var="etudiant">
		<p>${etudiant.idEtudiant} : ${etudiant.nom} ${etudiant.prenom} ${etudiant.note} </p>
	</c:forEach>
	
	<h4>le meilleur : ${model.meilleur.prenom} ${model.meilleur.nom}</h4>
	<h4>le moins bon : ${model.moinsBon.prenom} ${model.moinsBon.nom}</h4>
	<h4>la moyenne : ${model.moyenne}</h4>
</body>
</html>