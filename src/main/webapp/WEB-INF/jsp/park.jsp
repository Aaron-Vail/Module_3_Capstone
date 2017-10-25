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
		<c:forEach var="park" items="${parks}">
			<div>
				<div>
					<c:url var="parkImagePath" value="/img/parks/${park.parkCode}.jpg"/>
					<c:url var="parkDetailPath" value="/view/${park.parkCode}"/>
					<a href="${parkDetailPath}"><img src="${parkImagePath}" alt="Image of a park"></a>
				</div>
				<div>
					<c:out value="${park.parkName}"/>
				</div>			
				<div>
					<c:out value="${park.parkDescription}"/>
				</div>
			</div>
		</c:forEach>
	</section>
</body>
</html>