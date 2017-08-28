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
            <div id="homepage-image" style="height: 96px; color: white">
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
        <a class="customerPageNav" href="/home">Home</a> / <a class="customerPageNav" href="/customerPortal">My Account</a> / <a class="customerPageNav" href="/customerPortal">Invoices</a> / <a class="customerPageNav" href="/customerPortal">Booking</a>
    </p>
    <div class="customerPageBody">
        <div class="customerOptions">
            <div class="contentBox">
                <span class="customerPageHeading">Menu</span>
                <a href="/customerPortal" class="customerPageMenu${pageContext.request.requestURI eq '/WEB-INF/jsp/customerPortal-bookings.jsp' ? ' active' : ''}">Invoices</a>
                <a class="customerPageMenu">Itinerary</a>
                <a class="customerPageMenu">Manage Account</a>
            </div>
        </div>
        <div class="customerPageContent">
                <s:iterator value="invoice" var="invoice">
                <div class="contentBox">
                    <span class="customerPageHeading">#${invoice.id} Invoice Info</span>
                    <span class="invoiceList"><strong>Invoice Date: </strong>${invoice.purchasedate}</span>
                    <span class="invoiceList"><strong>Invoice Status: </strong>${invoice.status}</span>
                    <span class="invoiceList"><strong>Invoice Price: </strong>${invoice.price}</span>
                </div>
                </s:iterator>
                <s:if test="%{hotels.size>0}">
                <div class="contentBox">
                    <span class="customerPageHeading">Hotels</span>
                    <s:iterator value="hotels" var="hotel">
                    <span class="hotelName">${hotel.hotelName}</span>
                    <span class="hotelAddress">${hotel.hotelAddress}</span>
                    <span class="hotelContact">${hotel.hotelContact}</span>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="invoiceHeading">Room Number</th>
                                <th class="invoiceHeading">Room Type</th>
                                <th class="invoiceHeading">Price</th>
                                <th class="invoiceHeading">Check In</th>
                                <th class="invoiceHeading">Check Out</th>
                                <th class="invoiceHeading">Adults</th>
                                <th class="invoiceHeading">Children</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="hotelContent">${hotel.roomID}</td>
                                <td class="hotelContent">${hotel.roomType}</td>
                                <td class="hotelContent">${hotel.hotelPrice}</td>
                                <td class="hotelContent">${hotel.checkIn}</td>
                                <td class="hotelContent">${hotel.checkOut}</td>
                                <td class="hotelContent">${hotel.adults}</td>
                                <td class="hotelContent">${hotel.children}</td>
                            </tr>
                        </tbody>
                    </table>
                    </s:iterator>
                </div>
                </s:if>
                <s:if test="%{experiences.size>0}">
                <div class="contentBox">
                    <span class="customerPageHeading">Experiences</span>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th class="experienceHeading">Name</th>
                            <th class="experienceHeading">Location</th>
                            <th class="experienceHeading">Price</th>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="experiences" var="experience">
                            <tr>
                                <td class="experienceContent">${experience.name}</td>
                                <td class="experienceContent">${experience.location}</td>
                                <td class="experienceContent">${experience.price}</td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                </div>
                </s:if>
                <s:if test="%{restaurants.size>0}">
                <div class="contentBox">
                    <span class="customerPageHeading">Restaurants</span>
                    <s:iterator value="restaurants" var="restaurant">
                    <span class="hotelName">${restaurant.restaurantName}</span>
                    <span class="hotelAddress">${restaurant.restaurantAddress}</span>
                    <span class="hotelContact">${restaurant.restaurantContact}</span>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th class="restaurantHeading">Booking Time</th>
                            <th class="restaurantHeading">Seats Booked</th>
                            <th class="restaurantHeading">Voucher Price</th>
                        </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="restaurantContent">${restaurant.restaurantTime}</td>
                                <td class="restaurantContent">${restaurant.restaurantSeats}</td>
                                <td class="restaurantContent">${restaurant.restaurantPrice}</td>
                            </tr>
                        </tbody>
                    </table>
                    </s:iterator>
                </div>
                </s:if>
                <s:if test="%{transports.size>0}">
                <div class="contentBox">
                    <span class="customerPageHeading">Transport</span>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th class="transportHeading">Name</th>
                            <th class="transportHeading">Time</th>
                            <th class="transportHeading">Price</th>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="transports" var="transport">
                            <tr>
                                <td class="transportContent">${transport.transportName}</td>
                                <td class="transportContent">${transport.transportTime}</td>
                                <td class="transportContent">${transport.transportPrice}</td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                </div>
                </s:if>
        </div>
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
