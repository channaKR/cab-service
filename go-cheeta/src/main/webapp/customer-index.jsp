<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib prefix = "tag" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<link rel="stylesheet" href="css/home-page-style.css" />
<style>
.bg {
     background-image: url("image/bg.jpg");}
   
</style>

<title>Index</title>
</head>
<body>
<tag:set var = "username" scope = "session" value = ""/>
<%

if((String) session.getAttribute("user")==null){
	
	response.sendRedirect("customer-login.jsp");
}
%>

<jsp:include page="customer-navbar.jsp" />

<div class="bg"></div>
<input type="text" value=<%=session.getAttribute("user")  %> placeholder="sdsd">
</body>

</html>