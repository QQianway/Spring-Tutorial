<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report</title>
    </head>
    <body>
    		${report}
        <div align="center">
            <h1>Report List</h1>
        </div>
            <table border="1">
            	<tr>
	            	<th>Sales ID</th>
	                <th>Date</th>
	                <th>Total Amount</th>
            	</tr>       
                <c:forEach var="report" items="${salesList}" varStatus="status">
                <tr>
                    <td>${report.id}</td>
                    <td>${report.date}</td>
                    <td>${report.totalAmount}</td>           
                </tr>
                </c:forEach>             
            </table>
            <table>
                <tr>
	            	<th>Sales Count</th>
	                <th>Total Earns</th>
            	</tr> 
                <tr>
                	<td>${salesCount}</td>
                    <td>${total}</td>
                </tr>
            </table>
    </body>
</html>
