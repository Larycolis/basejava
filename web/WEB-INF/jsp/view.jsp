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
    <h2>${resume.fullName}&nbsp;<a href="resume?uuid=${resume.uuid}&action=edit"><img src="img/edit.png"></a></h2>
    <p>
        <c:forEach var="contactEntry" items="${resume.contacts}">
            <jsp:useBean id="contactEntry"
                         type="java.util.Map.Entry<com.basejava.webapp.model.ContactType, java.lang.String>"/>
            <%=contactEntry.getKey().toHtml(contactEntry.getValue())%><br/>
        </c:forEach>
    </p>
    <hr>
    <table cellspacing="2">
        <c:forEach var="sectionEntry" items="${resume.sections}">
        <jsp:useBean id="sectionEntry"
                     type="java.util.Map.Entry<com.basejava.webapp.model.SectionType, com.basejava.webapp.model.AbstractSection>"/>
        <c:set var="type" value="${sectionEntry.key}"/>
        <c:set var="section" value="${sectionEntry.value}"/>
        <jsp:useBean id="section" type="com.basejava.webapp.model.AbstractSection"/>
        <tr>
            <td><h3><a name="type.name">${type.title}</a></h3></td>
            <c:if test="${type == 'OBJECTIVE'}">
                <td>
                    <h3><%=((TextSection) section).getText()%>
                    </h3>
                </td>
            </c:if>
        </tr>
        <c:if test="${type != 'OBJECTIVE'}">
            <c:choose>
                <c:when test="${type == 'PERSONAL'}">
                    <td>
                        <h3><%=((TextSection) section).getText()%>
                        </h3>
                    </td>
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
                    <c:forEach var="organization" items="<%=((OrganizationSection) section).getOrganization()%>">
                        <tr>
                            <td>
                                <c:choose>
                                    <c:when test="${empty organization.homePage.url}">
                                        <h3>${organization.homePage.name}</h3>
                                    </c:when>
                                    <c:otherwise>
                                        <h3><a href="${organization.homePage.url}">${organization.homePage.name}</a>
                                        </h3>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <c:forEach var="period" items="${organization.period}">
                            <jsp:useBean id="period" type="com.basejava.webapp.model.Organization.Period"/>
                            <tr>
                                <td><%=HtmlUtil.formatDates(period)%>
                                </td>
                                <td><b>${period.title}</b><br>${period.description}</td><br>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                </c:when>
            </c:choose>
        </c:if>
    </table>
    </c:forEach>
    <br>
    <button onclick="window.history.back()">Back to list</button>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
