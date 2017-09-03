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
    <jsp:include page="static-head.jsp"/>
    <title>Management - Analytics</title>
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
