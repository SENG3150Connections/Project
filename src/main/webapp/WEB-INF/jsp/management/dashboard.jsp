<%--
dashboard.jsp
Author: Harry Barden

Description:
    This is the main page for the management portal.
    This page displays a breakdown summary for the last week of sales.

    The sidebar is dynamically loaded in via jsp:include at the start of the body tag.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
    <jsp:include page="static-head.jsp"/>
    <title>Management - Dashboard</title>
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
                <label class="prev-dir">Manage Products/</label><label class="current-dir">Last Week Summary</label>

                <div class="pull-right">
                    <a class="btn btn-info">Export CSV</a>
                </div>
            </div>
            <div class="row">
                <!-- Main container -->
                <div class="col-md-12">
                    <div class="management-container" style="height:90%;">
                        <label class="heading">Weekly Report</label>
                        <% String[] colours = new String[]{"#FF3100", "#FFA200", "#00E35C", "#0055DD", "#a16bd6", "#41a1a9"}; %>

                        <div class="row">
                            <div class="col-md-2">
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: <%=colours[0]%>;">
                                    <label class="heading">$${grossSalesTotal}</label><br>
                                    <label class="subHeading">Gross Sales in this period</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: <%=colours[1]%>;">
                                    <label class="heading">$${netSalesTotal}</label><br>
                                    <label class="subHeading">Net Sales in this period</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: <%=colours[2]%>;">
                                    <label class="heading">${ordersPlacedTotal}</label><br>
                                    <label class="subHeading">Orders placed</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: <%=colours[3]%>;">
                                    <label class="heading">${itemsPurchasedTotal}</label><br>
                                    <label class="subHeading">Items Purchased</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: <%=colours[4]%>;">
                                    <label class="heading">$${refundedTotal}</label><br>
                                    <label class="subHeading">Refunded 0 orders (0 items)</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: <%=colours[5]%>;">
                                    <label class="heading">$${couponSalesTotal}</label><br>
                                    <label class="subHeading">Worth of coupons used</label>
                                </div>
                            </div>

                            <div class="col-md-9">
                                <svg style="width:100%; height: 500px;">
                                    <% for(int i = 5; i <= 95; i+=15) { %>
                                        <text x="2.5%" y="<%=95-i%>%" fill="#aaa"><%=i%></text>
                                        <line x1="5%" y1="<%=i%>%" x2="95%" y2="<%=i%>%" style="stroke:#aaa;stroke-width:2" />
                                    <% } %>

                                    <!-- Graph Data -->>
                                    <% for(int i = 0; i < 7; i++) { %>
                                        <% double percentage = 95.0; %>


                                        <% for(int j = 0; j < 6; j++) { %>
                                            <% float value = ( java.lang.Math.round(java.lang.Math.random() * percentage) ) % 30; %>
                                            <rect x="<%=7.5 + (13 + 1/3) * i%>%" y="<%= percentage - value %>%" width="5%" height="<%= value %>%" style="fill:<%=colours[j]%>;fill-opacity:1;"/>
                                            <% percentage -= value; %>
                                        <% } %>
                                    <% } %>

                                    <line x1="10%" y1="95%" x2="88%" y2="95%" style="stroke:#555;stroke-width:4" />
                                    <% for(int i = 0; i < 7; i++) { %>
                                        <circle cx="<%=10 + (13 + 1/3) * i%>%" cy="95%" r="10" fill="#555" />
                                        <text x="<%=9 + (13 + 1/3) * i%>%" y="100%" fill="#aaa"><%=(28 + i)%31 + (int)(Math.floor((28 + i)/31))%>/0<%=8 + (int)(Math.floor((28 + i)/31))%></text>
                                    <% } %>
                                </svg>
                            </div>
                        </div>
                    </div>
                </div>

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
