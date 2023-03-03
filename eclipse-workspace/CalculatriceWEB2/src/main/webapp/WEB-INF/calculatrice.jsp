<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculatrice</title>
</head>
<body>
	<form action="CalculatriceServlet" method="POST">
		<input type="number" name="a"/>
		<input type="number" name="b"/>
		<input type="submit" name="BT_PLUS" value="+"/>
		<input type="submit" name="BT_MOINS" value="-"/>
		<input type="submit" name="BT_FOIS" value="*"/>
		<input type="submit" name="BT_DIV" value="/"/>
	</form>
	<H4 style="color:red">${model.message}</H4>
	<H4>Le résutlat est ${model.resultat}</H4>
	<c:forEach items="${model.historique}" var="calcul">
		<p>${calcul.a}${calcul.op}${calcul.b}=${calcul.res}</p>
	</c:forEach>
	
</body>
</html>