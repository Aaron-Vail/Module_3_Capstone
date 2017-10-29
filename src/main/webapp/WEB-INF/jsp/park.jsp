<%@ include file="common/header.jspf" %>
	<section class="park-section">
		<c:forEach var="park" items="${parks}">
			<div>
				<div class="park-info">
					<div>
						<c:url var="parkImagePath" value="/img/parks/${park.parkCode}.jpg"/>
						<c:url var="parkDetailPath" value="/view/${park.parkCode}"/>
						<a href="${parkDetailPath}"><img src="${parkImagePath}" alt="Image of a park" class="park-img"></a>
					</div>
					<div class="park-stuff">				
						<div class="park-name">
							<h2><c:out value="${park.parkName}"/></h2>
						</div>			
						<div class="park-description">
							<p><c:out value="${park.parkDescription}"/></p>
						</div>
					</div>
				</div>	
			</div>
		</c:forEach>
	</section>
</body>
</html>