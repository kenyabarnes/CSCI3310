<%-- 
    Document   : listStudents
    Created on : Nov 2, 2017, 12:08:27 PM
    Author     : jqu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSCI 3310 </title>
    </head>
    <body>
        <h1>Student List</h1>
        <table border="1">
            <thead>
                <th>Email</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone Number</th>
            </thead>
            <tbody>
                <c:forEach items="${students}"  var="student">
                    <tr>
                        <td><c:out value="${student.email}" /></td>
                        <td><c:out value="${student.firstName}" /></td>
                        <td><c:out value="${student.lastName}" /></td>
                        <td><c:out value="${student.phone}" /></td>
                    </tr>        
                </c:forEach>    
            </tbody>
            
        </table>
    </body>
</html>
