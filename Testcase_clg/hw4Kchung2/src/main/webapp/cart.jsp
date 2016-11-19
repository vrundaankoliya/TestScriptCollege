<%@page import="Kchung_DTO.SubProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Kchung_DTO.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<style type="text/css">
.submitLink {
  background-color: transparent;
  text-decoration: none;
  border: none;
  color: black;
  cursor: pointer;
}

submitLink:focus {
  outline: none;
}

table {
	color: #fff;
	font-family: Helvetica, Arial, sans-serif;
	border-collapse: collapse;
	padding: 0 3px;
	border-radius: 5px;
	margin: 25px auto;
}

td, th {
	height: 30px;
	transition: all 1.5s;
	text-align: center;
	padding: 5px 40px;
	border: 2px solid #000;
	width: 100px;
}

th {
	background: #000;
	font-weight: 700;
}

tr td {
	background: #fff;
	color: #000;
}

tr td:hover {
	background: #666;
	color: #FFF;
	font-weight: bold;
}
</style>


</head>
<body>
<form action="Checkout" method="post" >

	<table>
		<thead>
			<tr>
				
				<th>ProductName</th>
				<th>Author</th>
				<th>Rate</th>
				<th>Descrption</th>
				<th>Cancel</th>
			</tr>
		</thead>
		
	<%	ArrayList<SubProduct> producatlist = (ArrayList<SubProduct>)session.getAttribute("cartlist");%>
	<% int total = 0; 
	for(SubProduct p: producatlist){ %>
 		<tbody>
			
			<tr>
				
				<input type="hidden" name="productid" value="<%=p.getSubid()%>" >
				<td><%=p.getProductname()%></td>
				<td><%=p.getDetails() %></td>
				<td><%=p.getProductrate() %></td>
				<td><%=p.getExtra() %></td>
<%total = total +p.getProductrate() ;%>
				<td><input type="Submit" class="submitLink" value="Cancel"></td>
			</tr>
			
		<% }%>	
		</tbody>
		<thead>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>Total Amount:<%=total %><%session.setAttribute("total",total);%></td>
				<td><input type="Submit" class="submitLink" value="Checkout"></td>
			</tr>
		</thead>
		
	</table>
	</form>
</body>
</html>