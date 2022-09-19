<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib prefix = "tag" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"/>
     <link rel="stylesheet" href="css/addmin-dashboard-side.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>

<link rel="stylesheet" href="css/booking-style.css" />
<style>
body{
       background-image: url("image/bookingbg.jpeg");
       background-size: auto; 
        background-repeat: repeat;
       color:white;
       
       }
       
       
       
.fstrow .form-group{
    Display:flex;
    
    
 } 
 .fstrow .form-group input{
    margin: 10px;
   
    
 }
  .fstrow .form-group  input{
  color:red;
  font-weight:bold;
  width:200%;
  }
 
 .cent{
 
 padding-top:50px;
 
 
 }
   
   .searchbtn{
      margin: 10px;
      width:100%;
      height:100%;
   }
   
  .mt-100{
margin-top: 100px;
}
.card {
    border-radius: 7px !important;
    border-color: #e1e7ec;
}

.mb-30 {
    margin-bottom: 30px !important;
}

.card-img-tiles {
    display: block;
    border-bottom: 1px solid #e1e7ec;
}

a {
    color: #0da9ef;
    text-decoration: none !important;
}

.card-img-tiles>.inner {
    display: table;
    width: 100%;
}

.card-img-tiles .main-img, .card-img-tiles .thumblist {
    display: table-cell;
    width: 65%;
    padding: 15px;
    vertical-align: middle;
}

.card-img-tiles .main-img>img:last-child, .card-img-tiles .thumblist>img:last-child {
    margin-bottom: 0;
}

.card-img-tiles .main-img>img, .card-img-tiles .thumblist>img {
    display: block;
    width: 100%;
    margin-bottom: 6px;
}
.thumblist {
    width: 35%;
    border-left: 1px solid #e1e7ec !important;
    display: table-cell;
    width: 65%;
    padding: 15px;
    vertical-align: middle;
}



.card-img-tiles .thumblist>img {
    display: block;
    width: 100%;
    margin-bottom: 6px;
}
.btn-group-sm>.btn, .btn-sm {
    padding: .45rem .5rem !important;
    font-size: .875rem;
    line-height: 1.5;
    border-radius: .2rem;
}
.cb{
background-color:#343D4C;
font-weight:bold;
color:white;
}

	.x{

			font-weight: bold;
			padding-left: 10px;
		}
</style>

<title>Available Vehicle</title>
</head>



<body>

<%

if((String) session.getAttribute("user")==null){
	
	response.sendRedirect("customer-login.jsp");
}
%>
<jsp:include page="customer-navbar.jsp" />
<div class="container-fluid px-4">
             

                <div class="row my-5">
                    <h3 class="fs-4 mb-3"><b></b><br>
                   
                       </h3>
                      <p>${message}</p>
                    <div class="col">
                        <table class=" table bg-white shadow-lg p-3 mb-5 bg-white rounded  text-dark table-hover">
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
                                      <th> Contact Driver</th>
                                     
                                </tr>
                           </thead>
                                <tbody>  
                                
                                 <tag:forEach var="order" items="${customerbooking}">
                                 
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
                                 <tag:if test="${order.getConfirm()==0}">
                                
                                  <div>No</div>
                                  </tag:if>
                                   <tag:if test="${order.getConfirm()==1}">
                                 <div>Yes</div>
                                 </tag:if>
                                 
                                 
                                 </td>
                                 
                                 <td>
                                 <form action="viewData" method="post">
                                 <input type="hidden" name="vehicleid" value="${order.getVehicle_ID()}">
                                 <input type="hidden" name="action" value="driverinfor">
                                 <button class="btn btn-primary " type="submit"><i class="bi bi-telephone"></i>Contact</button>
                                 </form>
                                 </td>
                                 </tr>
                                 
                                 
                                 
                                 
                                 
                                 </tag:forEach>
                                
                                
                                
                                
                                
                                
                                </tbody>
                        
                        
                        
                        </table>
                        
                       
                    </div>
                </div>
</div>
</body>

</html>