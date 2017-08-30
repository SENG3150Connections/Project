<%--
hotel.jsp
Author: Tim Pitts

Description:
    The page where a user may edit an hotel item that is currently inside their
    shopping cart. They can select:
    - Room type
    - Adults / Children
    - Check in / out

    Recommendations appear in a side panel.
--%>

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
            <%@include file="recommendation-panel.jsp"%>
        </div>
        <div id="package-info">
            <div id="package-header">
                <h2>Tailor the offer to suit you</h2>
            </div>
            <div id="package-contents" class="center" style="overflow: hidden;flex-basis:100%">
                <form action="update-hotel" class="flexform packageform">
                    <input type="hidden" name="cartIndex" value="${cartIndex}">

                    <br/>Room:<br/>
                    <select name="roomId">
                        <s:iterator value="offerings" var="o" status="entry">
                            <option value="${o.id}">${o.title} - ${o.noguestmax} People</option>
                        </s:iterator>
                    </select>

                    <br/>Adults:<br/>
                    <div class="quantity">
                        <input type="number" name="adults" min="1" max="9" step="1" value="${hotel.adults}">
                    </div>

                    <br/>Children:<br/>
                    <div class="quantity">
                        <input type="number" name="children" min="0" max="9" step="1" value="${hotel.children}">
                    </div>

                    <br/>CheckIn:<br/>
                    <input type="text" id="checkIn" name="checkIn" value="${hotel.checkIn}" required>
                    <br/>CheckOut:<br/>
                    <input type="text" id="checkOut" name="checkOut" value="${hotel.checkOut}" required>

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
                field: document.getElementById('checkIn'),
                minDate: new Date(),
                maxDate: new Date(2020, 12, 31),
                format: 'YYYY-MM-D h:mm:ss',
                onSelect: function() {
                    startDate = this.getDate();
                    updateStartDate();
                }
            }),
            endPicker = new Pikaday({
                field: document.getElementById('checkOut'),
                minDate: new Date(),
                maxDate: new Date(2020, 12, 31),
                format: 'YYYY-MM-D h:mm:ss',
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
    jQuery('<div class="quantity-nav"><div class="quantity-button quantity-up">+</div><div class="quantity-button quantity-down">-</div></div>').insertAfter('.quantity input');
    jQuery('.quantity').each(function() {
        var spinner = jQuery(this),
            input = spinner.find('input[type="number"]'),
            btnUp = spinner.find('.quantity-up'),
            btnDown = spinner.find('.quantity-down'),
            min = input.attr('min'),
            max = input.attr('max');

        btnUp.click(function() {
            var oldValue = parseFloat(input.val());
            if (oldValue >= max) {
                var newVal = oldValue;
            } else {
                var newVal = oldValue + 1;
            }
            spinner.find("input").val(newVal);
            spinner.find("input").trigger("change");
        });

        btnDown.click(function() {
            var oldValue = parseFloat(input.val());
            if (oldValue <= min) {
                var newVal = oldValue;
            } else {
                var newVal = oldValue - 1;
            }
            spinner.find("input").val(newVal);
            spinner.find("input").trigger("change");
        });

    });
</script>

</body>
</html>

