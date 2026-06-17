<%@page import="com.klef.ep.models.Company"%>
<%@page import="com.klef.ep.models.Admin"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%
Company company = (Company) session.getAttribute("company");
%>
<html>
<head>
<title>company Home</title>
 <link rel="stylesheet" type="text/css" href= "resources/styles.css" />
</head>
<body bgcolor="lightgrey">
<h3 align='center'>The Tender Management System</h3>
<nav>
<a href="companyhome.jsp">Home</a>&nbsp;&nbsp;&nbsp;
<a href="addquote.jsf">Add Quote</a>&nbsp;&nbsp;&nbsp;
<a href="viewallquotes.jsf">View All Quotes</a>&nbsp;&nbsp;&nbsp;
<a href="alogout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;
<a href="companyprofile.jsp">Profile</a>&nbsp;&nbsp;&nbsp;
</nav>
<br/><br/>
Welcome <%= company.getCname()%>
</body>
</html>