<%-- 
    Document   : login
    Created on : Nov 7, 2017, 11:46:59 AM
    Author     : uuvin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Please enter student's email and phone to access the system</h1>
        <form action="ValidateStudentServlet" method="post">
            <div id="label">Email: </div> <input type="text" name ="email" /><br />
            <div id="label">Phone: </div> <input type="text" name ="phone" /><br />
            <input type = "submit" value ="Submit" id="rsubmit" />
        </form>
    </body>
</html>
