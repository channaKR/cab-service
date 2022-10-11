<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/addmin-dashboard-side.css" />
<title></title>
</head>
<body>
 <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i class="fas fa-car"></i> Go Cheeta </div>
            <div class="list-group list-group-flush my-3">
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text active"><i
                        class="fas fa-tachometer-alt me-2"></i> Driver Dashboard</a>
               <form action="viewData" method="post" id="formSubmit">
               
                 <a href="#"  class="list-group-item list-group-item-action bg-transparent second-text active" onclick="submitID()">
                 <input type="hidden" name="action" value="bookingorder"><input type="hidden" name="drivernic" value="<%= session.getAttribute("drivernic") %>">
               <i class='fas fa-truck-monster' style='font-size:24px'></i>  View Orders</a>
                 </form>
                 <script>
					function submitID() {
					  document.getElementById("formSubmit").submit();
					}
					</script>
                
               <form action="driverLogout" method="post" id="logout">
                <a href="#" class="list-group-item list-group-item-action bg-transparent text-danger fw-bold" onclick="logout()"><i
                        class="fas fa-power-off me-2"></i>Logout</a>
                        <input type="hidden" name="action" value="driverlogout">
               </form>
            </div>
        </div>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
<script src="javascript/script-dashboard.js"></script>
<script>
function logout() {
	document.getElementById("logout").submit();
	}

</script>  
</body>

</html>