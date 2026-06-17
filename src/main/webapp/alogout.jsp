<%
/* 	session.removeAttribute("emp"); */
	session.invalidate();
	response.sendRedirect("login.jsf");
%>