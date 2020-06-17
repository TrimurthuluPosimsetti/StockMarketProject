<%@page import="com.mthree.dto.AllOrdersDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  font-family: 'Open Sans', sans-serif;
  font-weight: 300;
  line-height: 1.42em;
  color:#A7A1AE;
  background-color:#1F2739;background-image: url("banner.jpg");
  background-color: #cccccc;
  height: 100%;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

h1 {
  font-size:3em; 
  font-weight: 300;
  line-height:1em;
  text-align: center;
  color: #FB667A;
}

h2 {
  font-size:1em; 
  font-weight: 300;
  text-align: center;
  display: block;
  line-height:1em;
  padding-bottom: 2em;
  color: #FB667A;
}

h2 a {
  font-weight: 700;
  text-transform: uppercase;
  color: #FB667A;
  text-decoration: none;
}

.blue { color: #185875; }
.container th h1 {
	  font-weight: bold;
	  font-size: 1em;
  text-align: left;
  color: #185875;
}
.container td {
	  font-weight: normal;
	  font-size: 1em;
  -webkit-box-shadow: 0 2px 2px -2px #0E1119;
	   -moz-box-shadow: 0 2px 2px -2px #0E1119;
	        box-shadow: 0 2px 2px -2px #0E1119;
}
.container {
	  text-align: left;
	  overflow: hidden;
	  width: 80%;
	  margin: 0 auto;
  display: table;
  padding: 0 0 8em 0;
}
.container td, .container th {
	  padding-bottom: 2%;
	  padding-top: 2%;
  padding-left:2%;  
}
.container tr:nth-child(odd) {
	  background-color: #323C50;
}
.container tr:nth-child(even) {
	  background-color: #2C3446;
}

.container th {
	  background-color: #1F2739;
}

.container td:first-child { color: #FB667A; }

.container tr:hover {
   background-color: #464A52;
-webkit-box-shadow: 0 6px 6px -6px #0E1119;
	   -moz-box-shadow: 0 6px 6px -6px #0E1119;
	        box-shadow: 0 6px 6px -6px #0E1119;
}

.container td:hover {
  background-color: #FFF842;
  color: #403E10;
  font-weight: bold;
  
  box-shadow: #7F7C21 -1px 1px, #7F7C21 -2px 2px, #7F7C21 -3px 3px, #7F7C21 -4px 4px, #7F7C21 -5px 5px, #7F7C21 -6px 6px;
  transform: translate3d(6px, -6px, 0);
  
  transition-delay: 0s;
	  transition-duration: 0.4s;
	  transition-property: all;
  transition-timing-function: line;
}
input[type=submit] {
 	padding:5px 20px;
  border:1px solid rgba(0,0,0,0.4);
  text-shadow:0 -1px 0 rgba(0,0,0,0.4);
  box-shadow:
    inset 0 1px 0 rgba(255,255,255,0.3),
    inset 0 10px 10px rgba(255,255,255,0.1);
  border-radius:0.3em;
  background:#0184ff;
  color:white;
  float:right;
  font-weight:bold;
  cursor:pointer;
  font-size:13px;
}
@media (max-width: 800px) {
.container td:nth-child(4),
.container th:nth-child(4) { display: none; }
}
</style>
</head>
<body>
<pre>

<h1><span class="blue"></span>Order Details<span class="blue"></span></h1>
</pre>

<%!
List<AllOrdersDTO> orders;
%>
<form action="/deleteOrder" method="post">
<table class="container">
	<thead>
		<tr>
			<th><h1>Company</h1></th>
			<th><h1>Shares</h1></th>
			<th><h1>Price</h1></th>
			
			<th><h1>Status</h1></th>
			<th><h1></h1></th>
		</tr>
	</thead>
	<%

	orders = (List<AllOrdersDTO>) session.getAttribute("orderList");
	for(AllOrdersDTO o : orders)
	{
	
%>
	<tbody>
		<tr>
			<td> <%=o.getCompanyName()%> </td>
			<td><%=o.getNoofShares()%></td>
			<td><%=o.getPrice()%></td>
			<td><%=o.getStatus()%></td>
			<td> <button type="submit" name="deleteOrder"  value="<%= o.getOrderId() %>">Delete</button></td>
		</tr>
	</tbody>
	<% 
}
%>
</table>
</form>
<form>
<p class="p-container">
	<input type="submit" name="back" id="back" value="Back To Home" formaction="homepage.jsp">
  </p>
</form>
</body>
</html>