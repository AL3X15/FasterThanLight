<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@include file="include/importTags.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<script>
        onload = function () {
            editButton = document.getElementById("editButton");
            editForm = document.getElementById("editForm");
            editButton.onclick = click;
        }

        function click() {
            editButton.style.display = "none";
            editForm.style.display = "block";
        }
	</script>
</head>
<body>
<c:if test="${not empty basket}">
	<c:forEach items="${basket}" var="basketEntry">
		<div class="ship">
			<spring:url value="/basket/${basketEntry.key.getId()}" var="deleteEntryURL"/>
			<a class="delete" href="${deleteEntryURL}">X</a>
			<p class="title">${basketEntry.key.getName()}</p>
			<img src="<spring:url value='images/${basketEntry.key.getURLImage()}'/>"/>
			<p><spring:message code="pricePerKilo"/> ${basketEntry.key.getUnitPrice()}€</p>
			<p><spring:message code="quantity"/> ${basketEntry.value} kilo</p>
			<spring:url value="/basket/${basketEntry.key.getId()}" var="basketEditURL"/>
				<%--@elvariable id="basketEntryEdit" type="BasketEntry"--%>
			<form:form id="editForm" style="display:none;" method="PUT" action="${basketEditURL}"
			           modelAttribute="basketEntryEdit">
				<form:input path="shipId" type="hidden" value="${basketEntry.key.getId()}"/>
				<form:label path="quantity"><spring:message code="quantity"/></form:label>
				<form:input value="${basketEntry.value}" step="0.5" path="quantity"/>
				<p><from:errors cssClass="error" path="quantity"/></p>
				<p><form:button><spring:message code="submit"/></form:button></p>
			</form:form>
			<button id="editButton"><spring:message code="edit"/></button>
			<c:set var="somme" scope="page" value="${somme + (basketEntry.value * basketEntry.key.getUnitPrice())}"/>
		</div>
	</c:forEach>
	<div class="bottomnav">
		<p>
			<spring:message code="priceTotal"/> ${somme}€
		</p>
		<sec:authorize access="isAuthenticated()">
			<button onclick="location.href = '<spring:url value="/order/makeOrder"/>'"><spring:message
					code="makeOrder"/></button>
		</sec:authorize>
	</div>
</c:if>
<c:if test="${empty basket}">
	<p class="center">
		<spring:message code="basketEmpty"/>
	</p>
</c:if>
</body>
</html>
