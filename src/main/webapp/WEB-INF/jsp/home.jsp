<%--
home.jsp
Author: Tim Pitts

Description:
    The homepage landing for the entire website.
    It includes the menu bar up top, search bar, as well as various other piece of
    data below, such as business login.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html class="no-js" lang="">
<head>

    <jsp:include page="helpers/tracking.jsp"/>
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
    <link rel="stylesheet" href="../../css/home.css">
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
    <div id="homepage-container">
        <div id="menu">
            <div class="menu-close menu-toggle hidden">
                <span class="fa fa-3x fa-times pointer"></span>
                <a href="/login">Login</a>
            </div>
            <div class="menu-social hidden">
                <a href="https://www.facebook.com/newcastleconnections/"><img src="../../img/fb-social.png" class="pointer hover"/></a>
                <a href="#"><img src="../../img/tw-social.png" class="pointer hover"/></a>
                <a href="https://www.instagram.com/newcastleconnections/"><img src="../../img/ig-social.png" class="pointer hover"/></a>
            </div>
        </div>
        <div id="homepage-image">
            <div class="bg-cover"></div>
            <div class="cover-overlay"></div>
        </div>
        <header id="header-container" class="grad">
            <div class="header">
                <div class="homepage-menu menu-toggle">
                    <p class="fa pointer">&#xf0c9;</p>
                </div>
                <div class="homepage-logo">
                    <h1><a href="#">NewcastleConnections</a></h1>
                </div>
                <div class="homepage-social ">
                    <a href="https://www.facebook.com/newcastleconnections/"><img src="../../img/fb-social.png" class="pointer hover"/></a>
                    <a href="#"><img src="../../img/tw-social.png" class="pointer hover"/></a>
                    <a href="https://www.instagram.com/newcastleconnections/"><img src="../../img/ig-social.png" class="pointer hover"/></a>
                </div>
                <s:if test="%{#session.userNickname == null}">
                    <div class="homepage-login">
                        <a href="/login">Login</a>
                    </div>
                </s:if>
                <s:else>
                    <div class="homepage-login">
                        <a href="/customerPortal">Your Account</a>
                    </div>
                    <div class="homepage-login">
                        <a href="/logout">Logout</a>
                    </div>
                </s:else>
                <div class="homepage-help">
                    <a href="#help">Help</a>
                </div>
            </div>
        </header>
        <div class="container">
            <h1 class="text-center homepage-maintext">Discover Newcastle</h1>
        </div>
        <div class="container">
            <form class="flexform search-form" action="/results">
                <input type="search" class="fa" name="search" placeholder="&#xf002; Search..">
                <input type="text" class="fa" name="start" id="start" placeholder="&#xf073; Arrive">
                <input type="text" class="fa" name="finish" id="end" placeholder="&#xf073; Leave">
                <input type="text" class="fa" name="people" placeholder="&#xf0c0; 3 guests, pets">
                <input type="submit" class="btn" name="submit" value="Submit" placeholder="Submit">
            </form>
        </div>
        <div class="container">
            <div class="benefits">
                <div>
                    <h3>Your perfect holiday starts here</h3>
                    <div class="benefit-blurb">Create your dream holiday from Newcastle's best selection</div>
                </div>
                <div>
                    <h3>Book and stay with confidence</h3>
                    <div class="benefit-blurb">Secure payments, peace of mind</div>
                </div>
                <div>
                    <h3>Your holiday your way</h3>
                    <div class="benefit-blurb">More events, more locations, no compromises</div>
                </div>
            </div>
        </div>
    </div>

    <div id="slider">
        <div id="options" class="pointer">
            <div class="slider-item">
                <img src='../../img/events.png' class="cover"/>
                <p>Events</p>
            </div>
            <div class="slider-item">
                <img src='../../img/restaurant.jpg' class="cover"/>
                <p>Restaurants</p>
            </div>
            <div class="slider-item">
                <img src='../../img/hotels.png' class="cover"/>
                <p>Hotels</p>
            </div>
            <div class="slider-item last-item">
                <img src='../../img/transport.jpg' class="cover"/>
                <p>Transport</p>
            </div>
        </div>
    </div>
    <div id="help" class="container" style="margin: 25px;padding: 25px;color: #555555;flex-direction: column;justify-content: center;align-items: center">
        <h2 class="text-center" style="margin: 15px 15px">
            How to organise the perfect holiday
        </h2>
        <div class="threebox">
            <div class="threebox-item">
                <p class="fa fa-5x fa-search"></p>
                <h2>Explore</h2>
                <p>Enter your travel dates or destination to search<br />
                    thousands of popular Newcastle destinations. We<br />
                    recommend looking at a wide range of compatible<br />
                    options to create your perfect experience.
                </p>
            </div>
            <div class="threebox-item">
                <p class="fa fa-5x fa-handshake-o"></p>
                <h2>Create</h2>
                <p>After you've found the perfect activities, combine<br />
                    them with your selected accommodation, transport,<br />
                    and favourite places to eat to create your custom<br />
                    package. Your holiday your way with massive savings!
                </p>
            </div>
            <div class="threebox-item last-item">
                <p class="fa fa-5x fa-suitcase"></p>
                <h2>Confirm</h2>
                <p>You're all set! Confirmations will be sent to the<br />
                    places you selected all at once. All you have to<br />
                    do now is get ready, check in, and enjoy a truly<br />
                    unforgettable getaway.
                </p>
            </div>
        </div>
    </div>
    <div class="container" style="height: 650px;overflow: hidden; background-color: #000">
        <img src="../../img/large.jpg" class="opacity-5"/>
        <div class="text-overlay">
            <h2>Own a business? Get involved and open your door to travellers from around the globe.</h2>
            <a href="/managementPortal">List Your Business</a>
        </div>
    </div>
    <div class="container" style="margin: 25px;padding: 25px;color: #555555;flex-direction: column;justify-content: center;align-items: center">
        <h2 class="text-center" style="margin: 15px 15px">
            Most Popular Upcoming Events
        </h2>
        <div class="threebox">
            <div class="threebox-item pointer hover-shadow" style="background-color: #000000">
                <img src='../../img/bitter-and-twisted.jpg' class="cover opacity-5"/>
                <a href="http://www.visitnsw.com/destinations/hunter/hunter-valley/maitland/events/bitter-and-twisted-boutique-beer-festival">
                    <div class="text-overlay">
                        <h2>Bitter & Twisted</h2>
                    </div>
                </a>
            </div>
            <div class="threebox-item pointer hover-shadow" style="background-color: #000000">
                <img src='../../img/newcastle-supermoto.jpg' class="cover opacity-5"/>
                <a href="http://www.visitnsw.com/destinations/north-coast/newcastle-area/newcastle/events/watson-demolition-newcastle-city-supermoto">
                    <div class="text-overlay">
                        <h2>Newcastle SuperMoto</h2>
                    </div>
                </a>
            </div>
            <div class="threebox-item last-item pointer hover-shadow" style="background-color: #000000">
                <img src='../../img/Newcastlemuseum.jpg' class="cover opacity-5"/>
                <a href="https://www.visitnewcastle.com.au/newcastle-museum">
                    <div class="text-overlay">
                        <h2>Newcastle Museum</h2>
                    </div>
                </a>
            </div>
        </div>
    </div>

    <footer id="footer-container">
        <div class="container" style="height: 250px; flex-direction: column;justify-content: center;align-items: center">
            <div>
                <div class="homepage-social ">
                    <a href="https://www.facebook.com/newcastleconnections/"><img src="../../img/fb-social.png" class="pointer hover"/></a>
                    <a href="#"><img src="../../img/tw-social.png" class="pointer hover"/></a>
                    <a href="https://www.instagram.com/newcastleconnections/"><img src="../../img/ig-social.png" class="pointer hover"/></a>
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

</main>

<script>window.jQuery || document.write('<script src="../../js/vendor/jquery-1.12.0.min.js"><\/script>')</script>
<script src="../../js/pikaday.js"></script>
<script src="../../js/plugins.js"></script>
<script src="js/main.js"></script>
<script>
    $(".menu-toggle").click(function() {
        $('#menu').animate({width: ($('#menu').width() === 0) ? 300 : 0});
        $('#menu>div').toggleClass('hidden');
        $('main').toggleClass('noScrolling');
    });
</script>

</body>
</html>
