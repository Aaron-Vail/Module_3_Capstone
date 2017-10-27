<%@ include file="common/header.jspf" %>
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