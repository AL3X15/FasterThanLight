<%@include file="include/importTags.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link href="<spring:url value="../css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body class="background">
<spring:url value="/images/${shipLanguage.getShip().getURLImage()}" var="imageURL"/>
<div id="alignCenter">
	<div class="ship">
		<p class="title">${shipLanguage.getDescription()}</p>
		<img id="imageShipFocus" src=${imageURL}/>
		<p>${shipLanguage.getDescription()}</p>
		<p><spring:message code="price"/> : ${shipLanguage.getShip().getUnitPrice()}€</p>
		<p><spring:message code="length"/> : ${shipLanguage.getShip().getLength()}m</p>
		<p><spring:message code="width"/> : ${shipLanguage.getShip().getWidth()}m</p>
		<p><spring:message code="height"/> : ${shipLanguage.getShip().getHeight()}m</p>
		<p><spring:message code="builder"/> : ${shipLanguage.getShip().getBuilder()}</p>
		<spring:url value="/basket" var="basketURL"/>
		<%--@elvariable id="basketEntry" type="com.spring.henallux.javawebproject.model.BasketEntry"--%>
		<form:form id="basketForm" method="POST" action="${basketURL}" modelAttribute="basketEntry">
			<form:input path="shipId" type="hidden" value="${shipLanguage.getShip().getId()}"/>
			<p><form:label path="quantity"><spring:message code="quantity"/> </form:label>
				<form:input value="0" step="0.5" autofocus="true" path="quantity"/></p>
			<p><form:errors cssClass="error" path="quantity"/></p>
			<form:button><spring:message code="addToBasket"/></form:button>
		</form:form>
	</div>
</div>
</body>
</html>