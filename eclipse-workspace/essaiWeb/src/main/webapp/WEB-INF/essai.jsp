<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="HelloServlet" method="POST">
		Nom de famille:<input type="text" name="nomFamille"></br> 
		Age:<input type="number" name="age"></br> 
		Nationalité:
		<select name="nationalite" id="nationalite">
			<option value="">--Please choose an option--</option>
			<option value="France">Français</option>
			<option value="Allemagne">Allemand</option>
		</select> </br>
		 <input type="checkbox" name="judiciaire" required> Je certifie avoir un casier judiciaire vierge Sexe :</br>
		<input type="radio" value="Masculin" name="sexe">Masculin 
		<input type="radio" value="Feminin" name="sexe">Féminin </br> 
		<input type="submit" name="BT_CALC" value="calculer">

	</form>
	<h1>Resultat :</h1>
	${resultat}
</body>
</html>