<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
		</div>
		<c:forEach var="weather" items="${weathers}">
			<c:out value="${weather.day}"/>
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
		</c:forEach>
	</section>
</body>
</html>