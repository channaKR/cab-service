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
<title></title>
</head>
<body>

<div class="d-flex" id="wrapper">
<jsp:include page="admin-dashboard-side.jsp" />
<div id="page-content-wrapper">
<jsp:include page="admin-dashboard-header.jsp" />

<h1></h1>
 <div class="container-fluid px-4">
            

                <div class="row my-5">
                    <h3 class="fs-4 mb-3"><b>Vehicles</b><br></h3>
                      
                    <div class="col">
                        
                        <table class=" table bg-white shadow-lg p-3 mb-5 bg-white rounded bg-transparent text-dark table-hover">
                          <thead>
                                <tr>
                                    <th scope="col" width="50">#</th>
                                    <th scope="col">Register Number</th>
                                    <th scope="col"> Model</th>
                                    <th scope="col"> Seats</th>
                                     <th scope="col">Type</th>
                                      <th scope="col">Coast Per Hour</th>
                                       <th scope="col">City</th>
                                        <th scope="col" colspan="2">Action</th>
                                </tr>
                           </thead>
                            <tbody>  
                              <tag:forEach var="vehicle" items="${vehicleData}">

                                <tr>
                                   
                                    <td>${vehicle.getVehicleID()}</td>
                                    <td>${vehicle.getVehicle_Registernumber()}</td>
                                    <td>${vehicle.getVehicle_Model()}</td>
                                    <td>${vehicle.getNumberof_Seat()}</td>
                                    <td>${vehicle.getVehicle_Type()}</td>
                                    <td>${vehicle.getCostper_Km()}</td>
                                    <td>${vehicle.getBranch()}</td>
                                    <td> 
                                    <form action="editVehicle" method="post">
                                     <input type="hidden" id="productCode" name="vehicleID" value="${vehicle.getVehicleID()}"/> 
                                    <input type="hidden" name="action" value="editVehicle"/>
                                    <button class="btnedit btn btn-primary">Edit</button>
                                    </form>
                                    <td> 
                                    <form action="deleteVehicle" method="post">
                                     <input type="hidden" id="productCode" name="vehicleID" value="${vehicle.getVehicleID()}"/> 
                                    <input type="hidden" name="action" value="deleteVehicle"/>
                                     <button class="btn btn-danger">Delete</button>
                                    
                                    </form>
                                    </td>
                                </tr>
                                </tag:forEach>
                                
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
</div>
<h4>${message}</h4>
 
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
<script src="javascript/script-dashboard.js"></script>
</body>
</html>