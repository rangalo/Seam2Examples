<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vacation</title>
</head>
<body>
	<f:view>
		<h:form>
			<p>What type of holidy do you like?</p>
			<h:selectOneMenu value="#{destination.destinationType}">
				<s:selectItems value="#{destinationTypes}" var="type" label="#{type.label}" 
				 	noSelectionLabel="Please select"/>
				<s:convertEnum />
			</h:selectOneMenu>
			
			<p>What is your minumuk budget?</p>
			<h:inputText value="#{destination.minimumBudget}" />
			<br/>
			<h:commandButton action="#{vacationManagerAction.selectVacationType}" value="Select" />
		</h:form>
	</f:view>

</body>
</html>