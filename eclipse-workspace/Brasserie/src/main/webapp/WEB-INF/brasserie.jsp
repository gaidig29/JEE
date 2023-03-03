<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Brasserie</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col">
			<form action="BrasserieServlet" method="POST" class="row g-3">
		
				<h1>Ajouter une brasserie </h1></br> 
			
				<input class="form-control" type="hidden" name="idModify" id="idModify" value="${model.idModify}"/>
				 
				<label for="nomBr" class="form-label">Nom</label>
				<input class="form-control" type="text" name="nomBr" id="nomBr" value="${model.current.nom}"/>
				
				<label for="ville" class="form-label">Ville</label>
				<input class="form-control" type="text" name="ville" id="ville" value="${model.current.ville}"/>
				
				<label for="adresse" class="form-label">Adresse</label>
				<input class="form-control" type="text" name="adresse" id="adresse" value="${model.current.adresse}"/>
				
				<input type="submit" name="BT_VALIDBR" class="btn btn-success" value="Valider" />
					
				<h1>Ajouter une bière </h1></br> 
				
				<input class="form-control" type="hidden" name="idModify" id="idModify" value="${modelBi.idModify}"/>
				
				<label for="nomBi" class="form-label">Nom</label>
				<input class="form-control" type="text" name="nomBi" id="nomBi" value="${modelBi.currentBi.nom}"/></br> 
				
				<label for="c" class="form-label">Brasserie</label>
				<select class="form-select" id="c" name="brasserie">
					<c:forEach items="${model.lstBrasseries}" var="brasserie">
						<option  value="${brasserie.idBrasserie}" >${brasserie.nom}</option>
					</c:forEach>
				</select>
				
				<label for="type" class="form-label">Type</label>
				<input class="form-control" type="text" name="type" id="type" value="${modelBi.currentBi.type}"/></br> 
				
				<label for="note" class="form-label">Note</label>
				<input class="form-control" type="text" name="note" id="note" value="${modelBi.currentBi.note}"/></br> 
				
				<label for="dateIns" class="form-label">Date d'insertion</label>
				<input class="form-control" type="date" name="date" id="date" value="${modelBi.currentBi.date}"/></br> 
				
				<input type="submit" name="BT_VALIDBI" class="btn btn-success" value="Valider" />
		
			</form>
		</div>
	
		
		<div class="col" align="center">
			<h1>Liste des brasseries 				
			<a href="BrasserieServlet?BT_DELETEALL"class="btn btn-danger">Supprimer la liste</a>
			</h1></br> 

			<c:forEach items="${model.lstBrasseries}" var="brasserie">
				<p>${brasserie.nom} ${brasserie.ville} ${brasserie.adresse}
				<a href="BrasserieServlet?BT_MODIFY=${brasserie.idBrasserie}"class="btn btn-primary">Modifier</a>
				<a href="BrasserieServlet?BT_DELETE=${brasserie.idBrasserie}"class="btn btn-danger">Supprimer</a>
				</p>
			</c:forEach>
			
			<h1>Liste des bières 
				<a href="BrasserieServlet?BT_DELETEALLBI"class="btn btn-danger">Supprimer la liste</a>
			</h1></br> 

			<c:forEach items="${modelBi.lstBieres}" var="biere">
				<p>${biere.nom} ${biere.brasserie.nom} ${biere.type} ${biere.note} ${biere.date}
				<a href="BrasserieServlet?BT_MODIFYBI=${biere.id}"class="btn btn-primary">Modifier</a>
				<a href="BrasserieServlet?BT_DELETEBI=${biere.id}" class="btn btn-danger">Supprimer</a>
				</p>
			</c:forEach>
		</div>
	</div>
</div>
</body>
</html>