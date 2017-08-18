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
<s:set var="numResults" value="0"/>
<s:set var="avalue"><%= request.getParameter("search") %></s:set>
<s:iterator value="hotels" var="h">
    <s:set var="hName">${h.name}</s:set>
    <s:if test="%{(#hName.toLowerCase().indexOf(#avalue.toLowerCase()) != -1) || (#avalue=='null')}">
        <s:set var="numResults" value="%{#numResults+1}"/>
    </s:if>
</s:iterator>
<s:iterator value="restaurants" var="r">
    <s:set var="rName">${r.name}</s:set>
    <s:if test="%{(#rName.toLowerCase().indexOf(#avalue.toLowerCase()) != -1) || (#avalue=='null')}">
        <s:set var="numResults" value="%{#numResults+1}"/>
    </s:if>
</s:iterator>
<s:iterator value="experiences" var="e">
    <s:set var="eName">${e.name}</s:set>
    <s:if test="%{(#eName.toLowerCase().indexOf(#avalue.toLowerCase()) != -1) || (#avalue=='null')}">
        <s:set var="numResults" value="%{#numResults+1}"/>
    </s:if>
</s:iterator>

<main>
    <header id="header-container">
        <div class="header">
            <div class="homepage-menu">
                <p class="fa" style="cursor: pointer;">&#xf0c9;</p>
            </div>
            <div class="homepage-logo">
                <h1><a href="/home">NewcastleConnections</a></h1>
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
                <span><a href="/results">Clear Filters x</a><br/><s:property value="numResults"/> Result(s)</span>
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
        <div id="results">
            <s:iterator value="hotels" var="h">
                <s:set var="hName">${h.name}</s:set>
                <s:if test="%{(#hName.toLowerCase().indexOf(#avalue.toLowerCase()) != -1) || (#avalue=='null')}">
                    <div class="offer-tile">
                        <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                        <span class="fa fa-plus offer-add" aria-hidden="true">
                            <span class="tooltiptext">Add to package</span>
                        </span>
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
                                <span class="name">${h.name}</span>
                                <span class="blurb">${h.address}</span>
                            </div>
                            <div class="offer-info-right">
                                <span class="price">$DB TBA</span>
                                <span class="fa icons">&#xf236;</span>
                            </div>
                        </div>
                    </div>
                </s:if>
            </s:iterator>
            <s:iterator value="restaurants" var="r">
                <s:set var="rName">${r.name}</s:set>
                <s:if test="%{(#rName.toLowerCase().indexOf(#avalue.toLowerCase()) != -1) || (#avalue=='null')}">
                    <div class="offer-tile">
                        <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                        <span class="fa fa-plus offer-add" aria-hidden="true">
                            <span class="tooltiptext">Add to package</span>
                        </span>
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
                                <span class="name">${r.name}</span>
                                <span class="blurb">${r.address}</span>
                            </div>
                            <div class="offer-info-right">
                                <span class="price">$DB TBA</span>
                                <span class="fa icons">&#xf0f5;</span>
                            </div>
                        </div>
                    </div>
                </s:if>
            </s:iterator>
            <s:iterator value="experiences" var="e">
                <s:set var="eName">${e.name}</s:set>
                <s:if test="%{(#eName.toLowerCase().indexOf(#avalue.toLowerCase()) != -1) || (#avalue=='null')}">
                    <div class="offer-tile">
                        <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                        <span class="fa fa-plus offer-add" aria-hidden="true">
                            <span class="tooltiptext">Add to package</span>
                        </span>
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
                                <span class="name">${e.name}</span>
                                <span class="blurb">${e.location}</span>
                            </div>
                            <div class="offer-info-right">
                                <span class="price">$DB TBA</span>
                                <span class="fa icons">&#xf209;</span>
                            </div>
                        </div>
                    </div>
                </s:if>
            </s:iterator>
        </div>
        <div id="package-info">
            <div id="package-header">
                <h2>Create your perfect holiday experience</h2>
            </div>
            <div id="package-contents" class="center">
                <h2>Nothing here yet!</h2>
                <h3>Add an offer from the left</h3>
            </div>
            <div id="package-confirmation">
                <div class="left center">
                    <h3>Total: </h3>
                    <h3>You save: !</h3>
                </div>
                <div class="right center">
                    <h3>Confirm</h3>
                </div>
            </div>
        </div>
    </div>
</main>

<script>window.jQuery || document.write('<script src="../../js/vendor/jquery-1.12.0.min.js"><\/script>')</script>
<script src="../../js/pikaday.js"></script>
<script src="js/plugins.js"></script>
<script src="js/main.js"></script>
<script>
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
</script>

</body>
</html>
