<%--
header.jsp
Author: Tim Pitts / Scott Walker

Description:
    A helper JSP to be included in another.
    This JSP simply includes the footer for other pages
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<footer id="footer-container">
    <div class="container" style="height: 250px; flex-direction: column;justify-content: center;align-items: center">
        <div>
            <div class="homepage-social ">
                <a href="https://www.facebook.com/newcastleconnections/"><img src="../../img/fb-social.png" class="pointer hover"/></a>
                <a href="#"><img src="../../img/tw-social.png" class="pointer hover"/></a>
                <a href="https://www.instagram.com/newcastleconnections/"><img src="../../img/ig-social.png" class="pointer hover"/></a>
            </div>
        </div>
        <p id="terms-and-conditions">
            Use of this Web site constitutes acceptance of the Newcastle Connections Terms and Conditions and Privacy Policy</a>.
        </p>
        <p id="copyright">
            © Copyright 2017 – Newcastle Connections.
        </p>
    </div>
</footer>
