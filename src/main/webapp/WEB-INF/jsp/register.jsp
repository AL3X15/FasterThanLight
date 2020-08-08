<%@include file="include/importTags.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta http-equiv="content-type" content="type=text/html; charset=utf-8"/>
	<script>
        onload = function () {
            birthDateInput = document.getElementById("birthDate");
        }

        function disableOrEnable() {
            if (birthDateInput.disabled == true) birthDateInput.disabled = false;
            else birthDateInput.disabled = true;
        }
	</script>
</head>
<body>
<%--@elvariable id="user" type="User"--%>
<spring:url value="/register" var="registerURL"/>
<form:form id="login" method="POST" action="${registerURL}" modelAttribute="user">
	<p>
		<form:label path="username"><spring:message code="username"/></form:label>
		<form:input id="username" autofocus="true" path="username"/>
		<form:errors cssClass="error" path="username"/>
	</p>
	<p>
		<form:label path="password"><spring:message code="password"/></form:label>
		<form:password id="password" path="password"/>
		<form:errors cssClass="error" path="password"/>
	</p>
	<p>
		<form:label path="name"><spring:message code="name"/></form:label>
		<form:input id="name" path="name"/>
		<form:errors cssClass="error" path="name"/>
	</p>
	<p>
		<form:label path="firstName"><spring:message code="firstName"/></form:label>
		<form:input id="firstName" path="firstName"/>
		<form:errors cssClass="error" path="firstName"/>
	</p>
	<p>
		<form:label type="email" path="email"><spring:message code="email"/></form:label>
		<form:input id="email" path="email"/>
		<form:errors cssClass="error" path="email"/>
	</p>
	<p>
		<form:label path="phoneNumber"><spring:message code="phoneNumber"/></form:label>
		<form:input id="phoneNumber" path="phoneNumber"/>
		<form:errors cssClass="error" path="phoneNumber"/>
	</p>
	<p>
		<form:label path="postalCode"><spring:message code="postalCode"/></form:label>
		<form:input id="postalCode" path="postalCode"/>
		<form:errors cssClass="error" path="postalCode"/>
	</p>
	<p>
		<form:label path="city"><spring:message code="city"/></form:label>
		<form:input id="city" path="city"/>
		<form:errors cssClass="error" path="city"/>
	</p>
	<p>
		<form:label path="address"><spring:message code="address"/></form:label>
		<form:input id="address" path="address"/>
		<form:errors cssClass="error" path="address"/>
	</p>
	<p>
	<p>
		<form:label path="gender"><spring:message code="gender"/> :</form:label>
	</p>
	<form:label path="gender"><spring:message code="man"/></form:label>
	<form:radiobutton path="gender" value="m"/>
	<form:label path="gender"><spring:message code="woman"/></form:label>
	<form:radiobutton path="gender" value="f"/>
	</p>
	<p>
		<form:label type="date" onclick="disableOrEnable()" path="birthDate"><spring:message
				code="birthDate"/> (<spring:message code="clickToEnable"/>)</form:label>
		<form:input type="date" id="birthDate" path="birthDate" disabled="true"/>
		<form:errors cssClass="error" path="birthDate"/>
	</p>
	<p>
		<form:button><spring:message code="submit"/></form:button>
	</p>
</form:form>
</body>
</html>
