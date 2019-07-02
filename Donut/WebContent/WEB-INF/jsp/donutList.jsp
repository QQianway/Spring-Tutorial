<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DonutList</title>
    </head>
    <body>
        <div align="center">
            <h1>Donut List</h1>
            <table border="1">
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Store</th>
                 
                <c:forEach var="donutList" items="${donutList.donut}" varStatus="status">
                <tr>
                    <td>${donutList.ID}</td>
                    <td>${donutList.name}</td>
                    <td>${donutList.price}</td>
                    <td>${donutList.store}</td>    
                    <td><a href="donutView?id=${donutList.ID}">View</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>             
                </tr>
                </c:forEach>             
            </table>
            <table>
                <tr>
                	<td><a href="donutListOverview">Order</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                </tr>
            </table>
        </div>
    </body>
</html>