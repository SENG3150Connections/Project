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


<s:set var="netProffit" value="0.0"/>
<s:iterator value="invoices" var="invoice">
    netProffit += ${invoice.price}
</s:iterator>

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
                            <div class="col-md-2">
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: #c00;">
                                    <label class="heading">$<s:property value="#netProffit"/></label><br>
                                    <label class="subHeading">Gross Sales in this period</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: #cc0;">
                                    <label class="heading">$0.00</label><br>
                                    <label class="subHeading">Net Sales in this period</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: #0c0;">
                                    <label class="heading">1</label><br>
                                    <label class="subHeading">Orders placed</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: #0cc;">
                                    <label class="heading">4</label><br>
                                    <label class="subHeading">Items Purchased</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: #00c;">
                                    <label class="heading">$0.00</label><br>
                                    <label class="subHeading">Refunded 0 orders (0 items)</label>
                                </div>
                                <div class="col-md-12 analyticsGraphDetails" style="border-right-color: #c0c;">
                                    <label class="heading">$0.00</label><br>
                                    <label class="subHeading">Worth of coupons used</label>
                                </div>
                            </div>

                            <div class="col-md-9">
                                <svg style="width:100%; height: 500px;">
                                    <% for(int i = 5; i <= 95; i+=15) { %>
                                        <text x="2.5%" y="<%=95-i%>%" fill="#aaa"><%=i%></text>
                                        <line x1="5%" y1="<%=i%>%" x2="95%" y2="<%=i%>%" style="stroke:#aaa;stroke-width:2" />
                                    <% } %>

                                    <!-- Graph Data -->
                                    <rect x="7.5%" y="20%" width="5%" height="60%" style="fill:#0cc;fill-opacity:0.6;"/>
                                    <rect x="7.5%" y="80%" width="5%" height="15%" style="fill:#0c0;fill-opacity:0.6;"/>


                                    <line x1="10%" y1="95%" x2="90%" y2="95%" style="stroke:#555;stroke-width:4" />
                                    <% for(int i = 10; i <= 90; i+=10) { %>
                                        <circle cx="<%=i%>%" cy="95%" r="10" fill="#555" />
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

