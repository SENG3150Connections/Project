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
                <h1><a href="#">NewcastleConnections</a></h1>
            </div>
            <div class="homepage-social">
                <img src="../../img/social-icons.svg" />
            </div>
            <div class="homepage-login">
                <a href="/login">Login</a>
            </div>
            <div class="homepage-help">
                <a href="#">Help</a>
            </div>
        </div>
    </header>
    <div id="selector">
        <form class="flexform results-form">
            <input type="search" class="fa" name="search" placeholder="&#xf002; Search..">
            <input type="text" class="fa" name="start" id="start" placeholder="&#xf073; Arrive">
            <input type="text" class="fa" name="finish" id="end" placeholder="&#xf073; Leave">
            <input type="text" class="fa" name="people" placeholder="&#xf0c0; 3 guests, pets">
            <input type="submit" class="btn" name="submit" placeholder="Submit">
            <span>Accommodation: <input type="checkbox" value="Accommodation"></span>
            <span>Events: <input type="checkbox" value="Events"></span>
            <span>Restaurants: <input type="checkbox" value="Restaurants"></span>
            <span>Transport: <input type="checkbox" value="Transport"></span>
            <input type="submit" value="More Filters" style="background-color: #FFFFFF;color: #005da9">
            <p>Clear Filters x <br/>Results</p>
        </form>
    </div>
    <div id="results-container">
        <div id="results">
            <s:iterator value="hotels" var="hotel">
                <div class="offer-tile">
                    <div class="img-tile">
                        <div class="img-tile-item-initial">
                            <img src='../../img/tile-img.jpg' class="cover"/>
                        </div>
                        <div class="img-tile-item">
                            <img src='../../img/tile-img-2.jpg' class="cover"/>
                            <img src='../../img/tile-img-3.jpg' class="cover"/>
                        </div>
                    </div>
                    <div class="offer-info">
                        <div class="offer-info-left">
                            <span class="name">${hotel.name}</span>
                            <span class="blurb">${hotel.address}</span>
                        </div>
                        <div class="offer-info-right">
                            <span class="price">$100</span>
                            <span class="fa icons">&#xf0f5;</span>
                            <span class="fa offer-heart">&#xf08a;</span>
                        </div>
                    </div>
                </div>
            </s:iterator>
            <h1>HOTELS</h1>
            <table>
             <s:iterator value="hotels" var="hotel">
                <tr>
                    <td>${hotel.id}</td>
                    <td>${hotel.name}</td>
                    <td>${hotel.address}</td>
                </tr>
            </s:iterator>
            </table>
        </div>
        <div id="package-info">package information</div>
    </div>
</main>

<script>window.jQuery || document.write('<script src="../../js/vendor/jquery-1.12.0.min.js"><\/script>')</script>
<script src="../../js/pikaday.js"></script>
<script src="../../js/plugins.js"></script>
<script src="js/main.js"></script>

</body>
</html>
