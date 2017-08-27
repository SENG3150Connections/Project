<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Management Portal</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/managementPortal.css" rel="stylesheet">

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

                        <div class="row">
                            <div class="col-md-2">
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: #c00;">
                                    <label class="heading">$${grossSalesTotal}</label><br>
                                    <label class="subHeading">Gross Sales in this period</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: #cc0;">
                                    <label class="heading">$${netSalesTotal}</label><br>
                                    <label class="subHeading">Net Sales in this period</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: #fc0;">
                                    <label class="heading">${ordersPlacedTotal}</label><br>
                                    <label class="subHeading">Orders placed</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: #fcc;">
                                    <label class="heading">${itemsPurchasedTotal}</label><br>
                                    <label class="subHeading">Items Purchased</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: #f0c;">
                                    <label class="heading">$${refundedTotal}</label><br>
                                    <label class="subHeading">Refunded 0 orders (0 items)</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: #c0f;">
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
                                        <% String[] colours = new String[]{"#c00", "#cc0", "#fc0", "#fcc", "#f0c", "#c0c"}; %>
                                        <% double percentage = 95.0; %>


                                        <% for(int j = 0; j < 6; j++) { %>
                                            <% float value = ( java.lang.Math.round(java.lang.Math.random() * percentage) ) % 30; %>
                                            <rect x="<%=7.5 + (13 + 1/3) * i%>%" y="<%= percentage - value %>%" width="5%" height="<%= value %>%" style="fill:<%=colours[j]%>;fill-opacity:0.6;"/>
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

