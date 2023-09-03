<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Ninjas</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container">
		<h2>All Ninjas</h2>
	
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
					<th>Name of Dojo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ninjas}" var="n">
					<tr>
						<td>${n.getId()}</td>
						<td>${n.getFirstName()}</td>
						<td>${n.getLastName()}</td>
						<td>${n.getAge()}</td>
						<td>${n.getDojo().getName()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="../" class="float-end m-2">Back Home</a>
	</div>
</body>
</html>