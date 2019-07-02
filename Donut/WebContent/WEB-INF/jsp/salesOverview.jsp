<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales Overview</title>
    </head>
    <body>
        <div align="center">
            <h1>Sales List</h1>
	 		<table border="1">  
	                <tr>
	                	<td>ID</td>
	                	<td><input type="text" name="id" value='${sales.id}' readonly></td>
	                </tr>
	                <tr>
	                	<td>Date</td>
	                	<td><input type="text" name="date" value='${sales.date}' readonly></td>
	                </tr>
	                <tr>
	                	<td>Donut Order</td>
	                	<c:forEach var="item" items="${sales.salesItem}" varStatus="status">
	                	<td><input type="text" name="donut[${status.index}].name" value='${item.name} ${item.order}' readonly></td>
	                	</c:forEach>
	                </tr>
	                <tr>
	                	<td>Total Amount</td>
	                	<td><input type="text" name="totalAmount" value='${sales.totalAmount}' readonly></td>
	                </tr>   
	       	</table>
        </div>
        <a href="home">Home</a>
    </body>
</html>