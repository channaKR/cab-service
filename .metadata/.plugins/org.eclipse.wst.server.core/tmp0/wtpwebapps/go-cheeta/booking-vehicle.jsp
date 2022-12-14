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
       background-repeat: repeat;}
        
.row-data{

Display:flex;
}

.row-data input,.row-data label{
 margin-left:40px;
}

.row-web input,.row-web textarea,.row-web select{
  width:90%;
  margin-left:40px;

}


.row-web table tr th{

margin-left:600%;
}

.head-data{
margin-left:40px;
margin-bottom:20px;
color:white;
font-weight:bold;

}


.cent{

margin-top:40px;
}


.row-button{
width:40%;
margin-left:40px;



}
label{
color:white;}

row-data .spc{
margin-left:20px;

}

row-data .spc label{
margin-left:0px;

}

.km{

width:40px%;
}
</style>

<title>Booking Vehicle</title>
</head>



<body >
<%

if((String) session.getAttribute("user")==null&&session.getAttribute("customerid")==null){
	
	response.sendRedirect("customer-login.jsp");
}


%>
<div>


</div>
<jsp:include page="customer-navbar.jsp" />
 <div class="d-flex justify-content-center cent">
   <form action="bookingVehicle" method="post">
   
   <div class="head-data">BOOKING Vehicle</div>

  <div class="row-web">
 <select class="form-select form-group" aria-label="Default select example" name="branch" required>
  <option VALUE=""><b>Selelect City (TO)</b></option>
  <option value="galle">Galle</option>
  <option value="kandy">Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>

</select>
 
  </div><br>
  
  <div class="row-web">
   <textarea  type="email" rows="4" placeholder="Location" name="location" required ></textarea>
 </div><br>
  <div class="row-web">
 <select class="form-select form-group" aria-label="Default select example" name="frombranch" required>
  <option VALUE=""><b>Selelect City (From)</b></option>
  <option value="galle">Galle</option>
  <option value="kandy">Kandy</option>
  <option value="nugegoda">Nugegoda</option>
  <option value="gampaha">Gampaha</option>
  <option value="kurunegala">Kurunegala</option>
    <option value="jaffna">Jaffna</option>

</select>
 
  </div><br>
  <div class="row-web">
   <textarea  rows="4" placeholder="From Adress" name="fromad" required ></textarea>
 </div><br>

   <div class="row-data spc">
   
   <label>Start Date</label><input type="date" name="startdate" id="startdate" class="form-group" required/>
  
     
    </div><br>
    <div class="row-data spc">
   <label>End Date</label><input type="date"  class="form-group" name="enddate" id="enddate" required/>
    </div><br>
    
    <div class="row-web">
           <input type="number" class="form-group km" placeholder="KM" min="5" name="km"  required/>
    
 </div><br><input type="hidden" name="action" value="bookingvehicle">
 <input type="hidden" name="ID" value="<%= session.getAttribute("ID") %>">
  <input type="hidden" name="customid" value="<%= session.getAttribute("customerid") %>">
 <input type="hidden" name="costkm" value="<%= session.getAttribute("cost") %>">
 <div class="d-flex justify-content-center">
 
 <div class="row-button">
 
  <button type="submit" class="btn btn-success addvehiclebtn">Book Now</button></div></div>
   
 
   </form>
   
   <h1>${message}</h1>
   
 </div>
 
 
<script>
 startdate.min = new Date().toISOString().split("T")[0];
 
 

</script>
<script type="text/javascript">

enddate.min = new Date().toISOString().split("T")[0];
</script>
</body>

</html>