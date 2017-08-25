<%--
  Created by IntelliJ IDEA.
  User: Scott
  Date: 24/08/2017
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="update-experience">

    <input type="hidden" name="cartIndex" value="${cartIndex}">

    <br/>Voucher:<br/>
    <select name="voucherId">
        <s:iterator value="offerings" var="o" status="entry">
        <option value="${o.id}">${o.guestcount} People - $${o.price}</option>
        </s:iterator>
    </select>

    <input type="submit" value="Submit">
</form>

</body>
</html>
