<%-- 
    Document   : ActiveTeamDirectory
    Created on : Nov 20, 2017, 7:23:31 PM
    Author     : Kenya
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Active Team Directory</title>
    </head>
    <body>
        <h1><b>Active Team Directory</b></h1>
        <p>
        <h2> Search: </h2>
        
        </p>
        <table border="1">
            <thead>
                <th>Team Number</th>
                <th>Team Size</th>
                <th> MentorID </th>
                <th>Project Number</th>
            </thead>
            <tbody>
                <c:forEach items="${teams}" var="teams">
                    <tr>
                         <td><c:out value="${teams.teamNumber}"/> </td>
                         <td><c:out value= "${teams.teamSize}"/> </td>
                         <td><c:out value="${teams.mentorID}"/> </td>
                         <td><c:out value="${teams.projectNumber}"/> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="index.html"> Back to Main Page </a>
    </body>
</html>
