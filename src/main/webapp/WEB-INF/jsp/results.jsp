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
        </div>
    </header>
    <div id="selector">
        <form class="flexform results-form" action="/results">
            <input type="search" class="fa" name="search" placeholder="&#xf002; Search..">
            <input type="text" class="fa" name="start" id="start" placeholder="&#xf073; Arrive" />
            <input type="text" class="fa" name="finish" id="end" placeholder="&#xf073; Leave">
            <input type="text" class="fa" name="people" placeholder="&#xf0c0; 3 guests, pets">
            <input type="submit" class="btn" name="submit" placeholder="Submit">
            <div class="options">
                <span>Accommodation: <input type="checkbox" name="accommodation-check" value="Accommodation"></span>
                <span>Events: <input type="checkbox" name="event-check" value="Events"></span>
                <span>Restaurants: <input type="checkbox" name="restaurant-check" value="Restaurants"></span>
                <span>Transport: <input type="checkbox" name="transport-check" value="Transport"></span>
                <span class="flex-divider"></span>
                <span><a class="fa fa-chevron-right-after content-toggle">More Filters</a></span>
                <span><a href="/results">Clear Filters x</a><br/><s:property value="totalCount"/> Result(s)</span>
            </div>
        </form>
    </div>
    <div id="filters">
        <div id="event-type" class="invisible">
            <h3>Event Type</h3>
            <span><input type="checkbox"> Luxury</span>
            <span><input type="checkbox"> Affordable</span>
            <span><input type="checkbox"> Basic</span>
        </div>
        <div id="accommodation-type" class="invisible">
            <h3>Accommodation Type</h3>
            <span><input type="checkbox"> Luxury</span>
            <span><input type="checkbox"> Affordable</span>
            <span><input type="checkbox"> Basic</span>
        </div>
        <div id="restaurant-type" class="invisible">
            <h3>Restaurant Type</h3>
            <span><input type="checkbox"> Luxury</span>
            <span><input type="checkbox"> Affordable</span>
            <span><input type="checkbox"> Basic</span>
        </div>
        <div id="transport-type" class="invisible" style="flex-wrap: wrap">
            <h3>Transport Type</h3>
            <span><input type="checkbox"> Luxury</span>
            <span><input type="checkbox"> Affordable</span>
            <span><input type="checkbox"> Basic</span>
        </div>
        <div id="location-type" class="invisible">
            <h3>Location Type</h3>
            <span><input type="checkbox"> Beach</span>
            <span><input type="checkbox"> City</span>
            <span><input type="checkbox"> Mountains</span>
            <span><input type="checkbox"> Near the Ocean</span>
            <span><input type="checkbox"> Resort</span>
            <span><input type="checkbox"> Rural</span>
            <span><input type="checkbox"> Town</span>
            <span><input type="checkbox"> Village</span>
            <span><input type="checkbox"> Waterfront</span>
            <span><input type="checkbox"> Golf</span>
            <span><input type="checkbox"> Ski</span>
        </div>
        <div id="extra-features" class="invisible">
            <h3>Extra Features</h3>
            <span><input type="checkbox"> Air Conditioning</span>
            <span><input type="checkbox"> BBQ</span>
            <span><input type="checkbox"> Dishwasher</span>
            <span><input type="checkbox"> Free WiFi</span>
            <span><input type="checkbox"> Garden</span>
            <span><input type="checkbox"> Internet Access</span>
            <span><input type="checkbox"> Car Parking</span>
            <span><input type="checkbox"> Pool</span>
            <span><input type="checkbox"> Wasing Machine</span>
            <span><input type="checkbox"> Children Welcome</span>
            <span><input type="checkbox"> Non Smoking Only</span>
            <span><input type="checkbox"> Pets Considered</span>
            <span><input type="checkbox"> Elderly Friendly</span>
            <span><input type="checkbox"> Wheelchair Accessible</span>
        </div>
    </div>
    <div id="results-container">
        <div id="restults-content">
            <div id="display-type">
                <h2>Display: &nbsp;</h2>
                <a href="#" id="display-tile" class="fa fa-2x fa-th-large">&nbsp;</a>
                <a href="#" id="display-list" class="fa fa-2x fa-th-list">&nbsp;</a>
                <hr />
            </div>
                <div id="results" class="flex-col">
                <s:if test="%{recommendedItem == 0}">
                    <s:iterator value="recommendedHotels" var="rec">
                        <div class="offer-list recommendation">
                            <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                            <a href="edit-cart?method=add&type=hotel&id=${rec.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                                <span class="tooltiptext">Add to package</span>
                            </span></a>
                            <div class="offer-images">
                                <div class="offer-img-initial" style="min-height: 150px;">
                                    <img src='../../img/hotels/hotel${(rec.id)%17}.jpg' class="cover"/>
                                </div>
                                <div class="offer-img-item">
                                    <img src='../../img/hotels/hotel${(rec.id + 10)%17}.jpg' class="cover"/>
                                    <img src='../../img/hotels/hotel${(rec.id + 5)%17}.jpg' class="cover"/>
                                </div>
                            </div>
                            <div class="offer-info">
                                <div class="offer-info-left">
                                    <span class="name">${rec.name}</span>
                                    <span>${rec.address}</span>
                                    <span class="blurb invisible">${rec.description}</span>
                                    <span class="addr invisible">${rec.address}</span>
                                    <span class="contact invisible">${rec.contact}</span>
                                    <span class="email invisible">${rec.email}</span>
                                    <span class="website invisible">${rec.website}</span>
                                </div>
                                <div class="offer-info-right">
                                    <span class="price">from $<%= (int)(Math.random() * 650 + 100) %></span>
                                    <span class="fa icons">&#xf2cd&nbsp;&#xf236</span>
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
                                    <img src='../../img/hotels/hotel${(rec.id + 5)%17}.jpg' class="cover"/>
                                </div>
                            </div>
                            <div class="offer-info">
                                <div class="offer-info-left">
                                    <span class="name">${rec.name}</span>
                                    <span>${rec.location}</span>
                                    <span class="blurb invisible">${rec.overview}</span>
                                    <span class="addr invisible">${rec.location}</span>
                                    <span class="contact invisible">${rec.info}</span>
                                    <span class="email invisible">${rec.description}</span>
                                    <span class="website invisible">${rec.guidelines}</span>
                                </div>
                                <div class="offer-info-right">
                                    <span class="price">from $<%= (int)(Math.random() * 800 + 50) %></span>
                                    <span class="fa icons">&#xf290&nbsp;&#xf083</span>
                                </div>
                            </div>
                        </div>
                    </s:iterator>
                </s:if>
                <s:if test="%{recommendedItem == 2}">
                    <s:iterator value="recommendedRestaurants" var="rec">
                        <div class="offer-list recommendation">
                            <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                            <a href="edit-cart?method=add&type=restaurant&id=${rec.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                                <span class="tooltiptext">Add to package</span>
                            </span></a>
                            <div class="offer-images">
                                <div class="offer-img-initial" style="min-height: 150px;">
                                    <img src='../../img/restaurants/restaurant${(rec.id)%17}.jpg' class="cover"/>
                                </div>
                                <div class="offer-img-item">
                                    <img src='../../img/hotels/hotel${(rec.id + 10)%17}.jpg' class="cover"/>
                                    <img src='../../img/hotels/hotel${(rec.id + 5)%17}.jpg' class="cover"/>
                                </div>
                            </div>
                            <div class="offer-info">
                                <div class="offer-info-left">
                                    <span class="name">${rec.name}</span>
                                    <span>${rec.address}</span>
                                    <span class="blurb invisible">${rec.description}</span>
                                    <span class="addr invisible">${rec.address}</span>
                                    <span class="contact invisible">${rec.contact}</span>
                                    <span class="email invisible">${rec.email}</span>
                                    <span class="website invisible">${rec.website}</span>
                                </div>
                                <div class="offer-info-right">
                                    <span class="price">from $<%= (int)(Math.random() * 200 + 20) %></span>
                                    <span class="fa icons">&#xf0fc&nbsp;&#xf0f5</span>
                                </div>
                            </div>
                        </div>
                    </s:iterator>
                </s:if>
                <s:iterator value="transport" var="t">
                    <div class="offer-list recommendation">
                        <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                        <a href="edit-cart?method=add&type=transport&id=${t.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                            <span class="tooltiptext">Add to package</span>
                        </span></a>
                        <div class="offer-images">
                            <div class="offer-img-initial" style="min-height: 150px;">
                                <img src='../../img/shuttlebus.jpg' class="cover"/>
                            </div>
                            <div class="offer-img-item">
                                <img src='../../img/shuttlebus3.jpg' class="cover"/>
                                <img src='../../img/shuttlebus2.jpg' class="cover"/>
                            </div>
                        </div>
                        <div class="offer-info">
                            <div class="offer-info-left">
                                <span class="name">${t.name}</span>
                                <span class="blurb">${t.description}</span>
                            </div>
                            <div class="offer-info-right">
                                <span class="price">from $40</span>
                                <span class="fa icons">&#xf21c&nbsp;&#xf1b9</span>
                            </div>
                        </div>
                    </div>
                </s:iterator>


                <s:iterator value="hotels" var="h">
                    <div class="offer-list">
                        <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                        <a href="edit-cart?method=add&type=hotel&id=${h.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                            <span class="tooltiptext">Add to package</span>
                        </span></a>
                        <div class="offer-images">
                            <div class="offer-img-initial" style="min-height: 150px;">
                                <img src='../../img/hotels/hotel${(h.id)%17}.jpg' class="cover"/>
                            </div>
                            <div class="offer-img-item">
                                <img src='../../img/hotels/hotel${(h.id + 10)%17}.jpg' class="cover"/>
                                <img src='../../img/hotels/hotel${(h.id + 5)%17}.jpg' class="cover"/>
                            </div>
                        </div>
                        <div class="offer-info">
                            <div class="offer-info-left">
                                <span class="name">${h.name}</span>
                                <span>${h.address}</span>
                                <span class="blurb invisible">${h.description}</span>
                                <span class="addr invisible">${h.address}</span>
                                <span class="contact invisible">${h.contact}</span>
                                <span class="email invisible">${h.email}</span>
                                <span class="website invisible">${h.website}</span>
                            </div>
                            <div class="offer-info-right">
                                <span class="price">from $<%= (int)(Math.random() * 650 + 100) %></span>
                                <span class="fa icons">&#xf2cd&nbsp;&#xf236</span>
                            </div>
                        </div>
                    </div>
                </s:iterator>
                <s:iterator value="restaurants" var="r">
                    <div class="offer-list">
                        <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                        <a href="edit-cart?method=add&type=restaurant&id=${r.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                            <span class="tooltiptext">Add to package</span>
                        </span></a>
                        <div class="offer-images">
                            <div class="offer-img-initial" style="min-height: 150px;">
                                <img src='../../img/restaurants/restaurant${(r.id)%17}.jpg' class="cover"/>
                            </div>
                            <div class="offer-img-item">
                                <img src='../../img/hotels/hotel${(r.id + 10)%17}.jpg' class="cover"/>
                                <img src='../../img/hotels/hotel${(r.id + 5)%17}.jpg' class="cover"/>
                            </div>
                        </div>
                        <div class="offer-info">
                            <div class="offer-info-left">
                                <span class="name">${r.name}</span>
                                <span>${r.address}</span>
                                <span class="blurb invisible">${r.description}</span>
                                <span class="addr invisible">${r.address}</span>
                                <span class="contact invisible">${r.contact}</span>
                                <span class="email invisible">${r.email}</span>
                                <span class="website invisible">${r.website}</span>
                            </div>
                            <div class="offer-info-right">
                                <span class="price">from $<%= (int)(Math.random() * 200 + 20) %></span>
                                <span class="fa icons">&#xf0fc&nbsp;&#xf0f5</span>
                            </div>
                        </div>
                    </div>
                </s:iterator>
                <s:iterator value="experiences" var="e">
                    <div class="offer-list">
                        <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                        <a href="edit-cart?method=add&type=experience&id=${e.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                            <span class="tooltiptext">Add to package</span>
                        </span></a>
                        <div class="offer-images">
                            <div class="offer-img-initial" style="min-height: 150px;">
                                <img src='../../img/experiences/experience${(e.id)%17}.jpg' class="cover"/>
                            </div>
                            <div class="offer-img-item">
                                <img src='../../img/hotels/hotel${(e.id + 10)%17}.jpg' class="cover"/>
                                <img src='../../img/hotels/hotel${(e.id + 5)%17}.jpg' class="cover"/>
                            </div>
                        </div>
                        <div class="offer-info">
                            <div class="offer-info-left">
                                <span class="name">${e.name}</span>
                                <span>${e.location}</span>
                                <span class="blurb invisible">${e.overview}</span>
                                <span class="addr invisible">${e.location}</span>
                                <span class="contact invisible">${e.info}</span>
                                <span class="email invisible">${e.description}</span>
                                <span class="website invisible">${e.guidelines}</span>
                            </div>
                            <div class="offer-info-right">
                                <span class="price">from $<%= (int)(Math.random() * 800 + 50) %></span>
                                <span class="fa icons">&#xf290&nbsp;&#xf083</span>
                            </div>
                        </div>
                    </div>
                </s:iterator>
                <s:iterator value="transport" var="t">
                    <div class="offer-list">
                        <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                        <a href="edit-cart?method=add&type=transport&id=${t.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                            <span class="tooltiptext">Add to package</span>
                        </span></a>
                        <div class="offer-images">
                            <div class="offer-img-initial" style="min-height: 150px;">
                                <img src='../../img/shuttlebus.jpg' class="cover"/>
                            </div>
                            <div class="offer-img-item">
                                <img src='../../img/shuttlebus3.jpg' class="cover"/>
                                <img src='../../img/shuttlebus2.jpg' class="cover"/>
                            </div>
                        </div>
                        <div class="offer-info">
                            <div class="offer-info-left">
                                <span class="name">${t.name}</span>
                                <span class="blurb">${t.description}</span>
                            </div>
                            <div class="offer-info-right">
                                <span class="price">from $40%></span>
                                <span class="fa icons">&#xf21c&nbsp;&#xf1b9</span>
                            </div>
                        </div>
                    </div>
                </s:iterator>
            </div>
            <div id="offer-info-large" class="hidden">
                <div id="offer-image"></div>
                <div id="offer-info">
                    <h2 id="offer-name"></h2>
                    <p id="offer-desc"></p>
                    <p id="offer-addr"></p>
                    <p id="offer-contact"></p>
                    <p id="offer-email"></p>
                    <p id="offer-website"></p>
                    <a href="" id="show-results">Back to Results</a>
                </div>
            </div>
        </div>
        <div id="package-info">
            <div id="package-header">
                <h2>Create your perfect holiday experience</h2>
            </div>

            <s:set var="size" value="cart.size"/>
            <s:if test="%{#size == 0}">
            <div id="package-contents" class="center">
                <h2 style="padding-top: 25px">Nothing here yet!</h2>
                <h3 style="padding-top: 25px">Add an offer from the left by<br />
                    clicking the plus symbol at the bottom right</h3>
            </div>
            </s:if>
            <s:else>
            <div id="package-contents" class="center">
                <s:set var="type" value="%{'experience'}"/>
                <s:iterator value="cart.experiences" var="c" status="entry">
                    <%@include file="helpers/resultsCart.jsp"%>
                </s:iterator>
                <s:set var="type" value="%{'hotel'}"/>
                <s:iterator value="cart.hotels" var="c" status="entry">
                    <%@include file="helpers/resultsCart.jsp"%>
                </s:iterator>
                <s:set var="type" value="%{'restaurant'}"/>
                <s:iterator value="cart.restaurants" var="c" status="entry">
                    <%@include file="helpers/resultsCart.jsp"%>
                </s:iterator>
                <s:set var="type" value="%{'transport'}"/>
                <s:iterator value="cart.transport" var="c" status="entry">
                    <%@include file="helpers/resultsCart.jsp"%>
                </s:iterator>
            </div>
            <div id="package-confirmation">
                <div class="left center">
                    <h3>Current Total: $${cart.price}</h3>
                    <h3>You save: $${cart.savings}!</h3>
                </div>
                <div class="right center">
                    <s:set var="ready" value="cart.readyToPay"/>
                    <s:if test="%{#ready}">
                        <h3><a href="payment">Confirm</a></h3>
                    </s:if>
                    <s:else>
                        <h3>CANNOT PAY<br/>Cart Not Ready</h3>
                    </s:else>
                </div>
            </div>
            </s:else>
        </div>
    </div>
</main>

<script>window.jQuery || document.write('<script src="../../js/vendor/jquery-1.12.0.min.js"><\/script>')</script>
<script src="../../js/pikaday.js"></script>
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>
<script>
    var str;
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
    $("#display-list").click(function() {
        $('#results').addClass('flex-col').removeClass('flex-row');
        $('.offer-tile').toggleClass('offer-list').toggleClass('offer-tile');
    });
    $("#display-tile").click(function() {
        $('#results').addClass('flex-row').removeClass('flex-col');
        $('.offer-list').toggleClass('offer-tile').toggleClass('offer-list');
    });
    $(".offer-list > .offer-images").on('click', function() {
        $('#results').addClass('hidden');
        $('#display-type').addClass('hidden');
        $('.offer-list').addClass('hidden');
        $('#offer-info-large').removeClass('hidden');
        str = $(this).parent().find(".name").text();
        $('#offer-name').html(str);
        str = $(this).parent().find(".blurb").text();
        $('#offer-desc').html(str);
        str = $(this).parent().find(".addr").text();
        $('#offer-addr').html(str);
        str = $(this).parent().find(".contact").text();
        $('#offer-contact').html(str);
        str = $(this).parent().find(".email").text();
        $('#offer-email').html(str);
        str = $(this).parent().find(".website").text();
        $('#offer-website').html(str);
        $(this).find(".offer-img-initial").clone().appendTo('#offer-image');
    });
    $(".offer-list > .offer-info").on('click', function() {
        $('#results').addClass('hidden');
        $('#display-type').addClass('hidden');
        $('.offer-list').addClass('hidden');
        $('#offer-info-large').removeClass('hidden');
        str = $(this).parent().find(".name").text();
        $('#offer-name').html(str);
        str = $(this).parent().find(".blurb").text();
        $('#offer-desc').html(str);
        str = $(this).parent().find(".addr").text();
        $('#offer-addr').html(str);
        str = $(this).parent().find(".contact").text();
        $('#offer-contact').html(str);
        str = $(this).parent().find(".email").text();
        $('#offer-email').html(str);
        str = $(this).parent().find(".website").text();
        $('#offer-website').html(str);
        $(this).parent().find(".offer-img-initial").clone().appendTo('#offer-image');
    });
    $("#show-results").on('click', function() {
        $('#offer-info-large').addClass('hidden');
        $('#results').removeClass('hidden');
        $('#display-type').removeClass('hidden');
        $('.offer-list').removeClass('hidden');
    });
</script>

</body>
</html>
