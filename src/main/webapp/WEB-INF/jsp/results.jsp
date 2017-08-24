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
                <s:iterator value="recommendedExperiences" var="rec">
                    <div class="offer-list" style="background-color: goldenrod">
                        <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                        <a href="edit-cart?method=add&type=experience&id=${rec.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                            <span class="tooltiptext">Add to package</span>
                        </span></a>
                        <div class="offer-images">
                            <div class="offer-img-initial">
                                <img src='../../img/offer-img.jpg' class="cover"/>
                            </div>
                            <div class="offer-img-item">
                                <img src='../../img/offer-img-2.jpg' class="cover"/>
                                <img src='../../img/offer-img-3.jpg' class="cover"/>
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

                <s:iterator value="hotels" var="h">
                    <div class="offer-list">
                        <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
                        <a href="edit-cart?method=add&type=hotel&id=${h.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                            <span class="tooltiptext">Add to package</span>
                        </span></a>
                        <div class="offer-images">
                            <div class="offer-img-initial">
                                <img src='../../img/offer-img.jpg' class="cover"/>
                            </div>
                            <div class="offer-img-item">
                                <img src='../../img/offer-img-2.jpg' class="cover"/>
                                <img src='../../img/offer-img-3.jpg' class="cover"/>
                            </div>
                        </div>
                        <div class="offer-info">
                            <div class="offer-info-left">
                                <span class="name">${h.name}</span>
                                <span class="blurb">${h.address}</span>
                            </div>
                            <div class="offer-info-right">
                                <span class="price">$DB TBA</span>
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
                            <div class="offer-img-initial">
                                <img src='../../img/offer-img.jpg' class="cover"/>
                            </div>
                            <div class="offer-img-item">
                                <img src='../../img/offer-img-2.jpg' class="cover"/>
                                <img src='../../img/offer-img-3.jpg' class="cover"/>
                            </div>
                        </div>
                        <div class="offer-info">
                            <div class="offer-info-left">
                                <span class="name">${r.name}</span>
                                <span class="blurb">${r.address}</span>
                            </div>
                            <div class="offer-info-right">
                                <span class="price">$DB TBA</span>
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
                            <div class="offer-img-initial">
                                <img src='../../img/offer-img.jpg' class="cover"/>
                            </div>
                            <div class="offer-img-item">
                                <img src='../../img/offer-img-2.jpg' class="cover"/>
                                <img src='../../img/offer-img-3.jpg' class="cover"/>
                            </div>
                        </div>
                        <div class="offer-info">
                            <div class="offer-info-left">
                                <span class="name">${e.name}</span>
                                <span class="blurb">${e.info}</span>
                            </div>
                            <div class="offer-info-right">
                                <span class="price">${e.price}</span>
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
                            <div class="offer-img-initial">
                                <img src='../../img/offer-img.jpg' class="cover"/>
                            </div>
                            <div class="offer-img-item">
                                <img src='../../img/offer-img-2.jpg' class="cover"/>
                                <img src='../../img/offer-img-3.jpg' class="cover"/>
                            </div>
                        </div>
                        <div class="offer-info">
                            <div class="offer-info-left">
                                <span class="name">${t.name}</span>
                                <span class="blurb">address</span>
                            </div>
                            <div class="offer-info-right">
                                <span class="price">$DB TBA</span>
                                <span class="fa icons">&#xf290&nbsp;&#xf083</span>
                            </div>
                        </div>
                    </div>
                </s:iterator>
            </div>
            <div id="offer-info-large" class="hidden">
                <div id="offer-image">
                    <img src="../../img/offer-img.jpg" />
                </div>
                <div id="offer-info">
                    <h2 id="offer-name"></h2>
                    <h2>Description</h2>
                    <p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat</p>
                </div>
                <a href="" id="show-results">Back to Results</a>
            </div>
        </div>
        <div id="package-info">
            <div id="package-header">
                <h2>Create your perfect holiday experience</h2>
            </div>

            <s:set var="size" value="cart.size"/>
            <s:if test="%{#size == 0}">
            <div id="package-contents" class="center">
                <h2>Nothing here yet!</h2>
                <h3>Add an offer from the left by<br />
                    <!--dragging it into this area or<br />-->
                    clicking the plus symbol at the bottom right</h3>
            </div>
            </s:if>
            <s:else>
            <div id="package-contents" class="center">

                <h2>PACKAGES HERE</h2>
                <s:iterator value="cart.experiences" var="e">
                    <div>
                        <span>${e.experience.name}</span>
                        <a href="edit-cart?method=remove&type=experience&id=${e.experience.id}"><span class="fa fa-remove" aria-hidden="true">
                            <span class="tooltiptext">Remove</span>
                        </span></a>
                    </div>
                </s:iterator>
                <s:iterator value="cart.hotels" var="h">
                    <div>
                        <span>${h.hotel.name}</span>
                        <a href="edit-cart?method=remove&type=hotel&id=${h.hotel.id}"><span class="fa fa-remove" aria-hidden="true">
                            <span class="tooltiptext">Remove</span>
                        </span></a>
                    </div>
                </s:iterator>
                <s:iterator value="cart.restaurants" var="r">
                    <div>
                        <span>${r.restaurant.name}</span>
                        <a href="edit-cart?method=remove&type=restaurant&id=${r.restaurant.id}"><span class="fa fa-remove" aria-hidden="true">
                            <span class="tooltiptext">Remove</span>
                        </span></a>
                    </div>
                </s:iterator>
                <s:iterator value="cart.transport" var="t">
                    <div>
                        <span>${t.transport.name}</span>
                        <a href="edit-cart?method=remove&type=transport&id=${t.transport.id}"><span class="fa fa-remove" aria-hidden="true">
                            <span class="tooltiptext">Remove</span>
                        </span></a>
                    </div>
                </s:iterator>
                <div></div>


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
            </s:else>
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
    $("#display-list").click(function() {
        $('#results').addClass('flex-col').removeClass('flex-row');
        $('.offer-tile').toggleClass('offer-list').toggleClass('offer-tile');
    });
    $("#display-tile").click(function() {
        $('#results').addClass('flex-row').removeClass('flex-col');
        $('.offer-list').toggleClass('offer-tile').toggleClass('offer-list');
    });
    $(".offer-list").on('click', function() {
        $('#results').addClass('hidden');
        $('#display-type').addClass('hidden');
        $('.offer-list').addClass('hidden');
        $('#offer-info-large').removeClass('hidden');
        $(this).find(".offer-info").find(".offer-info-left").find(".name").clone().appendTo('#offer-name');
    });
    $("#show-results").on('click', function() {
        $('#offer-info-large').addClass('hidden');
        $('#results').removeClass('hidden');
        $('#display-type').removeClass('hidden');
        $('.offer-list').removeClass('hidden');
    });
//    $(function () {
//        // jQuery UI Draggable
//        $(".draggable").draggable({
//            // brings the item back to its place when dragging is over
//            revert:true,
//            helper:"clone",
//            // once the dragging starts, we decrease the opactiy of other items
//            // Appending a class as we do that with CSS
//            drag:function () {
//                $(this).addClass("active");
//                $(this).closest(".draggable").addClass("active");
//            },
//            // removing the CSS classes once dragging is over.
//            stop:function () {
//                $(this).removeClass("active").closest(".draggable").removeClass("active");
//            }
//        });
//
//        // jQuery Ui Droppable
//        $("#package-contents").droppable({
//            // The class that will be appended to the to-be-dropped-element (basket)
//            activeClass:"active",
//            // The class that will be appended once we are hovering the to-be-dropped-element (basket)
//            hoverClass:"hover",
//            // The acceptance of the item once it touches the to-be-dropped-element basket
//            // For different values http://api.jqueryui.com/droppable/#option-tolerance
//            tolerance:"touch",
//            drop:function (event, ui) {
//                var basket = $(this),
//                    move = ui.draggable,
//                    itemId = basket.find("ul li[data-id='" + move.attr("data-id") + "']");
//                // To increase the value by +1 if the same item is already in the basket
//                if (itemId.html() != null) {
//                    itemId.find("input").val(parseInt(itemId.find("input").val()) + 1);
//                }
//                else {
//                    // Add the dragged item to the basket
//                    addBasket(basket, move);
//                    // Updating the quantity by +1" rather than adding it to the basket
//                    move.find("input").val(parseInt(move.find("input").val()) + 1);
//                }
//            }
//        });
//
//        // This function runs onc ean item is added to the basket
//        function addBasket(basket, move) {
//            basket.find("ul").append('<li data-id="' + move.attr("data-id") + '">'
//                + '<span class="name">' + move.find("h3").html() + '</span>'
//                + '<input class="count" value="1" type="text">'
//                + '<button class="delete">&#10005;</button>');
//        }
//        // The function that is triggered once delete button is pressed
//        $(".basket ul li button.delete").live("click", function () {
//            $(this).closest("li").remove();
//        });
//    });
//    $(".draggable").draggable({ cursor: "crosshair", revert: "invalid", scroll: "false", opacity: 0.8, helper: "clone"});
//    $("#package-contents").droppable({ accept: ".draggable",
//        drop: function(event, ui) {
//            console.log("drop");
//            $(this).removeClass("border").removeClass("over");
//            var dropped = ui.draggable;
//            var droppedOn = $(this);
//            $(dropped).detach().css({top: 0,left: 0}).appendTo(droppedOn);
//            if($('#package-contents>div').hasClass('draggable')) {
//                $("#package-contents > h2").addClass( "hidden" );
//                $("#package-contents > h3").addClass( "hidden" );
//            }
//            $("#package-contents:has(div)").addClass( "active" );
//        },
//        over: function(event, elem) {
//            $(this).addClass("over");
//            console.log("over");
//        },
//        out: function(event, elem) {
//            $(this).removeClass("over");
//        }
//    }).sortable();
//    $("#results").droppable({ accept: ".draggable",
//        drop: function(event, ui) {
//            console.log("drop");
//            $(this).removeClass("border").removeClass("over");
//            var dropped = ui.draggable;
//            var droppedOn = $(this);
//            $(dropped).detach().css({top: 0,left: 0}).appendTo(droppedOn);
//            $("#package-contents:not(:has(div))").removeClass( "active" );
//        }
//    });
</script>

</body>
</html>
