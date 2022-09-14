<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib prefix = "tag" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="css/addmin-dashboard-side.css" />
</head>
<body>
<<<<<<< HEAD
<h1>${message}</h1>
<form action="viewVehicle" method="post">
<input type="hidden" name="action" value="sendto">
<button type="submit">send</button>

</form>
=======
<%

if((String) session.getAttribute("user")==null){
	
	response.sendRedirect("driver-login.jsp");
}
%>

<h1>${message}</h1>
>>>>>>> 915bacf5a6702528a9fb9bbe7ea4cfa5be77a23e

<div class="d-flex" id="wrapper">
<jsp:include page="driver-dashboard-side.jsp" />
<div id="page-content-wrapper">
<jsp:include page="driver-dashboard-header.jsp" />











</div></div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
<script src="javascript/script-dashboard.js"></script>



</body>
</html>