<%@ page import="com.Item" %>



<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="item.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="code" maxlength="50" required="" value="${itemInstance?.code}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="item.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="200" required="" value="${itemInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'itemType', 'error')} required">
	<label for="itemType">
		<g:message code="item.itemType.label" default="Item Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="itemType" name="itemType.id" from="${com.enums.ItemTypeEnum.list()}" optionKey="id" required="" value="${itemInstance?.itemType?.id}" class="many-to-one"/>
</div>

