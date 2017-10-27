<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ParkLyfe</title>
</head>
<body>
	<nav class="top-nav">
		<ul class="nav-bar">
			<li>Home</li>
			<li>Survey</li>
		</ul>
	</nav>
	<section>
		<h2>Favorite Parks</h2>
		<c:forEach var="surveys" items="${surveys}">
			<div>
				<c:url var="parkImagePath" value="${surveys.parkCode}"/>
				<img src="${parkImagePath}"/>
				
				<c:out value="${surveys.parkCode}"/>
				<c:out value="${surveys.votes}"/>
			</div>
		</c:forEach>
		<div>
		</div>	
	
	</section>
</body>
</html>