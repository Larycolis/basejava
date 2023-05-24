<%@ page import="com.basejava.webapp.model.TextSection" %>
<%@ page import="com.basejava.webapp.model.ListSection" %>
<%@ page import="com.basejava.webapp.model.OrganizationSection" %>
<%@ page import="com.basejava.webapp.util.HtmlUtil" %>
<%@ page import="com.basejava.webapp.model.Organization" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:useBean id="resume" type="com.basejava.webapp.model.Resume" scope="request"/>
    <title>Resume ${resume.fullName}</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <h2>${resume.fullName};<a href="resume?uuid=${resume.uuid}&action=edit"><img src="img/edit.png"></a></h2>
    <p>
        <c:forEach var="contactEntry" items="${resume.contacts}">
            <jsp:useBean id="contactEntry"
                         type="java.util.Map.Entry<com.basejava.webapp.model.ContactType, java.lang.String>"/>
            <%=contactEntry.getKey().toHtml(contactEntry.getValue())%><br/>
        </c:forEach>
    </p>
    <hr>
    <table cellspacing="0">
        <c:forEach var="sectionEntry" items="${resume.sections}">
        <jsp:useBean id="sectionEntry"
                     type="java.util.Map.Entry<com.basejava.webapp.model.SectionType, com.basejava.webapp.model.AbstractSection>"/>
        <c:set var="type" value="${sectionEntry.key}"/>
        <c:set var="section" value="${sectionEntry.value}"/>
        <jsp:useBean id="section" type="com.basejava.webapp.model.AbstractSection"/>
        <c:choose>
            <c:when test="${type == 'PERSONAL'}">
                <tr>
                    <td>${type.title}</td>
                    <td><%=((TextSection) section).getText()%>
                    </td>
                </tr>
            </c:when>
            <c:when test="${type == 'OBJECTIVE'}">
                <tr>
                    <td>${type.title}</td>
                    <td><%=((TextSection) section).getText()%>
                    </td>
                </tr>
            </c:when>
            <c:when test="${type == 'ACHIEVEMENTS' || type == 'QUALIFICATIONS'}">
                <tr>
                    <td>
                        <ul>
                            <c:forEach var="list" items="<%=((ListSection) section).getList()%>">
                                <li>${list}</li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
            </c:when>
            <c:when test="${type == 'EXPERIENCE' || type == 'EDUCATION'}">
                <tr>
                <td>
                <ul>
                <c:forEach var="organization" items="<%=((OrganizationSection) section).getOrganization()%>">
                    <tr>
                        <td>
                            <c:choose>
                                <c:when test="${empty organization.homePage.url}">
                                    <h2>${organization.homePage.name}</h2>
                                </c:when>
                                <c:otherwise>
                                    <h2><a href="${organization.homePage.url}">${organization.homePage.name}</a></h2>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                    <c:forEach var="period" items="${organization.period}">
                        <jsp:useBean id="period" type="com.basejava.webapp.model.Organization.Period"/>
                        <tr>
                            <td><%=HtmlUtil.formatDates(period)%>
                            </td>
                            <td>${period.title}</td>
                            <td>${period.description}</td>
                        </tr>
                    </c:forEach>
                </c:forEach>
                </ul>
                </td>
                </tr>
            </c:when>
        </c:choose>
    </table>
    </c:forEach>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>