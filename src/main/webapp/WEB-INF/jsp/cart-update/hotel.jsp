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

    <link rel="stylesheet" href="../../css/normalize.css">
    <link rel="stylesheet" href="../../css/main.css">
    <link rel="stylesheet" href="../../css/results.css">
    <link rel="stylesheet" href="../../css/pikaday.css">

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
            <div class="homepage-menu">
                <p class="fa" style="cursor: pointer;">&#xf0c9;</p>
            </div>
            <div class="homepage-logo">
                <h1><a href="/home">NewcastleConnections</a></h1>
            </div>
            <div class="homepage-social ">
                <a href="#"><img src="../../img/fb-social.png" class="pointer hover"/></a>
                <a href="#"><img src="../../img/tw-social.png" class="pointer hover"/></a>
                <a href="#"><img src="../../img/ig-social.png" class="pointer hover"/></a>
            </div>
            <div class="homepage-login">
                <a href="/login">Login</a>
            </div>
            <div class="homepage-help">
                <a href="#">Help</a>
            </div>
        </div>
    </header>
    <div id="selector" style="min-height:100px;">
        <form class="flexform results-form" action="/results">
            <input type="search" class="fa" name="search" placeholder="&#xf002; Search..">
            <input type="text" class="fa" name="start" id="start" placeholder="&#xf073; Arrive" />
            <input type="text" class="fa" name="finish" id="end" placeholder="&#xf073; Leave">
            <input type="text" class="fa" name="people" placeholder="&#xf0c0; 3 guests, pets">
            <input type="submit" class="btn" name="submit" placeholder="Submit">
        </form>
    </div>

    <div id="results-container">
        <div id="restults-content">

        </div>
        <div id="package-info">
            <div id="package-header">
                <h2>Tailor the offer to suit you</h2>
            </div>
            <div id="package-contents" class="center" style="overflow: hidden">
                <form action="update-hotel" class="flexform packageform">
                    <input type="hidden" name="cartIndex" value="${cartIndex}">

                    <br/>Room:<br/>
                    <select name="roomId">
                        <s:iterator value="offerings" var="o" status="entry">
                            <option value="${o.id}">${o.title} - ${o.noguestmax} People</option>
                        </s:iterator>
                    </select>

                    <br/>Adults:<br/>
                    <input type="number" name="adults" value="${hotel.adults}">
                    <br/>Children:<br/>
                    <input type="number" name="children" value="${hotel.children}">

                    <br/>CheckIn:<br/>
                    <input type="text" name="checkIn" value="${hotel.checkIn}">
                    <br/>CheckOut:<br/>
                    <input type="text" name="checkOut" value="${hotel.checkOut}">

                    <input type="submit" value="Submit">
                </form>
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
    $("#display-list").click(function() {
        $('#results').addClass('flex-col').removeClass('flex-row');
        $('.offer-tile').toggleClass('offer-list').toggleClass('offer-tile');
    });
    $("#display-tile").click(function() {
        $('#results').addClass('flex-row').removeClass('flex-col');
        $('.offer-list').toggleClass('offer-tile').toggleClass('offer-list');
    });
    $(".offer-list > .offer-info").on('click', function() {
        $('#results').addClass('hidden');
        $('#display-type').addClass('hidden');
        $('.offer-list').addClass('hidden');
        $('#offer-info-large').removeClass('hidden');
        $(this).find(".offer-info").find(".offer-info-left").find(".name").clone().appendTo('#offer-name');
        $(this).find(".offer-images").find(".offer-img-initial").find(".cover").clone().appendTo('#offer-image');
    });
    $(".offer-list > .offer-images").on('click', function() {
        $('#results').addClass('hidden');
        $('#display-type').addClass('hidden');
        $('.offer-list').addClass('hidden');
        $('#offer-info-large').removeClass('hidden');
        $(this).find(".offer-info").find(".offer-info-left").find(".name").clone().appendTo('#offer-name');
        $(this).find(".offer-images").find(".offer-img-initial").find(".cover").clone().appendTo('#offer-image');
    });
    $("#show-results").on('click', function() {
        $('#offer-info-large').addClass('hidden');
        $('#results').removeClass('hidden');
        $('#display-type').removeClass('hidden');
        $('.offer-list').removeClass('hidden');
    });
</script>

</body>
</html>

