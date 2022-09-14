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
<jsp:include page="home-page-navbar.jsp" />
 
<div class="d-flex justify-content-center cent">
 <p>${message}</p>

<form action="availableVehicleDisplay" method="post">
<input type="hidden" name="action" value="availableVehicles"/>

<div class="fstrow">
<div class="form-group"><input type="date"  class=" txt form-control addvehicle-input" name="startdate" id="startdate"  required>
<input type="date"  class=" txt form-control addvehicle-input" name="enddate" id="enddate"   required>


 <button type="submit" class="searchbtn btn btn-light" >SEARCH</button> 
</div>
<!-- --> 
</div>

</form>

</div>

<div class="container mt-100">
                            		

                        	
                               
<div class="row">
 <tag:forEach var="vehicle" items="${availablevehicle}">    
          <div class="col-md-4 col-sm-6">
          
            <div class="card mb-30"><a class="card-img-tiles cb" href="#" data-abc="true">
        
         
                <div class="inner">
                
                </div></a>
              <div class="card-body text-center cb">
                             
            <table>
	<tr>
	<td rowspan="5">	
       <tag:set var = "type" scope = "session" value = "${vehicle.getVehicle_Type()}"/>
          <tag:if test="${type=='bus'}">
             <img src="https://illustoon.com/photo/dl/5901.png" width="150" height="150">
          </tag:if>
       <tag:if test="${type=='van'}">
                   <img src="https://illustoon.com/photo/dl/492.png" width="150" height="150">
          </tag:if>
         <tag:if test="${type=='car'}">
             <img src="https://illustoon.com/photo/dl/1741.png" width="150" height="150">
          </tag:if>
     
   
     </td>
	</tr>
	<tr>
	  <td class="x"> ${vehicle.getVehicle_Model()}</td>
	
	</tr>
	
	<tr>
     	<td class="x">Seat -${vehicle.getNumberof_Seat()} </td>


     </tr>
     
     <tr>
     	<td class="x">Cost Per KM -${vehicle.getCostper_Km()} </td>


     </tr>
     
     <tr>
     	<td class="x">
     	<form action="bookingData" method="post">
     	<input type="hidden" name="action" value="bookingData">
     	<input type="hidden" name="vehicleid" value="${vehicle. getVehicleID()}">
     	<input type="hidden" name="kmcost" value="${vehicle.getCostper_Km()}">
     	
     	 <button type="submit" class="btn btn-primary">Book Now</button>
     	</form>
     	</td>
         

     </tr>



</table>
              
               </div>
            </div>

            
          </div>
          
            </tag:forEach>
        </div>
     
        </div>

</body>

</html>