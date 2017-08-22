<%--
  Created by IntelliJ IDEA.
  User: Scott
  Date: 14/08/2017
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Cart Test</title>
</head>
<body>
    <s:property value="cart.name"/>

    <h1>ExperienceVouchers</h1>
    <table>
        <tr><td>ExpID</td><td>Price</td></tr>
        <s:iterator value="cart.experiences" var="e">
        <tr>
            <td>${e.experience.id}</td>
            <td>${e.experience.name}</td>
        </tr>
        </s:iterator>
    </table>

    <h1>RoomOfferings</h1>
    <table>
        <tr><td>hotelID</td><td>Adults</td><td>Children</td> ... </tr>
        <s:iterator value="cart.hotels" var="e">
            <tr>
                <td>${e.hotel.id}</td>
                <td>${e.hotel.name}</td>
                <td>${e.adults}</td>
                <td>${e.children}</td>
                <td>${e.checkIn}</td>
                <td>${e.checkOut}</td>
                <td>${e.price}</td>
            </tr>
        </s:iterator>
    </table>

    <h1>Restaurants</h1>
    <table>
        <tr><td>RestID</td><td>Time</td> ... </tr>
        <s:iterator value="cart.restaurants" var="e">
            <tr>
                <td>${e.restaurant.id}</td>
                <td>${e.restaurant.name}</td>
                <td>${e.time}</td>
                <td>${e.seats}</td>
                <td>${e.voucherPrice}</td>
            </tr>
        </s:iterator>
    </table>

    <h1>Transport</h1>
    <table>
        <tr><td>TransID</td><td>Time</td></tr>
        <s:iterator value="cart.transport" var="e">
            <tr>
                <td>${e.transport.id}</td>
                <td>${e.transport.name}</td>
                <td>${e.time}</td>
            </tr>
        </s:iterator>
    </table>
</body>
</html>
