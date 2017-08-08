<%--
  Created by IntelliJ IDEA.
  User: seb
  Date: 1/8/17
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>DB</title>
</head>
<body>


<h1>HOTELS</h1>
<table>
 <s:iterator value="hotels" var="hotel">
    <tr>
        <td>${hotel.id}</td>
        <td>${hotel.name}</td>
        <td>${hotel.address}</td>
    </tr>
</s:iterator>
</table>

<h1>RESTAURANTS</h1>
<table>
    <s:iterator value="restaurants" var="r">
        <tr>
            <td>${r.id}</td>
            <td>${r.name}</td>
            <td>${r.address}</td>
            <td>${r.contact}</td>
        </tr>
    </s:iterator>
</table>

<h1>EXPERIENCES</h1>
<table>
    <s:iterator value="experiences" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.name}</td>
            <td>${e.location}</td>
        </tr>
    </s:iterator>
</table>

</body>
</html>
