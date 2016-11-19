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

	<table>
		<thead>
			<tr>
				<th>ProductID</th>
				<th>ProductName</th>
				<th>Order</th>
			</tr>
		</thead>
		
	<%	ArrayList<Product> prolist = (ArrayList<Product>)session.getAttribute("productlist");%>
	<% for(Product p: prolist){ %>
 
		<tbody>
			<form action="Product" method="post">
			<tr>
				<td><%=p.getProduct_id() %></td>
				<input type="hidden" name="productid" value="<%=p.getProduct_id()%>" >
				<td><%=p.getProduct_name() %></td>
				<td><input type="Submit" class="submitLink" value="Review"></td>
			</tr>
			</form>
		<% }%>	
		</tbody>
	</table>
</body>
</html>