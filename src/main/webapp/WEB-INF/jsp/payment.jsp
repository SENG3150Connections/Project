<%--
payment.jsp
Author: Seb Brown

Description:
    The mock-payment page where an invoice is finalised by the user.
    It inclused the imported card.js for credit-card visualisation.
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
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
    your browser</a> to improve your experience.</p>
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

        <form action="/complete" method="post" id="form">
            <div class="inlineFlex">
                <%-- Personal info box --%>
                <div class="contentBox row1">
                    <span class="customerPageHeading">Personal Details:</span>
                    <br>
                    <p>To complete your order, please provide us with the following details.</p>
                    <br>
                    <label for="firstName">First name</label>
                    <input id="firstName" class="textField" type="text">
                    <label for="lastName">Last name</label>
                    <input id="lastName" class="textField" type="text">
                    <label for="email">Email address</label>

                    <input id="email" class="textField" type="text" value='<s:property value="#session.userEmail"></s:property> '>


                    <label for="phone">Phone number</label>
                    <input id="phone" class="textField" type="text">
                </div>

                <%-- Display the shopping cart contents --%>
                <div class="row1" style="padding-top: 10px;" >
                    <span class="customerPageHeading">Order Summary:</span>
                    <div class="tableDiv">
                        <table style="">
                            <tr> <th style="width: 80%; ">Item</th> <th style="width: 20%;">Price</th></tr>
                            <s:iterator value="cart.hotels" var="i">
                                <tr>
                                    <td>${i.name}</td><td>${i.price}</td>
                                </tr>
                            </s:iterator>
                            <s:iterator value="cart.experiences" var="i">
                                <tr>
                                    <td>${i.name}</td><td>${i.price}</td>
                                </tr>
                            </s:iterator>
                            <s:iterator value="cart.restaurants" var="i">
                                <tr>
                                    <td>${i.name}</td><td>${i.price}</td>
                                </tr>
                            </s:iterator>
                            <s:iterator value="cart.transport" var="i">
                                <tr>
                                    <td>${i.name}</td><td>${i.price}</td>
                                </tr>
                            </s:iterator>
                        </table>
                        <h3 style=" padding: 20px; text-align: right;">Total price: ${cart.price}</h3>

                    </div>
                </div>
            </div>

            <%-- Card.js input area --%>
            <div class="contentBox contentBox-grey " style="width: 100%;">
                <div class="card-wrapper inlineFlex" >
                    <div id="creditCardContainer" class="">
                        <span class="customerPageHeading">Payment:</span>

                        <br/>
                        <p>Please enter your credit card details in the fields below.</p>
                        <br/>

                        <!-- Library from: https://github.com/jessepollak/card -->
                        <form>
                            <input class="creditCardTextField" id="cardNumber" placeholder="Card number" type="text"
                                   name="number">
                            <input class="creditCardTextField" id="name" placeholder="Cardholder name" type="text"
                                   name="name"/>
                            <input class="creditCardTextField" id="time" placeholder="Expiry date" type="text"
                                   name="expiry"/>
                            <input class="creditCardTextField" id="cvc" placeholder="CVC" type="text" name="cvc"/>
                        </form>
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
            <div class="inlineFlex confirmDiv">
                <a href="/results" id="cancel">Cancel</a>
                <button type="submit" form="form" value="Submit">Pay Now</button>
            </div>
        </form>
    </div>
</main>
</body>
</html>
