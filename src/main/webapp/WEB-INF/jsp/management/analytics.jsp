<%--
analytics.jsp
Author: Harry Barden

Description:
    This JSP displays the current analytics page.

    The sidebar is dynamically loaded in via jsp:include at the start of the body tag.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Analytics</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../css/managementPortal.css" rel="stylesheet">

    <!-- CSS -->
    <link href="css/sidebar-nav.css" rel="stylesheet">
    <link href="css/normalize.css" rel="stylesheet">

    <!-- JS -->
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="js/management-loadContent.js"></script>

    <!-- FONTS -->
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<!-- Sidebar -->
<div id="sidebar" class="sidebar">
    <jsp:include page="management-sidebar-nav.jsp" />
</div>

<!-- Main Body -->
<div class="management-mainbody">
    <div class="menuContent">
        <div class="analytics">
            <div class="title">
                <label class="prev-dir">Manage Products/</label><label class="current-dir">Analytics</label>

                <div class="pull-right">
                    <a class="btn btn-info">Export CSV</a>
                </div>
            </div>
            <div class="row">
                <!-- Main container -->
                <div class="col-md-12">
                    <div class="management-container" style="height:90%;">
                        <label class="heading">Report</label>

                        <div class="row">
                            <img style="padding-left:8px" src="../../../img/analytics.png" />
                        </div>
                    </div>
                </div>
                </form>

            </div>
        </div>
    </div>
</div>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>

