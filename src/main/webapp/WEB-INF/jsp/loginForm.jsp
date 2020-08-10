<%@include file="include/importTags.jsp" %>
<html>
<head>
</head>
<body class="background">
<%--@elvariable id="loginForm" type="LoginForm"--%>
<form:form id="login" method="POST" modelAttribute="loginForm">
	<p>
		<form:label path="username"><spring:message code="username"/></form:label>
		<form:input id="usernameInput" autofocus="true" path="username" required="true"/>
		<form:errors cssClass="error" path="username"/>
	</p>
	<p>
		<form:label path="password"><spring:message code="password"/></form:label>
		<form:password id="passwordInput" path="password" required="true"/>
		<form:errors cssClass="error" path="password"/>
	</p>
	<p>
		<form:button><spring:message code="submit"/></form:button>
	</p>
	<c:if test="${not empty message}">${message}</c:if>
</form:form>
</body>
</html>