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
<form action="UpdateServlet" method ="get">
<% DaoInterface d = new DaoClass();
System.out.println("**************In Update.JSP*****************");
String id=request.getParameter("id");
EmailBean EB = d.getbyid(Integer.parseInt(id));
System.out.println("ID => "+id);%>
EMP ID: 
<input type="text" name=id value=<%=EB.getId() %>><br>
Email Id:
<input type="text" name=Email value=<%=EB.getEmail() %>><br>
Password:
<input type = "text" name=psw value=<%=EB.getPassword() %>><br>

<input type ="submit" name=submit>
<input type="reset" name=reset>
</form>
</body>
</html>