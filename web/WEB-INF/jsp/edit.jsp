<%@ page import="com.basejava.webapp.model.ContactType" %>
<%@ page import="com.basejava.webapp.model.SectionType" %>
<%@ page import="com.basejava.webapp.model.ListSection" %>
<%@ page import="com.basejava.webapp.model.OrganizationSection" %>
<%@ page import="com.basejava.webapp.util.DateUtil" %>
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
    <form method="post" action="resume" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <dl>
            <dt>Name:</dt>
            <dd><label><input type="text" name="fullName" size=50 value="${resume.fullName}"></label></dd>
        </dl>
        <h3>Contacts:</h3>
        <c:forEach var="type" items="<%=ContactType.values()%>">
            <dl>
                <dt>${type.type}</dt>
                <dd><label><input type="text" name="${type.name()}" size=50 value="${resume.getContact(type)}"></label>
                </dd>
            </dl>
        </c:forEach>
        <hr>
        <c:forEach var="type" items="<%=SectionType.values()%>">
            <c:set var="section" value="${resume.getSection(type)}"/>
            <jsp:useBean id="section" type="com.basejava.webapp.model.AbstractSection"/>
            <h3><a>${type.title}</a></h3>
            <c:choose>
                <c:when test="${type == 'OBJECTIVE'}">
                    <label><input type="text" name='${type}' size=100 value="<%=section%>"></label>
                </c:when>
                <c:when test="${type == 'PERSONAL'}">
                    <label><textarea name='${type}' cols=100 rows=5><%=section%></textarea></label>
                </c:when>
                <c:when test="${type == 'ACHIEVEMENTS' || type == 'QUALIFICATIONS'}">
                    <label><textarea name='${type}' cols=100
                                     rows=5><%=String.join("\n", ((ListSection) section).getList())%></textarea></label>
                </c:when>

                <c:when test="${type == 'EXPERIENCE' || type == 'EDUCATION'}">
                    <c:forEach var="organization" items="<%=((OrganizationSection) section).getOrganization()%>"
                               varStatus="counter">
                        <dl>
                            <dt>Organization name:</dt>
                            <dd><label><input type="text" name='${type}' size=100 value="${organization.homePage.name}"></label>
                            </dd>
                        </dl>
                        <dl>
                            <dt>Organization website:</dt>
                            <dd><label><input type="text" name='${type}url' size=100
                                              value="${organization.homePage.url}"></label></dd>
                        </dl>
                        <br>

                        <div style="margin-left: 30px">
                            <c:forEach var="period" items="${organization.period}">
                                <jsp:useBean id="period" type="com.basejava.webapp.model.Organization.Period"/>
                                <dl>
                                    <dt>Start date:</dt>
                                    <dd>
                                        <label><input type="text" name="${type}${counter.index}startDate" size=10
                                                      value="<%=DateUtil.format(period.getStartDate())%>"
                                                      placeholder="MM/yyyy"></label></dd>
                                </dl>
                                <dl>
                                    <dt>End date:</dt>
                                    <dd>
                                        <label><input type="text" name="${type}${counter.index}endDate" size=10
                                                      value="<%=DateUtil.format(period.getEndDate())%>"
                                                      placeholder="MM/yyyy"></label></dd>
                                </dl>
                                <dl>
                                    <dt>Position:</dt>
                                    <dd>
                                        <label><input type="text" name="${type}${counter.index}title" size=100
                                                      value="${period.title}"></label></dd>
                                </dl>
                                <dl>
                                    <dt>Description:</dt>
                                    <dd>
                                        <label><textarea name="${type}${counter.index}description" rows=2
                                                         cols=100>${period.description}</textarea></label>
                                    </dd>
                                </dl>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </c:when>
            </c:choose>
        </c:forEach>
        <hr>
        <button type="submit"><img src="img/done.png"></button>
        <button onclick="window.history.back()"><img src="img/cancel.png"></button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
