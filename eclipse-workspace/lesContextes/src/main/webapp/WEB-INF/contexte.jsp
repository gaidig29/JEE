<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ContexteServlet" action="post">
	<input type="text" name="message"/>
	<input type="submit" name="BTREQ" value="Request"/>
	<input type="submit" name="BTSES" value="Session"/>
	<input type="submit" name="BTAPP" value="Applicatif"/>
 </form>
 
 contexte request : ${messageReq}<BR>
 contexte session : ${messageSes}<BR>
 contexte applicatif : ${messageApp}
</body>
</html>