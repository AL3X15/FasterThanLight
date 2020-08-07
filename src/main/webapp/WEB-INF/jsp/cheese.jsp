<%@ include file="include/importTags.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 06-08-19
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link href="<spring:url value="../css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<spring:url value="/images/${cheeseLanguage.getCheese().getURLImage()}" var="imageURL"/>
<div id="alignCenter">
	<div class="cheese">
		<p class="title">${cheeseLanguage.getCheese().getName()}</p>
		<img id="imageCheeseFocus" src=${imageURL}/>
		<p>${cheeseLanguage.getDescription()}</p>
		<p><spring:message code="pricePerKilo"/> : ${cheeseLanguage.getCheese().getPricePerKilo()}€</p>
		<spring:url value="/basket" var="basketURL"/>
		<%--@elvariable id="basketEntry" type="com.spring.henallux.javawebproject.model.BasketEntry"--%>
		<form:form id="basketForm" method="POST" action="${basketURL}" modelAttribute="basketEntry">
			<form:input path="cheeseId" type="hidden" value="${cheeseLanguage.getCheese().getId()}"/>
			<p><form:label path="quantity"><spring:message code="quantity"/> (kilo)</form:label>
				<form:input value="0" step="0.5" autofocus="true" path="quantity"/></p>
			<p><form:errors cssClass="error" path="quantity"/></p>
			<form:button><spring:message code="addToBasket"/></form:button>
		</form:form>
	</div>
</div>
</body>
</html>
