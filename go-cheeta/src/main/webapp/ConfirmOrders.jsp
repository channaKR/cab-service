<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib prefix = "tag" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"/>
     <link rel="stylesheet" href="css/addmin-dashboard-side.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>

<link rel="stylesheet" href="css/booking-style.css" />
<meta charset="ISO-8859-1">
<title></title>

<style>
body{
       background-image: url("image/bookingbg.jpeg");
       background-size: auto; 
        background-repeat: repeat;
       
       
       }
       
       
       
.fstrow .form-group{
    Display:flex;
    
    
 } 

</style>
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
                                    <th scope="col"> Customer ID</th>
                                    <th scope="col">Amount</th>
                                     <th scope="col">Vehicle ID</th>
                                     <th scope="col">Branch</th>
                                      <th>Payment Date</th>
                                      <th scope="col" colspan="2">View Vehicle</th>
                                      
                                     
                                </tr>
                           </thead>
                                <tbody>  
                                
                                 <tag:forEach var="order" items="${saledata}">
                                 
                                 <tr>
                                 
                                  <td>${order.getOrderid()}</td>
                                  <td>${order.getCustomerid()}</td>
                                  <td>${order.getPaymentcoast() }</td>
                                 <td>${order.getVehicleRegisterNumber()}</td>
                                  <td>${order.getBranch()}</td>
                                 <td>${order.getDate()}</td>
                               
                                 <td>
                                 <textarea rows="2" cols="12"></textarea>
                                 </td>
                                 <td>
                                 
                                 <button class="btn btn-primary " type="submit"><i class="bi bi-telephone"></i> Add Comment</button>
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