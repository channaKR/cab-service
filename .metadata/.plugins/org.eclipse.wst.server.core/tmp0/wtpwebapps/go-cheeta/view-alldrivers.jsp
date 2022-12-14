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
<h1>${message}</h1>
<%

if((String) session.getAttribute("useremail")==null){
	
	response.sendRedirect("admin-login.jsp");
}
%>

<div class="d-flex" id="wrapper">
<jsp:include page="admin-dashboard-side.jsp" />
<div id="page-content-wrapper">
<jsp:include page="admin-dashboard-header.jsp" />

 <div class="container-fluid px-4">
             

                <div class="row my-5">
                    <h3 class="fs-4 mb-3"><b>Drivers</b><br>
                   
                       </h3>
                      <p>${message}</p>
                    <div class="col">
                        <table class=" table bg-white shadow-lg p-3 mb-5 bg-white rounded bg-transparent text-dark table-hover">
                            <thead>
                                <tr>
                                    <th scope="col" width="50">Nic</th>
                                    <th scope="col"> Name</th>
                                    <th scope="col">Address</th>
                                     <th scope="col">Conact</th>
                                     <th scope="col">email</th>
                                     <th scope="col">Vehicle ID</th>
                                     <th scope="col" colspan="2">Action</th>
                                        
                                     
                                </tr>
                           </thead>
                         <tbody>  
                                
                                 <tag:forEach var="driver" items="${driversdata}">
                                 
                                 <tr>
                                    <td>${ driver.getNicnumber()}</td>
                                    <td>${ driver.getDrivername()}</td>
                                    <td>${ driver.getAddress()}</td>
                                    <td>${ driver.getContactnumber()}</td>
                                    <td>${ driver.getEmail()}</td>
                                    <td>${ driver.getVehicleID()}</td>  
                                    <td>
                                    <form action="viewData" method="Post">
                                    
                                    <input type="hidden" name="vehicleids"  value="${ driver.getVehicleID()}">
                                    <input type="hidden" name="action"  value="drivereditdata" >
                                    
                                    <button type="submit" class="btn btn-primary" >Edit</button>
                                    </form>
                                    </td>  
                                    
                                    <td>
                                    <form action="deleteData" method="Post">
                                     <input type="hidden" name="nic"  value="${ driver.getNicnumber()}">
                                    <input type="hidden" name="action"  value="deleteDriver" >
                                    <button type="submit" class="btn btn-danger">Delete</button>
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

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
<script src="javascript/script-dashboard.js"></script>


</body>
</html>