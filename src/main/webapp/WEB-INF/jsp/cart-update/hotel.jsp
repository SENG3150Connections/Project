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
            <div id="package-contents" class="center" style="overflow: hidden;flex-basis:100%">
                <form action="update-hotel" class="flexform packageform">

                    <input type="hidden" name="cartIndex" value="${cartIndex}"> <%-- Hidden input to maintain cart index --%>

                    <%-- Room type to book --%>
                    <br/>Room:<br/>
                    <select name="roomId">
                        <s:iterator value="offerings" var="o" status="entry">
                            <option value="${o.id}">${o.title} - ${o.noguestmax} People</option>
                        </s:iterator>
                    </select>

                    <%-- How many adults --%>
                    <br/>Adults:<br/>
                    <input type="number" name="adults" min="1" max="9" step="1" value="${hotel.adults}">

                    <%-- How many children --%>
                    <br/>Children:<br/>
                    <input type="number" name="children" min="0" max="9" step="1" value="${hotel.children}">

                    <%-- Check in and check out dates --%>
                    <br/>CheckIn:<br/>
                    <input type="text" id="start" name="checkIn" value="${hotel.checkIn}" required>
                    <br/>CheckOut:<br/>
                    <input type="text" id="end" name="checkOut" value="${hotel.checkOut}" required>

                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </div>
</main>

<%-- Scripts for pikaday calendars --%>
<script>window.jQuery || document.write('<script src="../../js/vendor/jquery-1.12.0.min.js"><\/script>')</script>
<script src="../../../js/moment.js"></script>
<script src="../../../js/pikaday.js"></script>
<script src="../../../js/plugins.js"></script>
</body>
</html>

