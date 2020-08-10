<%@ include file="include/importTags.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body class="background">
<c:if test="${not empty orders}">
	<c:forEach items="${orders}" var="order">
		<div class="ship">
			<p><spring:message code="creationDate"/> ${formatDate.format(order.getCreationDate())}</p>
			<c:if test="${not empty order.getDeliveryDate()}">
				<p><spring:message code="deliveryDate"/> ${formatDate.format(order.getDeliveryDate())}</p>
			</c:if>
			<p>
				<c:if test="${!order.getIsPay()}"><spring:message code="negate"/></c:if> <spring:message code="paid"/>
			</p>
			<button onclick="location.href = '<spring:url value="/order/${order.getId()}'"/>"><spring:message
					code="moreInformation"/></button>
		</div>
	</c:forEach>
</c:if>
<c:if test="${empty orders}">
	<div class="center">
		<spring:message code="youHaveNoOrder"/>
	</div>
</c:if>
</body>
</html>
