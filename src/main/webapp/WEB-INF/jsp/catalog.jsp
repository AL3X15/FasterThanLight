<%@include file="include/importTags.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body class="background">
<br>
<br>
<br>
<c:if test="${not empty categories}">
	<c:forEach items="${categories}" var="category">
		<h3>${category.getName()}</h3>
		<c:if test="${not empty category.getShips()}">
			<c:forEach items="${category.getShips()}" var="ship">
				<div class="ship">
					<p class="title">${ship.getName()}</p>
					<spring:url value="/images/${ship.getURLImage()}" var="imageURL"/>
					<img src=${imageURL}>
					<p><spring:message code="unitPrice"/> : ${ship.getUnitPrice()}M €</p>
					<p><spring:url value="/catalog/${ship.getId()}" var="getShip"/></p>
					<button onclick="location.href = '${getShip}'"><spring:message code="moreInformation"/></button>
				</div>
			</c:forEach>
		</c:if>
	</c:forEach>
</c:if>

</body>
</html>
