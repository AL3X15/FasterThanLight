<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@include file="include/importTags.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<script>
        function edit(id) {
            document.getElementById("editButton"+id).style.display = "none";
            document.getElementById("editForm"+id).style.display = "block";
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
			<p><spring:message code="price"/> ${basketEntry.key.getUnitPrice()}M €</p>
			<p><spring:message code="quantity"/> ${basketEntry.value}</p>
			<spring:url value="/basket/${basketEntry.key.getId()}" var="basketEditURL"/>
				<%--@elvariable id="basketEntryEdit" type="BasketEntry"--%>
			<form:form id="editForm${basketEntry.key.getId()}" style="display:none;" method="PUT" action="${basketEditURL}"
			           modelAttribute="basketEntryEdit">
				<form:input path="shipId" type="hidden" value="${basketEntry.key.getId()}"/>
				<form:label path="quantity"><spring:message code="quantity"/></form:label>
				<form:input value="${basketEntry.value}" step="1" path="quantity"/>
				<p><from:errors cssClass="error" path="quantity"/></p>
				<p><form:button><spring:message code="submit"/></form:button></p>
			</form:form>
			<button id="editButton${basketEntry.key.getId()}" onclick="edit(${basketEntry.key.getId()})"><spring:message code="edit"/></button>
			<c:set var="somme" scope="page" value="${somme + (basketEntry.value * basketEntry.key.getUnitPrice())}"/>
		</div>
	</c:forEach>
	<div class="bottomnav">
		<p>
			<spring:message code="priceTotal"/> ${somme}M €
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
