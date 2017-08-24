<%--
  Created by IntelliJ IDEA.
  User: Harry
  Date: 13/08/2017
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Days Left</title>
    <style>
        h1, p {
            text-align: center;
            font-size: 60px;
        }

        a {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
        }

        .center {
            margin: auto;
            width: 20%;
            border: 3px solid green;
            padding: 10px;
        }
    </style>
</head>
<body>
    <h1>Time left until the project is due!</h1>
    <p id="countdown"></p>

    <div class="center">
        <a href="home">Home</a>
        <a href="managementPortal">Management Portal</a>
    </div>

    <script>
        // Set the time we're counting down to
        var countDownDate = new Date("Aug 27, 2017 18:00:00").getTime();

        // Update the count down every 1 second
        var x = setInterval(function() {

            // Get todays time and time
            var now = new Date().getTime();

            // Find the distance between now an the count down time
            var distance = countDownDate - now;

            // Time calculations for days, hours, minutes and seconds
            var days = Math.floor(distance / (1000 * 60 * 60 * 24));
            var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
            var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
            var seconds = Math.floor((distance % (1000 * 60)) / 1000);

            // Output the result in an element with id="demo"
            document.getElementById("countdown").innerHTML = days + "d " + hours + "h "
                + minutes + "m " + seconds + "s ";

            // If the count down is over, write some text
            if (distance < 0) {
                clearInterval(x);
                document.getElementById("countdown").innerHTML = "EXPIRED";
            }
        }, 1000);
    </script>

</body>
</html>
