<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>
<link rel="stylesheet" href="css/driverprofile.css" />
</head>
<body>
<div class="container d-flex justify-content-center align-items-center">
             
             <div class="card">

              <div class="upper">

                <img src="image/header.png" class="img-fluid">
                
              </div>

              <div class="user text-center">

                <div class="profile">

                  <img src="image/userimg.png" class="rounded-circle" width="80">
                  
                </div>

              </div>


              <div class="mt-5 text-center">

                <h4 class="mb-0"><%=session.getAttribute("drivername")%></h4>
                <span class=" d-block mb-2" style="font-weight:bold; padding-top:5%; "><%=session.getAttribute("dcontact")%></span>

                <button class="btn btn-primary btn-sm follow" style="font-weight:bold; font-size:20px;">Call</button>


                <div class="d-flex justify-content-between align-items-center mt-4 px-4">





                  
                  
                </div>
                
              </div>
               
             </div>

           </div>
</body>
</html>