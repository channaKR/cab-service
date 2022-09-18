<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"/>
     <link rel="stylesheet" href="css/addmin-dashboard-side.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>

<link rel="stylesheet" href="css/booking-style.css" />
<meta charset="ISO-8859-1">
<title>Account Dashboard</title>

<style>
body{
       background-image: url("image/bookingbg.jpeg");
       background-size: auto; 
        background-repeat: repeat;
       
       
       }
       
       
       
.fstrow .form-group{
    Display:flex;
    
    
 } 

</style>
</head>
<body>

<%

if((String) session.getAttribute("user")==null){
	
	response.sendRedirect("customer-login.jsp");
}
%>
<jsp:include page="customer-navbar.jsp" />
<form action="bookingVehicle" method="POST">
<input type="text" name="customer">
<input type="hidden" name="action" value="myorders">
<button type="submit">Click</button>
</form>
  
                                 
</body>
</html>