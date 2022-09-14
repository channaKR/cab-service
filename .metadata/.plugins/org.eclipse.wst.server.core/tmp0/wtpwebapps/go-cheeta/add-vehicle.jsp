<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
 <form class="addvehicle-formdiv" onsubmit="return validateForm()"  action="addVehicle" method="post" >
  <div class="form-group ">
    <input type="text" class="form-control addvehicle-input" name="register_Number" id="" placeholder="Vehicle Register Number" required>
  </div><br>
  <div class="form-group">
    <input type="text" class="form-control addvehicle-input" name="vehicle_Model" id="" placeholder="Vehicle Model" required></div><br>
    <div class="form-group ">
    <input type="number" min="2" class="form-control addvehicle-input" name="vehicle_Seat" id="" placeholder="Vehicle Seat" required>
  </div><br>
   <div class="form-group ">
    <input type="number" min="1000" class="form-control addvehicle-input" name="costPer_Km" id="" placeholder="Coast Per Km" required>
  </div><br>
  <div class="form-group " >
<select class="form-select" aria-label="Default select example" name="vehicle_type" required>
  <option VALUE=""><b>Select Vehicle Type</b></option>
  <option value="car">Car</option>
  <option value="van">Van</option>
  <option value="bus">Bus</option>
</select>

  </div><br>
  <div class="form-group " >
  <select class="form-select form-group" aria-label="Default select example" name="branch" required>
   
  <option VALUE=""><b>Select Branch</b></option>
  <option value="galle">Galle</option>
  <option value="kandy" >Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>
    </select>
  </div><br>
  
    <div class="d-flex justify-content-center">
    <input type="hidden" name="action" value="addVehicle"/>
    
    <button type="submit" class="btn btn-success addvehiclebtn">Insert Vehicle</button>
    </div>
    
    </form>
  </div>

</div>
</div>
 </div>
</div>
<div>${message}</div>
<script src="javascript/script-dashboard.js"></script>

</body>
</html>