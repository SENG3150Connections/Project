<%--
  Created by IntelliJ IDEA.
  User: Scott
  Date: 24/08/2017
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="update-transport">

    <input type="hidden" name="cartIndex" value="${cartIndex}">
    <br/>Tickets:<br/>
    <input type="number" name="tickets" value="${transport.tickets}">
    <br/>Time:<br/>
    <input type="text" name="time" value="${transport.time}">

    <input type="submit" value="Submit">
</form>

</body>
</html>
