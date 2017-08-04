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


Database test:
<table>

 <s:iterator value="results" var="hotel">
    <tr>
        <td>${hotel.id}</td>
        <td>${hotel.name}</td>
        <td>${hotel.address}</td>
    </tr>
</s:iterator>
    </table>

</body>
</html>
