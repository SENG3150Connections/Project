<%--
  Created by IntelliJ IDEA.
  User: seb
  Date: 14/8/17
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment</title>

    <script src="card/dist/card.js"></script>

</head>
<body>


<div class="col grey lighten-4 s8" style="padding: 30px;">

    <h3 class="center-align"> Enter Payment Information </h3>

    <form style="padding-top: 30px;">
        <div class="row">
            <div class="input-field col s6">
                <input id="first_name" type="text" class="validate">
                <label for="first_name" style="color: #000000">First Name</label>
            </div>
            <div class="input-field col s6">
                <input id="last_name" type="text" class="validate">
                <label for="last_name" style="color: #000000">Last Name</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <input id="email" type="email" class="validate">
                <label for="email" style="color: #000000">Email</label>
            </div>
        </div>

        <!-- Library from: https://github.com/jessepollak/card -->

        <div class="card-wrapper">

            <h5> Credit card details: </h5>
            <form>
                <div class="input-field col s6">
                    <input id="cardNumber" type="text"  name="number">
                    <label for="cardNumber" style="color: #000000">Card Number</label>
                </div>
                <div class="input-field col s6">
                    <input id="name" type="text"  name="name"/>
                    <label for="name" style="color: #000000" >Name on card</label>
                </div>

                <div class="input-field col s6">
                    <input id="time" type="text"   name="expiry"/>
                    <label for="time" style="color: #000000" >Expiry Date</label>

                </div>

                <div class="input-field col s6">
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


        <br>
        <br>

        <a href="customise" class="btn tooltipped waves-effect waves-light col s6" data-position="top" data-delay="50" data-tooltip="Cancel payment">Return</a>
        <a href="complete" class="waves-effect waves-light btn col s6">
            Pay Now
        </a>

    </form>

</div>


</body>
</html>
