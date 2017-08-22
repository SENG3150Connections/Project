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
    <link rel="stylesheet" href="../../css/results.css">
    <link rel="stylesheet" href="../../css/pikaday.css">
    <link rel="stylesheet" href="../../css/customerPortal.css">


    <script src="../../js/vendor/modernizr-2.8.3.min.js"></script>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<main>
    <header id="header-container">
        <div class="header">
            <div id="homepage-image" style="height: 96px; color: white">
                <div class="bg-cover"></div>
                <div class="cover-overlay"></div>
            </div>
            <div class="homepage-logo" style="margin-left: 0;">
                <h1><a style="color: white;" href="/home">NewcastleConnections</a></h1>
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
    <div class="customerPageBody">
        <div class="customerOptions">
            <div class="contentBox">
                <span class="customerPageHeading">Menu</span>
                <span href="/customerPortal-bookings" class="customerPageMenu">Invoices</span>
                <span class="customerPageMenu">Itinerary</span>
                <span class="customerPageMenu">Manage Account</span>
            </div>
        </div>
        <div class="customerPageContent">
            <div class="contentBox">
                <span class="customerPageHeading">Invoices</span>
                <div class="customerInvoice">
                    <span class="invoiceHeading">Invoice Number</span>
                    <span class="invoiceHeading">Purchase Date</span>
                    <span class="invoiceHeading">Price</span>
                    <span class="invoiceHeading">Status</span>
                    <span class="invoiceHeading">Action</span>
                </div>
                <div class="customerInvoice">
                    <span class="invoiceContent">1</span>
                    <span class="invoiceContent">01/01/2001</span>
                    <span class="invoiceContent">$1.00</span>
                    <span class="invoiceContent">Complete</span>
                    <form action="/customerPortal-bookings" method="post">
                        <s:hidden name="invoiceID" value="1"/>
                        <input type="submit" class="invoiceSubmit" value="View Booking"/>
                    </form>
                </div>
                <div class="customerInvoice">
                    <span class="invoiceContent">00002</span>
                    <span class="invoiceContent">02/02/2002</span>
                    <span class="invoiceContent">$2.00</span>
                    <span class="invoiceContent">Complete</span>
                    <form action="/customerPortal-bookings" method="post">
                        <s:hidden name="invoiceID" value="00002"/>
                        <input type="submit" class="invoiceSubmit" value="View Booking"/>
                    </form>
                </div>
                <s:iterator value="invoices" var="invoice">
                    <div class="customerInvoice">
                        <span class="invoiceContent">${invoice.id}</span>
                        <span class="invoiceContent">${invoice.purchasedate}</span>
                        <span class="invoiceContent">${invoice.price}</span>
                        <span class="invoiceContent">${invoice.status}</span>
                        <form action="/customerPortal-bookings" method="post">
                            <s:hidden name="invoiceID" value="%{invoice.id}"/>
                            <input type="submit" class="invoiceSubmit" value="View Booking"/>
                        </form>
                    </div>
                </s:iterator>
            </div>
        </div>
    </div>

</main>

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
