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
<s:set var="numResults" value="0"/>
<s:set var="avalue"><%= request.getParameter("search") %></s:set>
<s:iterator value="hotels" var="h">
    <s:set var="hName">${h.name}</s:set>
    <s:if test="%{(#hName.toLowerCase().indexOf(#avalue.toLowerCase()) != -1) || (#avalue=='null')}">
        <s:set var="numResults" value="%{#numResults+1}"/>
    </s:if>
</s:iterator>
<s:iterator value="restaurants" var="r">
    <s:set var="rName">${r.name}</s:set>
    <s:if test="%{(#rName.toLowerCase().indexOf(#avalue.toLowerCase()) != -1) || (#avalue=='null')}">
        <s:set var="numResults" value="%{#numResults+1}"/>
    </s:if>
</s:iterator>
<s:iterator value="experiences" var="e">
    <s:set var="eName">${e.name}</s:set>
    <s:if test="%{(#eName.toLowerCase().indexOf(#avalue.toLowerCase()) != -1) || (#avalue=='null')}">
        <s:set var="numResults" value="%{#numResults+1}"/>
    </s:if>
</s:iterator>

<main>
    <header id="header-container">
        <div class="header">
            <div class="homepage-menu">
                <p class="fa" style="cursor: pointer;">&#xf0c9;</p>
            </div>
            <div class="homepage-logo">
                <h1><a href="/home">NewcastleConnections</a></h1>
            </div>
            <div class="homepage-social">
                <img src="../../img/social-icons.svg" />
            </div>
            <s:if test="%{#session.userNickname == null}">
                <div class="homepage-login">
                    <form action="/login">
                        <button type="submit">Login</button>
                    </form>
                </div>
            </s:if>
            <s:else>
                <div class="homepage-login">
                    <form action="/customerPortal">
                        <button type="submit">Your Account</button>
                    </form>
                </div>
                <div class="homepage-login">
                    <form action="/logout">
                        <button type="submit">Logout</button>
                    </form>
                </div>
            </s:else>
            <div class="homepage-help">
                <a href="#">Help</a>
            </div>
        </div>
    </header>
    <div id="selector">
        <div class="userOptions" style="text-align: center">
            <div class="left">
                <h3>Itinerary</h3>
                <div class="benefit-blurb">View what you have planned</div>
            </div>
            <div class="middle">
                <form action="/customerPortal-bookings">
                    <button type="submit"><h3>Bookings and Payments</h3></button>
                </form>
                <div class="benefit-blurb">View your past bookings and manage payment options</div>
            </div>
            <div class="right">
                <h3>Manage Account</h3>
                <div class="benefit-blurb">Change your account details</div>
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
