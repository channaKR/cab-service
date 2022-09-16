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
<style>
.btnline{
  Display:inline;
}
</style>
</head>
<body>

<input type="hidden" name="drivernic" value="96512434v">
<div class="d-flex" id="wrapper">
<jsp:include page="admin-dashboard-side.jsp" />
<div id="page-content-wrapper">
<jsp:include page="admin-dashboard-header.jsp" />

 <div class="container-fluid px-4">
             

                <div class="row my-5">
                    <h3 class="fs-4 mb-3"><b>Vehicles</b><br>
                   
                       </h3>
                      <p>${message}</p>
                    <div class="col">
                        <table class=" table bg-white shadow-lg p-3 mb-5 bg-white rounded bg-transparent text-dark table-hover">
                            <thead>
                                <tr>
                                    <th scope="col" width="50">ID</th>
                                    <th scope="col"> Start Date</th>
                                    <th scope="col"> End Date</th>
                                     <th scope="col">Branch</th>
                                     <th scope="col">Location</th>
                                      <th scope="col" style="width:10%">Km</th>
                                       <th scope="col">Vehicle ID</th>
                                        <th scope="col">Customer ID</th>
                                         <th scope="col">Full Coast</th>
                                      <th scope="col">Confirm</th>
                                     
                                </tr>
                           </thead>
                                <tbody>  
                                
                                 <tag:forEach var="order" items="${viewAllBooking}">
                                 
                                 <tr>
                                 
                                  <td>${ order.getBooking_ID()}</td>
                                  <td>${ order.getStart_Date()}</td>
                                  <td>${ order.getEnd_Date() }</td>
                                 <td>${ order.getBaranch()}</td>
                                  <td>${ order.getLocation()}</td>
                                 <td>${ order.getKillometers()}</td>
                                 <td>${ order.getVehicle_ID()}</td>
                                 <td>${ order. getCustomerid()}</td>
                                 <td>${ order.getCostfor_vehicle()}</td>
                                 <td>
                                 <tag:if test="${order.isConfirm()==0}">
                                
                                  <div>No</div>
                                  </tag:if>
                                   <tag:if test="${order.isConfirm()==1}">
                                 <div>Yes</div>
                                 </tag:if>
                                 
                                 
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

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
<script src="javascript/script-dashboard.js"></script>


</body>
</html>