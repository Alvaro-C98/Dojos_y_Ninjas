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
<title>Dojos</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container">
		<h2>All Dojos</h2>
		<p class="float-end text-danger"><c:out value="${error}"></c:out></p>
		
		<a href="/ninjas/new" class="float-end m-2">New Ninja</a>
		<a href="/dojos/new" class="float-end m-2">New Dojo</a>
	
		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name of Dojo</th>
					<th>Number of ninjas</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dojos}" var="d">
					<tr>
						<td>${d.getId()}</td>
						<td>${d.getName()}</td>
						<td>
							<c:out value="${d.getNinjas().size()} "/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="../ninjas" class="float-end m-2">Show Ninjas</a>
	</div>
</body>
</html>