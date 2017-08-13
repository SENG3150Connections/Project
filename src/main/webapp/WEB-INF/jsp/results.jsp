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
    <style>
        html {
            overflow-y: hidden;
        }
        main {
            /*border: solid 1px #000000;*/
            display: flex;
            flex-direction: column;
        }
        #results-container {
            display: inline-flex;
            flex-direction: row;
            justify-content: center;
            min-height: 18vh;
            border: inherit;
        }
        header a {
            color: #005da9;
        }
        header {
            border: inherit;
            box-shadow: 1px 1px 1px #AFAFAF;
        }
        .results-form {
            width: 95%;
            min-width: 400px;
            flex-wrap: wrap;
        }
        #selector {
            border: inherit;
            min-height: 18vh;
            display: flex;
            justify-content: center;
            box-shadow: 2px 2px 3px #AFAFAF;
        }
        #results {
            margin-top: 2px;
            min-height: 80vh;
            flex-grow: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            border: inherit;
            overflow-y: scroll;
        }
        #package-info {
            min-width: 25%;
            max-height: 70vh;
            flex-grow: 0.5;
            border: inherit;
        }
        .offer-tile {
            display: flex;
            flex-direction: row;
            margin: 15px;
            width: 95%;
            height: 200px;
            box-shadow: 2px 2px 3px #AFAFAF;
        }
        .img-tile {
            display: flex;
            flex-direction: row;
            width: 50%;
        }
        .img-tile-item {
            display: flex;
            flex-direction: column;
            width: 40%;
        }
        .img-tile-item img {
            border-style: solid;
            border-color: #FFFFFF;
            border-width: 0px 1px 1px 1px;
            height: 50%;
        }
        .img-tile-item-initial {
            border-style: solid;
            border-color: #FFFFFF;
            border-width: 0px 0px 1px 1px;
            width: 60%;
        }
        .cover {
            height: 100%;
            width: 100%;
            object-fit: cover;
        }
        .offer-info {
            border: none;
            display: flex;
            flex-direction: row;
            width: 50%;
        }
        .offer-info-left {
            font-size: 22px;
            padding: 15px;
            flex: 0.7;
            border: inherit;
            display: flex;
            flex-direction: column;
        }
        .offer-info-left .name {
            font-size: 40px;
            color: #005da9;
            margin-bottom: 15px;
        }
        .offer-info-right {
            font-size: 32px;
            padding: 15px;
            flex: 0.3;
            border: inherit;
            display: flex;
            flex-direction: column;
            align-items: flex-end;
        }
        .offer-info-right .price {
            font-size: 40px;
        }
        .offer-info-right .offer-heart {
            margin-top: 35px;
            font-size: 40px;
        }
    </style>
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
            <s:iterator value="hotels" var="hotel"
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
                            <span class="name">$(hotel.name)</span>
                            <span class="blurb">$(hotel.address)</span>
                        </div>
                        <div class="offer-info-right">
                            <span class="price">$100</span>
                            <span class="fa icons">&#xf0f5;</span>
                            <span class="fa offer-heart">&#xf08a;</span>
                        </div>
                    </div>
                </div>
            </s:iterator>
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
