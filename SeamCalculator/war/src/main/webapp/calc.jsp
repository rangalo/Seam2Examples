<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seam Calculator</title>
<link href="styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<f:view>
		<h:form>
			<h:panelGrid columns="2">
				Value 1:
				<s:decorate>
					<f:facet name="aroundInvalidField">
						<s:span styleClass="invalidInput"/>
					</f:facet>
					<f:facet name="beforeInvalidField">
						<f:verbatim>**</f:verbatim>
					</f:facet> 
					<f:facet name="afterInvalidField">
						<s:message/>
					</f:facet>
					<h:inputText value="#{calculator.value1}" >
						<s:validate />
					</h:inputText>
				</s:decorate>
				Value 2: 
				<s:decorate>
					<f:facet name="aroundInvalidField">
						<s:span styleClass="invalidInput"/>
					</f:facet>
					<f:facet name="beforeInvalidField">
						<f:verbatim>**</f:verbatim>
					</f:facet> 
					<f:facet name="afterInvalidField">
						<s:message/>
					</f:facet>
					<h:inputText value="#{calculator.value2}" >
						<s:validate/>
					</h:inputText>
				</s:decorate>
				         
				Add them together gives:  <h:outputText value="#{calculator.answer}" />
			</h:panelGrid>
			<h:commandButton value="Add"  action="#{calcAction.calculate}"/>
		</h:form>
	</f:view>
</body>
</html>