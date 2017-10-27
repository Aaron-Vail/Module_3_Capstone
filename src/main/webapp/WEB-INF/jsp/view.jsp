<%@ include file="common/header.jspf" %>
	<section>
		<div>
			<div>
				<c:url var="parkImagePath" value="/img/parks/${park.parkCode}.jpg"/>
				<img src="${parkImagePath}" alt="Image of a park">
			</div>
			<div>
				<h1><c:out value="${park.parkName}"/></h1>
			</div>
			<div>
				<p><c:out value="${park.parkDescription}"/></p>
			</div>
			<table>
				<tr>
					<th>State</th>
					<td><c:out value="${park.state}"/></td>
				</tr>
				<tr>
					<th>Acreage</th>
					<td><c:out value="${park.acreage}"/></td>
				</tr>
				<tr>
					<th>Elevation</th>
					<td><c:out value="${park.elevation}"/></td>
				</tr>
				<tr>	
					<th>Miles of Trail</th>
					<td><c:out value="${park.trailMiles}"/></td>
				</tr>
				<tr>
					<th>Number of Camp</th>
					<td><c:out value="${park.numOfCamps}"/></td>
				</tr>
				<tr>
					<th>Climate</th>
					<td><c:out value="${park.climate}"/></td>
				</tr>
				<tr>
					<th>Year Founded</th>
					<td><c:out value="${park.yearFounded}"/></td>
				</tr>	
				<tr>
					<th>Annual Visitors</th>
					<td><c:out value="${park.annualVisitors}"/></td>
				</tr>
				<tr>
					<th>Quote</th>
					<td><c:out value="${park.inspirationalQuote}"/><br>
					 -<c:out value="${park.inspirationalQuoteSource}"/></td>
				</tr>
				<tr>
					<th>Entry Fee</th>
					<td><c:out value="${park.entryFee}"/></td>
				</tr>
				<tr>
					<th>Number of Species</th>
					<td><c:out value="${park.numberOfSpecies}"/></td>
				</tr>
			</table>
			<c:url var="tempChangePathing" value="/tempSave"/>
			<form method="POST" action="${tempChangePathing}">
				<input type="hidden" name="parkCode" value="${park.parkCode}"/>
				<c:choose>
					<c:when test="${temperature == 'celsius'}">
						<label for="tempType">&#x2103;</label>
						<input type="submit" name="temperature" value="fahrenheit" id="tempType2"/>
					</c:when>
					<c:otherwise>
						<label for="tempType2">&#x2109;</label>						
						<input type="submit" name="temperature" value="celsius" id="tempType"/>
					</c:otherwise>
				</c:choose>
			</form>
				<c:forEach var="weather" items="${weathers}" varStatus="status">
					<div
						<c:if test="${status.first}">
						class="today"
						</c:if>
						<c:if test="${!status.first}">
						class="another-day"
						</c:if>
						>
						<c:out value="${weather.day})"/>
						<c:out value="Low: ${temperature == 'celsius' ? (weather.lowTemp -32)/1.8 : weather.lowTemp}. High: ${temperature == 'celsius' ? (weather.highTemp -32)/1.8 : weather.highTemp}"/>
						<div>
							<c:if test="${weather.highTemp > 75}">
								<p>Bring an extra gallon of water.</p>
							</c:if>
							<c:if test="${weather.highTemp - weather.lowTemp > 20}">
								<p>Wear breathable layers.</p>
							</c:if>
							<c:if test="${weather.lowTemp < 20}">
								<p>Beware! Exposure to frigid air my cause frostbite!</p>
							</c:if>
							<c:if test="${weather.forecast == 'snow'}">
								<p>Pack snow shoes, noob!</p>
							</c:if>
							<c:if test="${weather.forecast == 'rain'}">
								<p>Pack rain gear and waterproof shoes, scrub!</p>
							</c:if>
							<c:if test="${weather.forecast == 'thunderstorms'}">
								<p>Seek shelter and avoid hiking on exposed ridges, ya idiot!</p>				
							</c:if>
							<c:if test="${weather.forecast == 'sunny'}">
								<p>Pack sunblock and don't forget to bring a towel! Or... you know... cancer.</p>
							</c:if> 
							<c:if test="${weather.forecast == 'partly cloudy'}">
							</c:if>
						</div>
					<c:choose>
						<c:when test="${weather.forecast == 'partly cloudy'}">
							<c:url var="pc" value="/img/weather/partlyCloudy.png"/>
							<img src="${pc}" alt="Image of Weather"/>
						</c:when>
						<c:otherwise>
							<c:url var="forecastImagePath" value="/img/weather/${weather.forecast}.png"/>
							<img src="${forecastImagePath}" alt="Image of Weather"/>	
						</c:otherwise>
					</c:choose>	
					</div>
				</c:forEach>
	</section>
</body>
</html>