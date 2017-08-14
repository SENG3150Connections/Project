
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html class="no-js" lang="">
<head>

    <jsp:include page="helpers/tracking.jsp"/>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Newcastle Connections</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link href="//fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="../../font-awesome-4.7.0/css/font-awesome.min.css">
    <!-- Place favicon.ico in the root directory -->

    <link rel="stylesheet" href="../../css/normalize.css">
    <link rel="stylesheet" href="../../css/main.css">
    <script src="../../js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body>
<!--[if lt IE 8]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->

<!-- Add your site or application content here -->
<div id="container-homepage">
    <div id="jumbotron">
        <div id="homepage-image">
            <div class="bg-cover"></div>
            <div class="cover-overlay"></div>
        </div>
        <header id="homepage-header" class="grad">
            <h1 id="header-logo">NovoConnections</h1>
            <div id="nav">
                <ul>
                    <li>
                        <form action="/login">
                            <button type="submit">Login</button>
                        </form>
                    </li>
                    <li>
                        <a href="#">Help</a>
                    </li>
                </ul>
            </div>
        </header>
        <h1 class="text-center homepage-maintext">Discover Newcastle</h1>
        <div id="searchbox">
            <form>
                <input type="search" name="search" placeholder="Search..">
                <input type="date" name="start" placeholder="start">
                <input type="date" name="finish" placeholder="finish">
                <input type="text" name="people" placeholder="people">
                <input type="submit" class="btn" name="search" placeholder="Search">
            </form>
        </div>
        <div class="container">
            <div class="benefits text-center">
                <div class="left">
                    <h3>Your perfect holiday starts here</h3>
                    <div class="benefit-blurb">Choose a dream property from the world's best selection</div>
                </div>
                <div class="middle">
                    <h3>Book and stay with confidence</h3>
                    <div class="benefit-blurb">Secure payments, peace of mind</div>
                </div>
                <div class="right">
                    <h3>Your holiday your way</h3>
                    <div class="benefit-blurb">More space, more privacy, no compromises</div>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="slider">
    <div id="options">
        <div class="slider-1"></div>
        <div class="slider-2"></div>
        <div class="slider-3"></div>
        <div class="slider-4"></div>
    </div>
</div>
<div class="container">
    <h2 class="text-center">
        How to organise the perfect holiday
    </h2>
</div>
<div class="container">
    <h2 class="text-center">
        Most Popular Upcoming Events
    </h2>
</div>

<footer id="homeaway-footer">
    <section class="footer-section footer-legal">
        <div class="container">
            <div class="row">
                <div class="col-md-7 col-lg-8 col-sm-12">
                    <p id="terms-and-conditions">
                        Use of this Web site constitutes acceptance of the Newcastle Connections Terms and Conditions and Privacy Policy</a>.
                    </p>
                    <p id="copyright">
                        © Copyright 2011 – Newcastle Connections.
                    </p>
                </div>
            </div>
        </div>
    </section>
</footer>

<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script>window.jQuery || document.write('<script src="../../js/vendor/jquery-1.12.0.min.js"><\/script>')</script>
<script src="../../js/plugins.js"></script>
<script src="js/main.js"></script>

</body>
</html>
