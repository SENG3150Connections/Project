<%--
  Created by IntelliJ IDEA.
  User: Scott
  Date: 25/08/2017
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>${c.name}</span>
    <a href="update-${type}?edit&cartIndex=${entry.index}"><span class="fa fa-edit" aria-hidden="true">
        <span class="tooltiptext">Edit</span>
    </span></a>
    <a href="edit-cart?method=remove&type=${type}&id=${c.id}"><span class="fa fa-remove" aria-hidden="true">
        <span class="tooltiptext">Remove</span>
    </span></a>
</div>