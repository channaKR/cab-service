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

<div class="d-flex" id="wrapper">
<jsp:include page="admin-dashboard-side.jsp" />
<div id="page-content-wrapper">
<h1>${message}</h1>
<jsp:include page="admin-dashboard-header.jsp" />

<tag:set var = "driverdata" scope = "session" value="${datadriver}"/>
<tag:set var = "dropdown" scope = "session" value="${dropdown}"/>
 <div class="d-flex justify-content-center">
 
 <form action="updateData" method="post">
  <div class="form-group ">
    <input type="text" class="form-control addvehicle-input" name="nic" id="" placeholder="Driver Nic Number"  value="${driverdata.getNicnumber()}" required>
  </div><br>
 <div class="form-group ">
    <input type="text" class="form-control addvehicle-input" name="dname" id="" placeholder="Driver Name" value="${driverdata.getDrivername()}" required>
  </div><br>
   <div class="form-group " >
    <select class="form-select form-group" aria-label="Default select example" name="branch" required>
    <tag:if test="${driverdata.getAddress()=='kandy'}">
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle">Galle</option>
  <option value="kandy" selected>Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>
    </tag:if>
       <tag:if test="${driverdata.getAddress()=='galle'}">
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle" selected>Galle</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>
    </tag:if>
       <tag:if test="${driverdata.getAddress()=='nugegoda'}">
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle">Galle</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda" selected>Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>
    </tag:if>
       <tag:if test="${driverdata.getAddress()=='gampaha'}">
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle">Galle</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha" selected>Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>
    </tag:if>
       <tag:if test="${driverdata.getAddress()=='kurunegala'}">
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle">Galle</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala" selected>Kurunegala</option>
    <option value="jaffna">Jaffna</option>
    </tag:if>
       <tag:if test="${driverdata.getAddress()=='jaffna'}">
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle">Galle</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna" selected>Jaffna</option>
    </tag:if>
         <tag:if test="${driverdata.getAddress()}">
  <option VALUE="" selected><b>Select Branch</b></option>
  <option value="galle">Galle</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>
    </tag:if>
</select>
 
  </div><br>
   
  <div class="form-group ">
    <input type="text" class="form-control addvehicle-input" name="contact" id="" placeholder="Driver Contact Number" value="${driverdata.getContactnumber()}" required>
  </div><br>
  <div class="form-group ">
    <input type="email" class="form-control addvehicle-input" name="email" id="" placeholder="Email Address" value="${driverdata.getEmail()}" required>
  </div><br>
    <div class="form-group " >
          <select class="form-select" aria-label="Default select example" name="model" required>
         <option VALUE="">Select Vehicle Model</option>
         <option value="${driverdata.getVehicleID()}" selected>${dropdown.getVehicle_Model()}</option>
      <tag:forEach var="vehicle" items="${vehicleData}">
      
      <option value="${vehicle.getVehicleID()}">${vehicle.getVehicle_Model()}</option>
      </tag:forEach>   
      </select>
  </div><br>
 <input type="hidden" name="updatenic" value="${driverdata.getNicnumber()}"/>
   <input type="hidden" name="action" value="update"/>
    
   <div class="d-flex justify-content-center">
  <button type="submit" class="btn btn-success addvehiclebtn">Update Driver</button></div>
 
 </form>
 
 </div>
</div>
</div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
<script src="javascript/script-dashboard.js"></script>
 
</body>
</html>