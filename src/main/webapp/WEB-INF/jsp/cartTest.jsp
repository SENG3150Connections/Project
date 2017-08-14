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
        <tr><td>ID</td><td>Price</td></tr>
    <s:iterator value="cart.experiences" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.price}</td>
        </tr>
    </s:iterator>
    </table>

    <h1>RoomOfferings</h1>
    <table>
        <tr><td>ID</td><td>NoGuestMax</td></tr>
        <s:iterator value="cart.rooms" var="e">
            <tr>
                <td>${e.id}</td>
                <td>${e.noguestmax}</td>
            </tr>
        </s:iterator>
    </table>

    <h1>Restaurants</h1>
    <table>
        <tr><td>ID</td><td>Name</td></tr>
        <s:iterator value="cart.restaurants" var="e">
            <tr>
                <td>${e.id}</td>
                <td>${e.name}</td>
            </tr>
        </s:iterator>
    </table>
</body>
</html>
