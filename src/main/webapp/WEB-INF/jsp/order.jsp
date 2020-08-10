<%@include file="include/importTags.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link href="<spring:url value="../css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body class="background">
<c:forEach items="${lines}" var="line">
	<div class="ship">
		<p class="title">${line.getShip().getName()}</p>
		<img src="<spring:url value="/images/${line.getShip().getURLImage()}"/>"/>
		<p><spring:message code="price"/> ${line.getPrice()}€</p>
		<p><spring:message code="quantity"/> ${line.getQuantity()}</p>
		<c:set var="somme" scope="page" value="${somme + (line.getPrice() * line.getQuantity())}"/>
	</div>
</c:forEach>
<div class="bottomnav">
	<p><spring:message code="priceTotal"/> ${somme}€</p>
	<c:if test="${not order.getIsPay()}">
		<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="POST">
			<input name="business" type="hidden" value="FasterThanLight@business.example.com"/>
			<input name="password" type="hidden" value="test1234"/>
			<input name="cert_id" type="hidden"
			       value="ASq15zwbkN0RJcERWnO31YgfQnNZALGg3JnshT04nqcLW7RxRx7UHSXP"/>
			<input name="cmd" type="hidden" value="_xclick"/>
			<input name="amount" type="hidden" value="${somme}"/>
			<input name="item_name" type="hidden" value="${order.getId()} pay">
			<input name="return" type="hidden" value="http://localhost:8082/FasterThanLight/paid/${order.getId()}"/>
			<input name="cancel_return" type="hidden" value="http://localhost:8082/FasterThanLight/orders"/>
			<input name="currency_code" type="hidden" value="EUR"/>
			<input name="lc" type="hidden" value="${language}"/>
			<button><spring:message code="pay"/></button>
		</form>
	</c:if>
</div>
</body>
</html>
