<%@ include file="common/header.jspf" %>
	<section class="result-section">
		<h2>Favorite Parks</h2>
		<c:forEach var="surveys" items="${surveys}">
			<div class="survey-result">
				<c:url var="parkImagePath" value="/img/parks/${surveys.parkCode}.jpg"/>
				<img src="${parkImagePath}" class="result-img"/>
				<div class="result-info">
					<h2><c:out value="Park: ${surveys.parkCode}"/></h2>
					<c:out value="Number of Votes: ${surveys.votes}"/>
				</div>	
			</div>
		</c:forEach>
		<div>
		</div>	
	
	</section>
</body>
</html>