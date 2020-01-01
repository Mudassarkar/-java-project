
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="EmailDAO.DaoInterface"%>
<%@page import="EmailDAO.DaoClass"%>
<%@page import="com.Bean.EmailBean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" width=100>

<th>Email</th>
<th>Password</th>
<th>Update</th>
<th>Delete</th>

<%
int i;
int j=1;
 DaoClass d = new DaoClass();

ArrayList<EmailBean> AB = d.viewtable();
for(EmailBean E : AB )
{
%>	<% i = E.getId();%>
<tr>

<td><%=E.getEmail() %></td>
<td><%=E.getPassword() %></td>

<td><a href="update.jsp?id=<%=i%>">Update</a></td>
<td><a href="EmailServlet?id=<%=i%>">Delete</a></td>
<%} %>
</table>

</body>
</html>