<%@ page import="com.enums.ItemTypeEnum" %>



<div class="fieldcontain ${hasErrors(bean: itemTypeEnumInstance, field: 'enumCode', 'error')} required">
	<label for="enumCode">
		<g:message code="itemTypeEnum.enumCode.label" default="Enum Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="enumCode" maxlength="50" required="" value="${itemTypeEnumInstance?.enumCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemTypeEnumInstance, field: 'enumDescription', 'error')} ">
	<label for="enumDescription">
		<g:message code="itemTypeEnum.enumDescription.label" default="Enum Description" />
		
	</label>
	<g:textField name="enumDescription" maxlength="200" value="${itemTypeEnumInstance?.enumDescription}"/>
</div>

