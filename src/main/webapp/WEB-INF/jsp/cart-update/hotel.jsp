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

<form action="update-hotel">

    <input type="hidden" name="cartIndex" value="${cartIndex}">

    <br/>RoomID:<br/>
    <input type="number" name="roomId" value="${hotel.room.id}">

    <br/>Adults:<br/>
    <input type="number" name="adults" value="${hotel.adults}">
    <br/>Children:<br/>
    <input type="number" name="children" value="${hotel.children}">

    <br/>CheckIn:<br/>
    <input type="text" name="checkIn" value="${hotel.checkIn}">
    <br/>CheckOut:<br/>
    <input type="text" name="checkOut" value="${hotel.checkOut}">

    <input type="submit" value="Submit">
</form>

</body>
</html>
