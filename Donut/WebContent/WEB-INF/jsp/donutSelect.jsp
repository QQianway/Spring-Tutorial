<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>DonutSelect</title>
    </head>
    <body>
    	<form method="POST" action="donutSelectedOrder">
	 		<table border="1">  
	                <tr>
	                	<td>ID</td>
	                	<td><input type="text" name="ID" value='${donutSelected.ID}' readonly></td>
	                </tr>
	                <tr>
	                	<td>Name</td>
	                	<td><input type="text" name="name" value='${donutSelected.name}' readonly></td>
	                </tr>
	                <tr>
	                	<td>Price</td>
	                	<td><input type="text" name="price" value='${donutSelected.price}' readonly></td>
	                </tr>
	                <tr>
	                	<td>Store</td>
	                	<td><input type="text" name="store" value='${donutSelected.store}' readonly></td>
	                </tr>
	                <tr>
	                	<td>Order</td>
	                	<td><input type="text" name="order"></td>
	                </tr>
	                <tr>
	                	<td><input type="submit" value="Submit" /> </td>
	                </tr>     
	       	</table>
       	</form>
    </body>
    </html>