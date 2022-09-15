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
<style type="text/css">
.tsize{table-layout: auto;
  width: 20%;  }

tsize tbody tr .td{ font-weight: bold;}

tsize thead tr { border: 14pt double(1,12,1) }
thead { background: #38AAA4; color:#333A47; }
.search{

width: 20%;  
color:red;
display: flex;
  flex-wrap: nowrap;
  align-items: center;

}



</style>
</head>
<body>
<h1>${message}</h1>
<div class="d-flex" id="wrapper">

<jsp:include page="admin-dashboard-side.jsp" />
<div id="page-content-wrapper">
<jsp:include page="admin-dashboard-header.jsp" />
 <div class="container-fluid px-4">
 
 <div class="d-flex justify-content-center">
</div>
<h3 style="font-weight:bold">Branch Sales Details</h3>
<table class="tsize">
<thead>
<tr>
<th>Branch Name</th>
<th>Total</th>

</tr>

</thead>
 <tbody>  
 
 <tag:forEach var="sale" items="${saleData}">
 
 <tr>
 <td style="font-weight:bold">${sale.getBranch()}</td>
 <td style="font-weight:bold">${sale.getPaymentcoast()}</td>
 
 </tr>


 </tag:forEach>
 <tr>
 <thead>
 <tr>


 <th>Total Sale</th>


 <th>
 <tag:set var="total" scope="session" value="${tot}"/>
 <tag:out value="${total.getPaymentcoast()}"/>
 
 </th>
 
 </tr>
 
 
 </thead>
 
 

  
 </tbody>


</table><br>
<div class="search">
<input type="date"  class=" txt form-control addvehicle-input" name="enddate" id="enddate"   required>
<button type="submit" class="searchbtn btn btn-light" >Search</button> 
 </div>
</div>
</div>
 </div>

<div>${message}</div>



<script src="javascript/script-dashboard.js"></script>

</body>
</html>