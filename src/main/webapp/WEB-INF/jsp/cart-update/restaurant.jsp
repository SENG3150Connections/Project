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

<form action="update-restaurant">

    <input type="hidden" name="cartIndex" value="${cartIndex}">
    <br/>Seats:<br/>
    <input type="number" name="seats" value="${restaurant.seats}">
    <br/>Time:<br/>
    <input type="text" name="time" value="${restaurant.time}">
    <br/>Voucher Price:<br/>
    <input type="number" name="voucherPrice" value="${restaurant.voucherPrice}">

    <input type="submit" value="Submit">
</form>

</body>
</html>
