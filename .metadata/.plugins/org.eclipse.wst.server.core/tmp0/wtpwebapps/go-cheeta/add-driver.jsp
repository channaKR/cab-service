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
    <style>
    
    .resize{
     resize: none;
    
    }
    
    </style>
<title></title>
</head>
<body>
<%

if((String) session.getAttribute("useremail")==null){
	
	response.sendRedirect("admin-login.jsp");
}
%>
<div class="d-flex" id="wrapper">
<jsp:include page="admin-dashboard-side.jsp" />
<div id="page-content-wrapper">
<h1>${message }</h1>
<jsp:include page="admin-dashboard-header.jsp" />
 <div class="d-flex justify-content-center">
 
 <form action="addDriver" method="post">
  <div class="form-group ">
    <input type="text" class="form-control addvehicle-input" name="nic" id="" placeholder="Driver Nic Number" required>
  </div><br>
 <div class="form-group ">
    <input type="text" class="form-control addvehicle-input" name="dname" id="" placeholder="Driver Name" required>
  </div><br>
   <div class="form-group " >
  <select class="form-select form-group" aria-label="Default select example" name="address" required>
   
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle">Galle</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>
    </select>
  </div><br>
   
  <div class="form-group ">
    <input type="text" class="form-control addvehicle-input" name="contact" id="" placeholder="Driver Contact Number" required>
  </div><br>
  <div class="form-group ">
    <input type="email" class="form-control addvehicle-input" name="email" id="" placeholder="Email Address" required>
  </div><br>
  <div class="form-group ">
    <input type="password" class="form-control addvehicle-input" name="password" id="" placeholder="Password" required>
  </div><br>
   <div class="form-group " >
          <select class="form-select" aria-label="Default select example" name="model" required>
         <option VALUE="">Select Vehicle Model</option>
      <tag:forEach var="vehicle" items="${vehicleData}">
      <option value="${vehicle.getVehicleID()}">${vehicle.getVehicle_Model()}</option>
      </tag:forEach>   
      </select>
  </div><br>
 
   <input type="hidden" name="action" value="addDriver"/>
   <div class="d-flex justify-content-center">
  <button type="submit" class="btn btn-success addvehiclebtn">Insert Driver</button></div>
 
 </form>
 
 </div>
</div>
</div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
<script src="javascript/script-dashboard.js"></script>
 
</body>
</html>