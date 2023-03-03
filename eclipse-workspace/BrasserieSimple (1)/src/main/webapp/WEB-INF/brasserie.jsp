<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des brasseries</title>
</head>
<body>
<form action="BrasserieServlet" method="POST">
	<input type="text" name="nom" value="${model.current.nom}"/>
	<input type="text" name="adresse" value="${model.current.adresse}"/>
	<input type="text" name="ville" value="${model.current.ville}"/>
	<input type="submit" name="BT_VALID" value="valider"/>
</form>
<c:forEach items="${model.lstBrasseries}" var="brasserie">
	<p>${brasserie.nom} ${brasserie.adresse} ${brasserie.ville}</p>
</c:forEach>


</body>
</html>