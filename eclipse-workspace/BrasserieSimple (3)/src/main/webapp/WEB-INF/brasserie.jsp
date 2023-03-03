<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des brasseries</title>
</head>
<body>
<h3 style="color:red">${model.erreur}</h3>
<form action="BrasserieServlet" method="POST">
	<input type="hidden" name="idModify" value="${model.idModify}"/>
	<input type="text" name="nom" value="${model.current.nom}"/>
	<input type="text" name="adresse" value="${model.current.adresse}"/>
	<input type="text" name="ville" value="${model.current.ville}"/>
	<input type="submit" name="BT_VALID" value="valider"/>
</form>
<c:forEach items="${model.lstBrasseries}" var="brasserie">
	<p>${brasserie.idBrasserie} : ${brasserie.nom} ${brasserie.adresse} ${brasserie.ville} 
	<a href="BrasserieServlet?BT_DELETE=${brasserie.idBrasserie}">X</a>
	<a href="BrasserieServlet?BT_MODIFY=${brasserie.idBrasserie}">M</a></p>
</c:forEach>

</body>
</html>