<%--
header.jsp
Author: Tim Pitts / Scott Walker

Description:
    A helper JSP to be included in another.
    This JSP simply includes the header for other pages
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<header id="header-container">
    <div class="header">
        <div class="homepage-menu">
            <p class="fa" style="cursor: pointer;">&#xf0c9;</p>
        </div>
        <div class="homepage-logo">
            <h1><a href="/home">NewcastleConnections</a></h1>
        </div>
        <div class="homepage-social ">
            <a href="https://www.facebook.com/newcastleconnections/"><img src="../../img/fb-social.png" class="pointer hover"/></a>
            <a href="#"><img src="../../img/tw-social.png" class="pointer hover"/></a>
            <a href="https://www.instagram.com/newcastleconnections/"><img src="../../img/ig-social.png" class="pointer hover"/></a>
        </div>

        <%-- If user is not logged in, show login panel insead --%>
        <s:if test="%{#session.userNickname == null}">
            <div class="homepage-login">
                <a href="/login">Login</a>
            </div>
        </s:if>
        <s:else>
            <div class="homepage-login">
                <a href="/customerPortal">Your Account</a>
            </div>
            <div class="homepage-login">
                <a href="/logout">Logout</a>
            </div>
        </s:else>
    </div>
</header>