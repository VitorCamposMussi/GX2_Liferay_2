<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<portlet:defineObjects />

<div>
    <h2>Informações do Usuário</h2>
    <p>Fuso Horário: <%= renderRequest.getAttribute("timeZoneId") %></p>
    <p>Data e Hora Atual: <%= renderRequest.getAttribute("currentDateTime") %></p>
</div>