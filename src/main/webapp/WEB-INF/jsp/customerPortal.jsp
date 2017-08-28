<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html class="no-js" lang="">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Discover Newcastle</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link href="//fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="../../font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../css/normalize.css">
    <link rel="stylesheet" href="../../css/main.css">
    <link rel="stylesheet" href="../../css/home.css">
    <link rel="stylesheet" href="../../css/pikaday.css">
    <link rel="stylesheet" href="../../css/customerPortal.css">


    <script src="../../js/vendor/modernizr-2.8.3.min.js"></script>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body class="customerPortalBody">
<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<div id="wrapper">
<main>
    <header id="header-container">
        <div class="header">
            <div id="homepage-image" style="height: 96px; color: white;">
                <div class="bg-cover"></div>
                <div class="cover-overlay"></div>
            </div>
            <div class="homepage-logo" style="margin-left: 0;">
                <h1><a style="color: white; font-size: 32px" href="/home">NewcastleConnections</a></h1>
            </div>
            <div class="homepage-social">
                <a href="#"><img src="../../img/fb-social.png" class="pointer hover"/></a>
                <a href="#"><img src="../../img/tw-social.png" class="pointer hover"/></a>
                <a href="#"><img src="../../img/ig-social.png" class="pointer hover"/></a>
            </div>
            <s:if test="%{#session.userNickname == null}">
                <div class="homepage-login">
                    <a style="color: white;" href="/login">Login</a>
                </div>
            </s:if>
            <s:else>
                <div class="homepage-login">
                    <a style="color: white;" href="/customerPortal">Your Account</a>
                </div>
                <div class="homepage-login">
                    <a style="color: white;" href="/logout">Logout</a>
                </div>
            </s:else>
            <div class="homepage-help">
                <a style="color: white;" href="#">Help</a>
            </div>
        </div>
    </header>
    <p class="customerTopMenu">
        <span href="/home">Home</span> / <span href="/customerPortal">My Account</span> / <span>Invoices</span>
    </p>
    <div class="customerPageBody">
        <div class="customerOptions">
            <div class="contentBox">
                <span class="customerPageMenuHeading ">Menu</span>
                <span href="/customerPortal-bookings" class="customerPageMenu${pageContext.request.requestURI eq '/WEB-INF/jsp/customerPortal.jsp' ? ' active' : ''}">Invoices</span>
                <span class="customerPageMenu">Itinerary</span>
                <span class="customerPageMenu">Manage Account</span>
            </div>
        </div>
        <div class="customerPageContent">
            <div class="contentBox">
                <span class="customerPageHeading">Invoices</span>
                <p>Welcome to the Invoices page of your account. Your previous purchases are listed below. Select the "View Booking" button to get more info about a booking</p>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th class="invoiceHeading">Invoice Number</th>
                            <th class="invoiceHeading">Purchase Date</th>
                            <th class="invoiceHeading">Price</th>
                            <th class="invoiceHeading">Status</th>
                            <th class="invoiceHeading">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="invoices" var="invoice">
                        <tr>
                            <td class="invoiceContent">${invoice.id}</td>
                            <td class="invoiceContent">${invoice.purchasedate}</td>
                            <td class="invoiceContent">${invoice.price}</td>
                            <td class="invoiceContent">${invoice.status}</td>
                            <td class="invoiceContent">
                                <form action="/customerPortal-bookings" method="post">
                                    <input type="hidden" name="invoiceID" value="${invoice.id}"/>
                                    <input type="submit" class="invoiceSubmit btn btn-primary" value="View Booking"/>
                                </form>
                            </td>
                        </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </div>
        </div>
        <%--<div class="customerPageContent">--%>

        <%--</div>--%>
    </div>

</main>
</div>
<footer id="footer-container">
    <div class="container" style="height: 250px; flex-direction: column;justify-content: center;align-items: center">
        <div>
            <div class="homepage-social ">
                <a href="#"><img src="../../img/fb-social.png" class="pointer hover"/></a>
                <a href="#"><img src="../../img/tw-social.png" class="pointer hover"/></a>
                <a href="#"><img src="../../img/ig-social.png" class="pointer hover"/></a>
            </div>
        </div>
        <p id="terms-and-conditions">
            Use of this Web site constitutes acceptance of the Newcastle Connections Terms and Conditions and Privacy Policy</a>.
        </p>
        <p id="copyright">
            © Copyright 2017 – Newcastle Connections.
        </p>
    </div>
</footer>
<script>window.jQuery || document.write('<script src="../../js/vendor/jquery-1.12.0.min.js"><\/script>')</script>
<script src="../../js/pikaday.js"></script>
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>
<script>
    $("a.content-toggle").click(function() {
        $('#filters').animate({height: ($('#filters').height() == 0) ? $(window).height()-250 : 0}, 200);
        $('#filters>div').toggleClass('invisible');
        $( this ).toggleClass( "fa-chevron-right-after" );
        $( this ).toggleClass( "fa-chevron-down-after" );
    });
    $( ".offer-heart" ).click(function() {
        $( this ).toggleClass( "fa-heart" );
        $( this ).toggleClass( "fa-heart-o" );
        $( this ).toggleClass( "red" );
    });
</script>

</body>
</html>
