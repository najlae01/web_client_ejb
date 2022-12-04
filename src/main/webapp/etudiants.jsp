<%@page import="java.util.List"%>
<%@page import="fstt.org.market.entities.persistence.Etudiant"%>
<%@page import="java.util.ListIterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Client Management</title>
</head>
<body>
	<%
	List<Etudiant> list = (List<Etudiant>) request.getAttribute("list");
	%>

	<table>
		<thead>
			<tr>
				<th>Id</th>

				<th>Prénom</th>

				<th>Nom</th>
				
				<th>Adresse</th>

				<th>Cne</th>

				<th>Niveau</th>

				<th>Delete</th>

				<th>Update</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>

				<td><%=list.get(i).getId()%></td>
				<td><%=list.get(i).getPrenom()%></td>
				<td><%=list.get(i).getPrenom()%></td>
				<td><%=list.get(i).getAdresse()%></td>
				<td><%=list.get(i).getCne()%></td>
				<td><%=list.get(i).getNiveau()%></td>
				<td><a href="etudiant?action=delete&id=<%=list.get(i).getId()%>">
						delete </a></td>
				<td><a href="etudiant?action=update&id=<%=list.get(i).getId()%>">
						update </a></td>

			</tr>

			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>