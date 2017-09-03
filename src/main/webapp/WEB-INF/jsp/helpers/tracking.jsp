<%--
tracking.jsp
Author: Seb Brown

Description:
    A helper JSP to be included in another.
    This JSP simply includes the tags to link a page to Google Analytics.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                    (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-104523878-1', 'auto');
        ga('send', 'pageview');
    </script>
