<%--
create-offer.jsp
Author: Harry Barden

Description:
    This JSP displays the creation page for any new package.
    It loads in the creation page for experience, hotel, or restaurant depending on what parameter is supplied.

    The sidebar is dynamically loaded in via jsp:include at the start of the body tag.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
    <jsp:include page="static-head.jsp"/>
    <title>Management - Create Offer</title>
</head>
<body>
<!-- Sidebar -->
<div id="sidebar" class="sidebar">
    <jsp:include page="management-sidebar-nav.jsp" />
</div>

<!-- Main Body -->
<div class="management-mainbody">
    <div class="menuContent">
        <s:if test="%{offerType==''}">
            <jsp:include page="create-offer-selection.jsp" />
        </s:if>
        <s:elseif test="%{offerType=='hotel'}">
            <jsp:include page="create-hotel.jsp" />
        </s:elseif>
        <s:elseif test="%{offerType=='experience'}">
            <jsp:include page="create-experience.jsp" />
        </s:elseif>
        <s:elseif test="%{offerType=='restaurant'}">
            <jsp:include page="create-restaurant.jsp" />
        </s:elseif>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
