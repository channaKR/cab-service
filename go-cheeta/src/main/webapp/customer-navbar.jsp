<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>
<link rel="stylesheet" href="css/homepagenavbar.css" />
<title>Insert title here</title>
<style>
.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 10px;
  border: none;
  cursor: pointer;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #141D28;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {}

.dropdown:hover .dropdown-content {
  display: block;
}


</style>
</head>
<body>

    <div class="navbar">
      <h1 class="logo">Go<span>Cheeta</span></h1>
      <ul>
        <li><a href="customer-index.jsp">Home</a></li>
        <li><a href="available-vehicle.jsp">Booking</a></li>
        <li>
        <div class="dropdown">
        <a href="account-user-dashboard.jsp" class="dropdown">Account</a>
         
			  <div class="dropdown-content">
			  <form action="bookingVehicle" method="POST" id="bookingdata">
			  <input type="hidden" name="customer" value="<%=session.getAttribute("customerid")%>">
				<input type="hidden" name="action" value="myorders">	
			  <a href="#" onclick="submitID()">View Booking</a>
			  </form>
			  <form action="saledata" method="POST" id="vieworder">
			  <input type="hidden" name="action" value="orderhistory">	
			  
			  <input type="hidden" name="customer" value="<%=session.getAttribute("customerid")%>">
			  <a href="#" onclick="submitOderHistory()">View History </a>
			  </form>
			  <a href="#">Add Comment</a>
			  <a href="#">Messages</a>
  			</div>
  			</div>
        </li>
        
      </ul>
    </div>
    
      <script>
		function submitID() {
		document.getElementById("bookingdata").submit();
		}
		
		function submitOderHistory() {
			document.getElementById("vieworder").submit();
			}
			
	   </script>
</body>
</html>