<%@page import="com.klef.ep.models.Company"%>
<%@page import="javax.ejb.EJB"%>
<%
    Company company = (Company) session.getAttribute("company");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Profile Page</title>
    <link rel="stylesheet" type="text/css" href="resources/profiles.css" />
</head>
<body>
    <nav>
        <a href="companyhome.jsp">Home</a>&nbsp;&nbsp;&nbsp;
        <a href="addquote.jsf">Add Quote</a>&nbsp;&nbsp;&nbsp;
        <a href="viewallquotes.jsf">View All Quotes</a>&nbsp;&nbsp;&nbsp;
        <a href="alogout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;
        <a href="companyprofile.jsp">Profile</a>&nbsp;&nbsp;&nbsp;
    </nav>
    <h1 align="center">Profile</h1>
    <div class="profile-card">
        <img src="viewprofilebyid.jsp?cid=<%= company.getId()%>" />
        <p class="email"><strong>Company Name:</strong> <%= company.getCname() %></p>
        <p class="email"><strong>Company Email:</strong> <%= company.getEmail() %></p>
        <p class="email"><strong>Company DOF:</strong> <%= company.getDof() %></p>
        <p class="email"><strong>Company Contact:</strong> <%= company.getCcontact() %></p>
    </div>
</body>
</html>