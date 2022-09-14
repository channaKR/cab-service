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
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<div class="d-flex" id="wrapper">

<jsp:include page="admin-dashboard-side.jsp" />
<div id="page-content-wrapper">
<jsp:include page="admin-dashboard-header.jsp" />
 <div class="container-fluid px-4">
 <div class="d-flex justify-content-center">
<tag:set var = "vehicle" scope = "session" value = "${vehicle}"></tag:set>

<form class="addvehicle-formdiv" action="updateVehicle" method="post" >
<div class="form-group ">
    
      <div class="form-group ">
    <input type="text" class="form-control addvehicle-input" name="register_Number" id="" placeholder="Vehicle Register Number" value="${vehicle.getVehicle_Registernumber()}" required>
  </div><br></div>
  <div class="form-group">
    <input type="text" class="form-control addvehicle-input" name="vehicle_Model" id="" placeholder="Vehicle Model" value="${vehicle.getVehicle_Model()}"  required></div><br>
    <div class="form-group ">
    <input type="number" min="2" class="form-control addvehicle-input" name="vehicle_Seat" id="" placeholder="Vehicle Seat" value="${vehicle.getNumberof_Seat()}"  required>
  </div><br><input type="hidden" name="vehicleID" value="${vehicle.getVehicleID()}"> 
   <div class="form-group ">
    <input type="number" min="1000" class="form-control addvehicle-input" name="costPer_Km" id="" placeholder="Coast Per Km" value="${vehicle.getCostper_Km()}"  required>
  </div><br>
  <div class="form-group " >
 
 <select class="form-select" aria-label="Default select example" name="vehicle_type" required>
 <tag:set var = "vehicletype" scope = "session" value = "${vehicle.getVehicle_Type()}"/>
 <tag:if test="${vehicletype=='car'}">
  <option VALUE=""><b>Select Vehicle Type</b></option>
  <option value="car" selected>Car</option>
  <option value="van">Van</option>
  <option value="bus">Bus</option>
  </tag:if>
   <tag:if test="${vehicletype=='van'}">
  <option VALUE=""><b>Select Vehicle Type</b></option>
  <option value="car">Car</option>
  <option value="van" selected>Van</option>
  <option value="bus">Bus</option>
  </tag:if>
    <tag:if test="${vehicletype=='bus'}">
  <option VALUE=""><b>Select Vehicle Type</b></option>
  <option value="car">Car</option>
  <option value="van">Van</option>
  <option value="bus" selected>Bus</option>
  </tag:if>
  </select><br/>
 

   <tag:set var = "vehiclebranch" scope = "session" value = "${vehicle.getBranch()}"/>
  
   <select class="form-select form-group" aria-label="Default select example" name="branch" required>
    <tag:if test="${vehiclebranch=='kandy'}">
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle">Galle</option>
  <option value="kandy" selected>Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>
    </tag:if>
       <tag:if test="${vehiclebranch=='galle'}">
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle" selected>Galle</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>
    </tag:if>
       <tag:if test="${vehiclebranch=='nugegoda'}">
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle">Galle</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda" selected>Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>
    </tag:if>
       <tag:if test="${vehiclebranch=='gampaha'}">
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle">Galle</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha" selected>Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>
    </tag:if>
       <tag:if test="${vehiclebranch=='kurunegala'}">
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle">Galle</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala" selected>Kurunegala</option>
    <option value="jaffna">Jaffna</option>
    </tag:if>
       <tag:if test="${vehiclebranch=='jaffna'}">
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle">Galle</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna" selected>Jaffna</option>
    </tag:if>
         <tag:if test="${vehiclebranch==''}">
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
    
    <div class="d-flex justify-content-center">
    <input type="hidden" name="action" value="updateVehicle"/>
   <button type="submit" class="btn btn-success addvehiclebtn">Update Vehicle</button>
    </div>
  </form>
  <p>${message}</p>
  </div>
 </div>
</div>
 </div>
</div>

<script src="javascript/script-dashboard.js"></script>

</body>
</html>