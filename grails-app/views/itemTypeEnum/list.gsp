
<%@ page import="com.enums.ItemTypeEnum" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itemTypeEnum.label', default: 'ItemTypeEnum')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-itemTypeEnum" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-itemTypeEnum" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="enumCode" title="${message(code: 'itemTypeEnum.enumCode.label', default: 'Enum Code')}" />
					
						<g:sortableColumn property="enumDescription" title="${message(code: 'itemTypeEnum.enumDescription.label', default: 'Enum Description')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${itemTypeEnumInstanceList}" status="i" var="itemTypeEnumInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${itemTypeEnumInstance.id}">${fieldValue(bean: itemTypeEnumInstance, field: "enumCode")}</g:link></td>
					
						<td>${fieldValue(bean: itemTypeEnumInstance, field: "enumDescription")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${itemTypeEnumInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
