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
        <tr><td>ExpVouchID</td><td>Price</td></tr>
    <s:iterator value="cart.experiences" var="e">
        <tr>
            <td>${e.experiencevoucherid}</td>
            <td>${e.price}</td>
        </tr>
    </s:iterator>
    </table>

    <h1>RoomOfferings</h1>
    <table>
        <tr><td>RoomID</td><td>Adults</td><td>Children</td> ... </tr>
        <s:iterator value="cart.rooms" var="e">
            <tr>
                <td>${e.roomid}</td>
                <td>${e.adults}</td>
                <td>${e.children}</td>
                <td>${e.checkin}</td>
                <td>${e.checkout}</td>
                <td>${e.price}</td>
            </tr>
        </s:iterator>
    </table>

    <h1>Restaurants</h1>
    <table>
        <tr><td>RestID</td><td>Time</td> ... </tr>
        <s:iterator value="cart.restaurants" var="e">
            <tr>
                <td>${e.restaurantid}</td>
                <td>${e.time}</td>
                <td>${e.seats}</td>
                <td>${e.voucherprice}</td>
            </tr>
        </s:iterator>
    </table>
</body>
</html>
