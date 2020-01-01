<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email Validation</title>
</head>
<body>
<form action="EmailServlet" method ="post">
EMP ID: 
<input type="text" name=id><br>
Email Id:
<input type="text" name=Email><br>
Password:
<input type = "text" name=psw><br>

<input type ="submit" name=submit>
<input type="reset" name=reset>
</form>
</body>
</html>