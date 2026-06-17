<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>

<% 

Blob image = null;

Connection con = null;

byte[ ] imgData = null ;

String pid = request.getParameter("cid");
int id = Integer.parseInt(pid);


try 
{

    Class.forName("com.mysql.cj.jdbc.Driver");
    con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sdp", "root", "root");
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("select imagedata from company_table where cid = "+id+"  ");
    if (rs.next()) 
    { 
    	image = rs.getBlob(1);
    	imgData = image.getBytes(1,(int)image.length());
    } 

// display the image

response.setContentType("image/jpg");

OutputStream o = response.getOutputStream();

o.write(imgData);

o.flush();

o.close();

} 
catch (Exception e) 
{

out.println("Image Display Error=" + e.getMessage());

return;

} 

%>