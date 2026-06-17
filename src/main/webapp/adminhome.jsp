<%@page import="com.klef.ep.models.Admin"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%
Admin admin = (Admin) session.getAttribute("admin");
%>
<html>
<head>
<title>Admin Home</title>
<link rel="stylesheet" type="text/css" href= "resources/styles.css" />
</head>
<body bgcolor="lightgrey">
<h3 align='center'>The Tender Management System</h3>
<nav>
<a href="adminhome.jsp">Home</a>&nbsp;&nbsp;&nbsp;
<a href="addtender.jsf">Add Tenders</a>&nbsp;&nbsp;&nbsp;
<a href="viewalltenders.jsf">View All Tenders</a>&nbsp;&nbsp;&nbsp;
<a href="updatetender.jsf">Update Tender</a>&nbsp;&nbsp;&nbsp;
<a href="alogout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;
</nav>
<br/><br/>
Welcome <%=admin.getUsername()%>
</body>
</html>