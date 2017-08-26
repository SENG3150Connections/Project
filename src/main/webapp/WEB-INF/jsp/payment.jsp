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
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../css/normalize.css">
    <link rel="stylesheet" href="../../css/main.css">
    <link rel="stylesheet" href="../../css/pikaday.css">
    <link rel="stylesheet" href="../../css/payment.css">

    <script src="../../card/dist/card.js"></script>


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
            <div id="homepage-image" style="height: 96px; color: white">
                <div class="bg-cover"></div>
                <div class="cover-overlay"></div>
            </div>
            <div class="homepage-logo" style="margin-left: 0;">
                <h1><a style="color: white;" href="/home">NewcastleConnections</a></h1>
            </div>
            <div class="homepage-social">
                <a href="#"><img src="../../img/fb-social.png" class="pointer hover"/></a>
                <a href="#"><img src="../../img/tw-social.png" class="pointer hover"/></a>
                <a href="#"><img src="../../img/ig-social.png" class="pointer hover"/></a>
            </div>
            <s:if test="%{#session.userNickname == null}">
                <div class="homepage-login">
                    <a style="color: white;" href="/login">Login</a>
                </div>
            </s:if>
            <s:else>
                <div class="homepage-login">
                    <a style="color: white;" href="/customerPortal">Your Account</a>
                </div>
                <div class="homepage-login">
                    <a style="color: white;" href="/logout">Logout</a>
                </div>
            </s:else>
            <div class="homepage-help">
                <a style="color: white;" href="#">Help</a>
            </div>
        </div>
    </header>


    <div class="paymentPageBody">

        <form>
            <div class="contentBox">
                <span class="customerPageHeading">Personal Details:</span>
                <label for="firstName">First name</label>
                <input id="firstName" class="textField" type="text">
                <label for="lastName">Last name</label>
                <input id="lastName" type="text">
            </div>

            <div class="contentBox contentBox-grey">
                <span class="customerPageHeading">Contact Details:</span>
                <label for="email">Email address</label>
                <input id="email" class="textField" type="text">
                <label for="phone">phone number</label>
                <input id="phone" type="text">
            </div>

            <div class="contentBox">
                <span class="customerPageHeading">Payment Method:</span>

                <!-- Library from: https://github.com/jessepollak/card -->

                <div class="card-wrapper">
                    <h5> Credit card details: </h5>
                    <form>
                        <div>
                            <input id="cardNumber" type="text"  name="number">
                            <label for="cardNumber" style="color: #000000">Card Number</label>
                        </div>
                        <div>
                            <input id="name" type="text"  name="name"/>
                            <label for="name" style="color: #000000" >Name on card</label>
                        </div>
                        <div>
                            <input id="time" type="text"   name="expiry"/>
                            <label for="time" style="color: #000000" >Expiry Date</label>
                        </div>
                        <div>
                            <input id="cvc" type="text"  name="cvc"/>
                            <label for="cvc" style="color: #000000" >CVC</label>
                        </div>
                    </form>
                    <div style="padding-top: 150px;">
                    </div>
                    <script>

                        var card = new Card({
                            form: 'form',
                            container: '.card-wrapper',

                            placeholders: {
                                number: '**** **** **** ****',
                                name: 'Arya Stark',
                                expiry: '**/****',
                                cvc: '***'
                            }
                        });
                    </script>
                </div>
            </div>
        </form>
    </div>

</main>



</body>
</html>
