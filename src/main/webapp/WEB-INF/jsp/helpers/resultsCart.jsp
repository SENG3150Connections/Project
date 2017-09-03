<%--
resultsCart.jsp
Author: Scott Walker

Description:
    A helper JSP to be included in another.
    This produces the items in the shopping cart on the results page.
    They feature:
    - Tick or cross if they're ready to be processed
    - Name of item
    - An edit button
    - A remove from cart button
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
    <%-- Display appropriate symbol showing if this item is read to be saved --%>
    <s:if test="%{#c.ready == true}">
        <span class="fa fa-check" style="color: #4ab64a"></span> <%-- Green tick --%>
    </s:if>
    <s:else>
        <span class="fa fa-remove" style="color: #db0000"></span> <%-- Red cross --%>
    </s:else>

    <%-- Display name of item, and then the edit/remove buttons --%>
    <span>${c.name}</span>
    <a href="update-${type}?edit&cartIndex=${entry.index}"><span class="fa fa-edit" aria-hidden="true">
        <span class="tooltiptext">Edit</span>
    </span></a>
    <a href="edit-cart?method=remove&type=${type}&id=${c.id}"><span class="fa fa-remove" aria-hidden="true">
        <span class="tooltiptext">Remove</span>
    </span></a>
</div>
