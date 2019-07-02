<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html5 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Donut List Order</title>
    </head>
    <body>
    	<form method="POST" action="donutListOrder">
    	<c:forEach var="donutListOverview" items="${donutListOverview.donut}" varStatus="status">
	 		<table border="1">  
	 			<tr>
	 				<th>ID</th>
	 				<th>Name</th>
	 				<th>Price</th>
	 				<th>Store</th>
	 				<th>Order Number</th>
	 			</tr>
	 		 	<tr>
                    <td><input  style="text-align:center;" type="text" name="donut[${status.index}].ID" value='${donutListOverview.ID}' readonly></td>
                    <td><input  style="text-align:center;" type="text" name="donut[${status.index}].name" value='${donutListOverview.name}' readonly></td>
                    <td><input  style="text-align:center;" type="text" name="donut[${status.index}].price" value='${donutListOverview.price}' readonly></td>
                    <td><input  style="text-align:center;" type="text" name="donut[${status.index}].store" value='${donutListOverview.store}' readonly></td>   
                    <td>
	                    <select name="donut[${status.index}].order">
							<c:forEach var="storeCount" begin="0" end="${donutListOverview.store}">	
								<option value="${storeCount}">${storeCount}</option>
							</c:forEach>     
						</select>
					</td>    
	       	</table>
	    </c:forEach>
	       	<table>
                <tr>
                	<td><input type="submit" value="Order" /> </td>
                </tr>
            </table>
       	</form>
    </body>
    </html>