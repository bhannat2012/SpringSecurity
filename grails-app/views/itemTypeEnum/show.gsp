
<%@ page import="com.enums.ItemTypeEnum" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itemTypeEnum.label', default: 'ItemTypeEnum')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-itemTypeEnum" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-itemTypeEnum" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list itemTypeEnum">
			
				<g:if test="${itemTypeEnumInstance?.enumCode}">
				<li class="fieldcontain">
					<span id="enumCode-label" class="property-label"><g:message code="itemTypeEnum.enumCode.label" default="Enum Code" /></span>
					
						<span class="property-value" aria-labelledby="enumCode-label"><g:fieldValue bean="${itemTypeEnumInstance}" field="enumCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemTypeEnumInstance?.enumDescription}">
				<li class="fieldcontain">
					<span id="enumDescription-label" class="property-label"><g:message code="itemTypeEnum.enumDescription.label" default="Enum Description" /></span>
					
						<span class="property-value" aria-labelledby="enumDescription-label"><g:fieldValue bean="${itemTypeEnumInstance}" field="enumDescription"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${itemTypeEnumInstance?.id}" />
					<g:link class="edit" action="edit" id="${itemTypeEnumInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
