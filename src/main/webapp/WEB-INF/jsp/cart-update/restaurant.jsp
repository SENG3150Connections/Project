<%--
restaurant.jsp
Author: Tim Pitts

Description:
    The page where a user may edit an restaurant item that is currently inside their
    shopping cart. They can select:
    - Seats to book
    - Time of arrival
    - (OPTIONAL) Voucher price to pre-purchase

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
    <jsp:include page="../helpers/header.jsp"/>

    <div id="results-container">
        <%-- Recommendation panel --%>
        <div id="restults-content" style="height:100vh;">
            <%@include file="recommendation-panel.jsp"%>
        </div>

        <%-- The item edit panel --%>
        <div id="package-info">
            <div id="package-header">
                <h2>Tailor the offer to suit you</h2>
            </div>
            <div id="package-contents" class="center" style="overflow: hidden;height:100vh">
                <form action="update-restaurant" class="flexform packageform">

                    <input type="hidden" name="cartIndex" value="${cartIndex}"> <%-- Hidden input to maintain cart index --%>

                    <br/>Seats:<br/> <%-- Seats to book --%>
                    <div class="quantity">
                        <input type="number" name="seats" min="1" max="9" step="1"  value="${restaurant.seats}" required>
                    </div>

                    <br/>Time:<br/> <%-- Time to book for --%>
                    <input type="text" id="time" name="time" value="${restaurant.time}">

                    <br/>Voucher Price:<br/> <%-- OPTIONAL voucher amount to purchase --%>
                    <div class="quantity">
                        <input type="number" name="voucherPrice" min="0" max="150" step="10"  value="${restaurant.voucherPrice}">
                    </div>

                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </div>
</main>

<%-- Scripts for the pickaday calendars --%>
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

