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
<%
if((String) session.getAttribute("drivername")==null){
	
	response.sendRedirect("driver-login.jsp");
}
%>
<input type="hidden" name="drivernic" value="96512434v">
<div class="d-flex" id="wrapper">
<jsp:include page="driver-dashboard-side.jsp" />
<div id="page-content-wrapper">
<jsp:include page="driver-dashboard-header.jsp" />

 <div class="container-fluid px-4">
             

                <div class="row my-5">
                    <h3 class="fs-4 mb-3"><b>Vehicles</b><br>
                   
                       </h3>
                      <p>${message}</p>
                    <div class="col">
                        
                        <table class=" table bg-white shadow-lg p-3 mb-5 bg-white rounded bg-transparent text-dark table-hover">
                          <thead>
                                <tr>
                                    <th scope="col" width="50">#</th>
                                    
                                    <th scope="col"> Start Date</th>
                                    <th scope="col"> End Date</th>
                                     <th scope="col">Location</th>
                                      <th scope="col">Branch</th>
                                       <th scope="col">Km</th>
                                        <th scope="col">Coast</th>
                                        <th scope="col" colspan="2" >Action</th>
                                </tr>
                           </thead>
                            <tbody>  
                              <tag:forEach var="order" items="${orders}">
								
                                <tr>
                                    <td>${ order.getBooking_ID()}</td>
                                    <td>${ order.getStart_Date()}</td>
                                    <td>${ order.getEnd_Date() }</td>
                                    <td>${ order.getLocation()}</td>
                                    <td>${ order.getBaranch()}</td>
                                    <td>${ order.getKillometers()}</td>
                                    <td> ${ order. getCostfor_vehicle()} <td> 
                                    <tag:if test="${order.getConfirm()==0}">
                                    <td>
                                   <form action="updateData" method="post"> <input type="hidden" name="bookingid" value="${order.getBooking_ID()}"><input type="hidden" name="action" value="cofirm"><button type="submit" class="cofrm btn btn-primary btn-xs">Confirm</button></form>
                                   <button type="submit" class="cancel btn btn-danger">Cancel</button></td>
                                   
                                   </tag:if>
                                   <tag:if test="${order.getConfirm()==1}">
                                    
                                           <td><form action="insertData" method="post">
                                           <input type="hidden"  name="customerid" value="${order.getCustomerid()}">
                                           <input type="hidden"  name="cost" value="${order.getCostfor_vehicle()}">
                                           <input type="hidden"  name="vehicleid" value="${order.getVehicle_ID()}">
                                           <input type="hidden"  name="branch" value="${order.getBaranch()}">
                                           <input type="hidden"  name="bookingid" value="${ order.getBooking_ID()}">
                                            <input type="hidden" name="action" value="confirmpayment">
                                            
                                             <button class="cofrm btn btn-primary"><i class="fa fa-check" aria-hidden="true"></i>
                                             Pay</button></form>
                                       <button class="cancel btn btn-danger">Cancel</button></td>
                                   </tag:if>
                                   
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

<tag:forEach var="saleData" items="${sale}">
 <h1>${sale.getBranch()}</h1>
 </tag:forEach>
</body>
</html>