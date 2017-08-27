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

    <div id="results-container">
        <div id="restults-content" style="height:100vh;">
            <s:if test="%{recommendedItem == 0}">
                <s:iterator value="recommendedHotels" var="rec">
                    <div class="offer-list recommendation">
                        <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                        <a href="edit-cart?method=add&type=experience&id=${rec.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                                <span class="tooltiptext">Add to package</span>
                            </span></a>
                        <div class="offer-images">
                            <div class="offer-img-initial" style="min-height: 150px;">
                                <img src='../../img/hotels/hotel${(rec.id)%17}.jpg' class="cover"/>
                            </div>
                            <div class="offer-img-item">
                                <img src='../../img/hotels/hotel${(rec.id + 10)%17}.jpg' class="cover"/>
                                <img src='../../img/hotels/hotel${(rec.id + 16)%17}.jpg' class="cover"/>
                            </div>
                        </div>
                        <div class="offer-info">
                            <div class="offer-info-left">
                                <span class="name">${rec.name}</span>
                                <span class="blurb">${rec.description}</span>
                            </div>
                        </div>
                    </div>
                </s:iterator>
            </s:if>
            <s:if test="%{recommendedItem == 1}">
                <s:iterator value="recommendedExperiences" var="rec">
                    <div class="offer-list recommendation">
                        <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                        <a href="edit-cart?method=add&type=experience&id=${rec.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                                <span class="tooltiptext">Add to package</span>
                            </span></a>
                        <div class="offer-images">
                            <div class="offer-img-initial" style="min-height: 150px;">
                                <img src='../../img/experiences/experience${(rec.id)%17}.jpg' class="cover"/>
                            </div>
                            <div class="offer-img-item">
                                <img src='../../img/hotels/hotel${(rec.id + 10)%17}.jpg' class="cover"/>
                                <img src='../../img/hotels/hotel${(rec.id + 16)%17}.jpg' class="cover"/>
                            </div>
                        </div>
                        <div class="offer-info">
                            <div class="offer-info-left">
                                <span class="name">${rec.name}</span>
                                <span class="blurb">${rec.info}</span>
                            </div>
                            <div class="offer-info-right">
                                <span class="price">${rec.price}</span>
                                <span class="fa icons">&#xf2cd&nbsp;&#xf236</span>
                            </div>
                        </div>
                    </div>
                </s:iterator>
            </s:if>
            <s:if test="%{recommendedItem == 2}">
                <s:iterator value="recommendedRestaurants" var="rec">
                    <div class="offer-list recommendation">
                        <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                        <a href="edit-cart?method=add&type=experience&id=${rec.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                                <span class="tooltiptext">Add to package</span>
                            </span></a>
                        <div class="offer-images">
                            <div class="offer-img-initial" style="min-height: 150px;">
                                <img src='../../img/restaurants/restaurant${(rec.id)%17}.jpg' class="cover"/>
                            </div>
                            <div class="offer-img-item">
                                <img src='../../img/hotels/hotel${(rec.id + 10)%17}.jpg' class="cover"/>
                                <img src='../../img/hotels/hotel${(rec.id + 16)%17}.jpg' class="cover"/>
                            </div>
                        </div>
                        <div class="offer-info">
                            <div class="offer-info-left">
                                <span class="name">${rec.name}</span>
                                <span class="blurb">${rec.description}</span>
                            </div>
                            <div class="offer-info-right">
                            </div>
                        </div>
                    </div>
                </s:iterator>
            </s:if>
        </div>
        <div id="package-info">
            <div id="package-header">
                <h2>Tailor the offer to suit you</h2>
            </div>
            <div id="package-contents" class="center" style="overflow: hidden">
                <form action="update-restaurant" class="flexform packageform">

                    <input type="hidden" name="cartIndex" value="${cartIndex}">
                    <br/>Seats:<br/>
                    <input type="number" name="seats" value="${restaurant.seats}">
                    <br/>Time:<br/>
                    <input type="text" id="time" name="time" value="${restaurant.time}">
                    <br/>Voucher Price:<br/>
                    <input type="number" name="voucherPrice" value="${restaurant.voucherPrice}">

                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </div>
</main>

<script>window.jQuery || document.write('<script src="../../js/vendor/jquery-1.12.0.min.js"><\/script>')</script>
<script src="../../js/moment.js"></script>
<script src="../../js/pikaday.js"></script>
<script src="js/main.js"></script>
<script>
    (function() {
        var startDate,
            endDate,
            updateStartDate = function() {
                startPicker.setStartRange(startDate);
                endPicker.setStartRange(startDate);
                endPicker.setMinDate(startDate);
            },
            updateEndDate = function() {
                startPicker.setEndRange(endDate);
                startPicker.setMaxDate(endDate);
                endPicker.setEndRange(endDate);
            },
            startPicker = new Pikaday({
                field: document.getElementById('time'),
                minDate: new Date(),
                maxDate: new Date(2020, 12, 31),
                format: 'YYYY-MM-d h:mm:ss',
                onSelect: function() {
                    startDate = this.getDate();
                    updateStartDate();
                }
            }),
            endPicker = new Pikaday({
                field: document.getElementById('checkOut'),
                minDate: new Date(),
                maxDate: new Date(2020, 12, 31),
                format: 'YYYY-MM-d h:mm:ss',
                onSelect: function() {
                    endDate = this.getDate();
                    updateEndDate();

                }
            }),
            _startDate = startPicker.getDate(),
            _endDate = endPicker.getDate();

        if (_startDate) {
            startDate = _startDate;
            updateStartDate();
        }

        if (_endDate) {
            endDate = _endDate;
            updateEndDate();
        }
    }());
</script>

</body>
</html>

