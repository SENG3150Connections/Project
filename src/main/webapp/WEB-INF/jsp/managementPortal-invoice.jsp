<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Invoice</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/managementPortal.css" rel="stylesheet">

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
        <div class="create-offer">
            <div class="title">
                <label class="prev-dir">Manage Products/</label><label class="current-dir">Invoice</label>

                <div class="pull-right">
                    <button class="btn btn-info">Print Invoice</button>
                </div>
            </div>
            <div class="row">
                <!-- Main container -->
                <div class="col-md-8">
                    <div class="management-container">
                        <div class="row" style="width:100%">
                            <div class="col-md-2"><label>Status</label></div>
                            <div class="col-md-1"><label>Order</label></div>
                            <div class="col-md-4"><label>User ID</label></div>
                            <div class="col-md-3"><label>Date</label></div>
                            <div class="col-md-1"><label>Total</label></div>
                            <div class="col-md-1"><label>Actions</label></div>
                        </div>

                        <hr>


                        <s:iterator value="invoices" var="invoice">
                            <div class="row" style="width:100%; height: 45px;">
                                <div class="col-md-2">
                                    <label>
                                        <s:if test="%{#invoice.status==1}">
                                            Processing
                                        </s:if>
                                        <s:elseif test="%{#invoice.status==2}">
                                            Complete
                                        </s:elseif>
                                        <s:elseif test="%{#invoice.status==3}">
                                            Canceled
                                        </s:elseif>
                                    </label>
                                </div>
                                <div class="col-md-1"><label>${invoice.id}</label></div>
                                <div class="col-md-4"><label>${invoice.customerid}</label></div>
                                <div class="col-md-3"><label>${invoice.purchasedate}</label></div>
                                <div class="col-md-1"><label>$${invoice.price}</label></div>
                                <div class="col-md-1"><a href="#">View</a></div>
                            </div>
                        </s:iterator>

                    </div>
                </div>

                <!-- Sidebar - Right -->
                <div class="col-md-4">
                    <div class="management-sidebar">
                        <label class="heading">Sorting</label>
                        <label></label>
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

