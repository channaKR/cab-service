<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"/>
     <link rel="stylesheet" href="css/addmin-dashboard-side.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>

<link rel="stylesheet" href="css/account-style.css" />
<style>
body{
     background-image: url("image/account-create.jpeg");
       
     
   
</style>

<title>Index</title>
</head>


<body>
<jsp:include page="home-page-navbar.jsp" />

<div class="d-flex justify-content-center cent">
<form action="createAccount" method="post">

   <div class="form-group"><input type="text" min="2" class=" txt form-control addvehicle-input" name="customername1" id="" placeholder="First Name" required></div><br>
   <div class="form-group "><input type="text" min="2" class="form-control addvehicle-input" name="customername2" id="" placeholder="Last Name" required></div><br>
 <div class="form-group "><input type="email" min="2" class="form-control addvehicle-input" name="email" id="" placeholder="Email Address" required></div><br>
 <div class="form-group "><input type="password" min="2" class="form-control addvehicle-input" name="password" id="" placeholder="Password" required></div><br>
     <div class="form-group "><input type="text" min="2" class="form-control addvehicle-input" name="addres1" id="" placeholder="Address 1" required></div><br>
   <div class="form-group "><input type="text" min="2" class="form-control addvehicle-input" name="addres2" id="" placeholder="Address 2" required></div><br>   
<div class="form-group " >

<select class="form-select" aria-label="Default select example" name="city" required>
  <option VALUE=""><b>Select City</b></option>
  <option value="galle">Galle</option>
  <option value="kandy">Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>
  
</select></div><br>
 
 
 <div class="d-flex justify-content-center">
    <input type="hidden" name="action" value="addCustomer"/>
    
    <button type="submit" class="btn btn-success addvehiclebtn">Create Account</button><br><br>
  
    </div>
     <div class="d-flex justify-content-center" style="padding-top:20px; font-weight:bold">
      <a href="customer-login.jsp" class="link-danger">Login To Account</a></div>
<div class="msg"><h4>${message}</h4></div>
</form>


</div>


</body>

</html>