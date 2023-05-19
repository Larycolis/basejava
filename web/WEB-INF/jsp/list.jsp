<%@ page import="java.io.Reader" %>
<%@ page import="com.basejava.webapp.model.Resume" %>
<%@ page import="java.util.List" %>
<%@ page import="com.basejava.webapp.model.ContactType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Resumes Table</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <table border="2" cellpadding="8" cellspacing="0">
        <tr>
            <th>Name</th>
            <th>Email</th>
        </tr>
        <%
            for (Resume resume : (List<Resume>) request.getAttribute("resume")) {
        %>
        <tr>
            <td><a href="resume?uuid=<%=resume.getUuid()%>"><%=resume.getFullName()%>
            </a></td>
            <td><a><%=resume.getContact(ContactType.EMAIL)%>
            </a></td>
        </tr>
        <%
            }
        %>
    </table>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>