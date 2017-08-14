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
Authentication required to view this page


Welcome: <s:property value="#session.userNickname"></s:property>

</body>
</html>
