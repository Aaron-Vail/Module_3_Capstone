<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="common/header.jspf" %>
	<section>
		<div>
			<c:out value="${park.parkName}"/>
		</div>
		<div>
		<c:url var="parkFormUrl" value="/parkFormResult"/>
			<form:form method="POST" action="${parkFormUrl}" modelAttribute="survey">
			<label for="parkCode">Select Favorite Park</label>
			<form:select path="parkCode">
				<c:forEach var="park" items="${parks}">
					<form:option value="${park.parkCode}">${park.parkName}</form:option>
					</c:forEach>
			</form:select>
			
			<label for="email">Email Address</label>
			<form:input path="email" items="${survey.email}" placeholder="example@email.com"/>
			<form:errors path="email" class="error"/>
			<br>
			<br>
			<label for="state">State of Residence</label>
			<form:select path="state">
				<form:option value="AL">Alabama</form:option>
				<form:option value="AK">Alaska</form:option>
				<form:option value="AZ">Arizona</form:option>
				<form:option value="AR">Arkansas</form:option>
				<form:option value="CA">California</form:option>
				<form:option value="CO">Colorado</form:option>
				<form:option value="CT">Connecticut</form:option>
				<form:option value="DE">Delaware</form:option>
				<form:option value="FL">Florida</form:option>
				<form:option value="GA">Georgia</form:option>
				<form:option value="HI">Hawaii</form:option>
				<form:option value="ID">Idaho</form:option>
				<form:option value="IL">Illinois</form:option>
				<form:option value="IN">Indiana</form:option>
				<form:option value="IA">Iowa</form:option>
				<form:option value="KS">Kansas</form:option>
				<form:option value="KY">Kentucky</form:option>
				<form:option value="LA">Louisiana</form:option>
				<form:option value="ME">Maine</form:option>
				<form:option value="MD">Maryland</form:option>
				<form:option value="MA">Massachusetts</form:option>
				<form:option value="MI">Michigan</form:option>
				<form:option value="MN">Minnesota</form:option>
				<form:option value="MS">Mississippi</form:option>
				<form:option value="MO">Missouri</form:option>
				<form:option value="MT">Montana</form:option>
				<form:option value="NE">Nebraska</form:option>
				<form:option value="NV">Nevada</form:option>
				<form:option value="NH">New Hampshire</form:option>
				<form:option value="NJ">New Jersey</form:option>
				<form:option value="NM">New Mexico</form:option>
				<form:option value="NY">New York</form:option>
				<form:option value="NC">North Carolina</form:option>
				<form:option value="ND">North Dakota</form:option>
				<form:option value="OH">Ohio</form:option>
				<form:option value="OK">Oklahoma</form:option>
				<form:option value="OR">Oregon</form:option>
				<form:option value="PA">Pennsylvania</form:option>
				<form:option value="RI">Rhode Island</form:option>
				<form:option value="SC">South Carolina</form:option>
				<form:option value="SD">South Dakota</form:option>
				<form:option value="TN">Tennessee</form:option>
				<form:option value="TX">Texas</form:option>
				<form:option value="UT">Utah</form:option>
				<form:option value="VT">Vermont</form:option>
				<form:option value="WA">Washington</form:option>
				<form:option value="WV">West Virginia</form:option>
				<form:option value="WI">Wisconsin</form:option>
				<form:option value="WY">Wyoming</form:option>
			</form:select>
			<br>
			<br>
			<label for="activityLevel">Activity Level</label>
			<div class="option"><form:radiobutton path="activityLevel" value="inactive"/> Inactive</div>
			<div class="option"><form:radiobutton path="activityLevel" value="sedentary"/> Sedentary</div>
			<div class="option"><form:radiobutton path="activityLevel" value="active"/> Active</div>
			<div class="option"><form:radiobutton path="activityLevel" value="xactive"/> Extremely Active</div>
			<br>
			<br>
			
			<input type="submit" name="submit" class="btn btn-success" value="Submit Form"/>
			</form:form>
		</div>
	</section>
</body>
</html>