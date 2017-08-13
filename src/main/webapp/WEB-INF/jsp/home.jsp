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
        <div id="homepage-image">
            <div class="bg-cover"></div>
            <div class="cover-overlay"></div>
        </div>
        <header id="header-container" class="grad">
            <div class="header">
                <div class="homepage-menu">
                    <p class="fa" style="cursor: pointer">&#xf0c9;</p>
                </div>
                <div class="homepage-logo">
                    <h1><a href="#">NewcastleConnections</a></h1>
                </div>
                <div class="homepage-social">
                    <img src="../../img/social-icons.svg" />
                </div>
                <div class="homepage-login">
                    <form action="/login">
                        <button type="submit">Login</button>
                    </form>
                </div>
                <div class="homepage-help">
                    <a href="#">Help</a>
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
                <input type="submit" class="btn" name="submit" placeholder="Submit">
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
        <div id="options">
            <div class="slider-item">
                <img src='../../img/one.svg'/>
            </div>
            <div class="slider-item">
                <img src='../../img/two.svg'/>
            </div>
            <div class="slider-item">
                <img src='../../img/three.svg'/>
            </div>
            <div class="slider-item last-item">
                <img src='../../img/four.svg'/>
            </div>
        </div>
    </div>
    <div class="container" style="margin: 25px;padding: 25px;color: #555555;flex-direction: column;justify-content: center;align-items: center">
        <h2 class="text-center" style="margin: 15px 15px">
            How to organise the perfect holiday
        </h2>
        <div class="threebox">
            <div class="threebox-item">
                <img src='../../img/one.svg'/>
            </div>
            <div class="threebox-item">
                <img src='../../img/two.svg'/>
            </div>
            <div class="threebox-item last-item">
                <img src='../../img/three.svg'/>
            </div>
        </div>
    </div>
    <div class="container" style="height: 650px;overflow: hidden">
        <img src="../../img/large.jpg" style="overflow:hidden"/></h2>
    </div>
    <div class="container" style="margin: 25px;padding: 25px;color: #555555;flex-direction: column;justify-content: center;align-items: center">
        <h2 class="text-center" style="margin: 15px 15px">
            Most Popular Upcoming Events
        </h2>
        <div class="threebox">
            <div class="threebox-item">
                <img src='../../img/one.svg'/>
            </div>
            <div class="threebox-item">
                <img src='../../img/two.svg'/>
            </div>
            <div class="threebox-item last-item">
                <img src='../../img/three.svg'/>
            </div>
        </div>
    </div>

    <footer id="footer-container">
        <div class="container" style="height: 250px; flex-direction: column;justify-content: center;align-items: center">
            <img src="../../img/social-icons.svg" />
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

</body>
</html>