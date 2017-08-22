<%--
  Created by IntelliJ IDEA.
  User: seb
  Date: 2/8/17
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

Example of recommendations system:

Results for coordinates: <s:property value="coordinates"></s:property>


<h1>HOTELS</h1>
<table>
    <s:iterator value="result_hotels" var="hotel">
        <tr>
            <td>${hotel.id}</td>
            <td>${hotel.name}</td>
            <td>${hotel.address}</td>
            <td>${hotel.longitude}</td>
            <td>${hotel.latitude}</td>
        </tr>
    </s:iterator>
</table>

<h1>RESTAURANTS</h1>
<table>
    <s:iterator value="result_restaurants" var="r">
        <tr>
            <td>${r.name}</td>
            <td>${r.address}</td>
            <td>${r.longitude}</td>
            <td>${r.latitude}</td>
        </tr>
    </s:iterator>
</table>

<h1>EXPERIENCES</h1>
<table>
    <s:iterator value="result_experiences" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.name}</td>
            <td>${e.location}</td>
            <td>${e.longitude}</td>
            <td>${e.latitude}</td>
        </tr>
    </s:iterator>
</table>


</body>
</html>
