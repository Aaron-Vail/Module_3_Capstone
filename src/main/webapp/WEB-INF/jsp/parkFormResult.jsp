<%@ include file="common/header.jspf" %>
	<section>
		<h2>Favorite Parks</h2>
		<c:forEach var="surveys" items="${surveys}">
			<div>
				<c:url var="parkImagePath" value="/img/parks/${surveys.parkCode}.jpg"/>
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