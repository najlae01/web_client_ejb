<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="etudiant?action=updated" method="post">

		<input type="number" value="${id}" name="id" hidden="true"> <br />
		
		<label>Prenom :</label> <input type="text" value="${oldFirstname}" name="firstname"> <br />
		<label>Nom :</label> <input type="text" value="${oldLastname}" name="lastname"> <br />
		<label>Adresse :</label> <input type="text" value="${oldAddress}" name="address"> <br />
		<label>CNE :</label> <input type="text" value="${oldCne}" name="cne"> <br />
		<label>Niveau :</label> <input type="text" value="${oldLevel}" name="level"> <br />
		<input type="submit" name="save" value="Add"> <br />
	</form>
</body>
</html>