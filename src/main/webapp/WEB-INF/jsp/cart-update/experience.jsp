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
    <br/>VoucherID:<br/>
    <input type="number" name="voucherId" value="${experience.voucher.id}">

    <input type="submit" value="Submit">
</form>

</body>
</html>
