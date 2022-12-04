<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="etudiant?action=saved" method="post">

		<label>Prenom :</label> <input type="text" name="firstname"> <br />
		<label>Nom :</label> <input type="text" name="lastname"> <br />
		<label>Adresse :</label> <input type="text" name="address"> <br />
		<label>CNE :</label> <input type="text" name="cne"> <br />
		 <label>Niveau:</label> <input type="text" name="level"> <br /> <input
			type="submit" name="save" value="Add"> <br />
	</form>
</body>
</html>