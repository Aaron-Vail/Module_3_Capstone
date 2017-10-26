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
		<c:forEach var="park" items="park">
			<div>
				<c:url var="parkImagePath" value="/img/parks/${park.parkCode}.jpg"/>
				<img src="${parkImagePath}" alt="Image of a park">
				<c:out value="${park.parkName}"/>
				<%-- <c:out value="${survey.}"/> --%>
			</div>
		</c:forEach>
		<div>
		</div>	
	
	</section>
</body>
</html>