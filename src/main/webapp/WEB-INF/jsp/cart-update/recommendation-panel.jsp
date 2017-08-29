<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:if test="%{recommendations.recommendedItem == 0}">
    <s:iterator value="recommendations.hotels" var="rec">
        <div class="offer-list recommendation">
            <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
            <a href="edit-cart?method=add&type=hotel&id=${rec.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                                <span class="tooltiptext">Add to package</span>
                            </span></a>
            <div class="offer-images">
                <div class="offer-img-initial" style="min-height: 150px;">
                    <img src='../../img/hotels/hotel${(rec.id)%17}.jpg' class="cover"/>
                </div>
                <div class="offer-img-item">
                    <img src='../../img/hotels/hotel${(rec.id + 10)%17}.jpg' class="cover"/>
                    <img src='../../img/hotels/hotel${(rec.id + 16)%17}.jpg' class="cover"/>
                </div>
            </div>
            <div class="offer-info">
                <div class="offer-info-left">
                    <span class="name">${rec.name}</span>
                    <span class="blurb">${rec.description}</span>
                </div>
            </div>
        </div>
    </s:iterator>
</s:if>
<s:if test="%{recommendations.recommendedItem == 1}">
    <s:iterator value="recommendations.experiences" var="rec">
        <div class="offer-list recommendation">
            <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
            <a href="edit-cart?method=add&type=experience&id=${rec.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                                <span class="tooltiptext">Add to package</span>
                            </span></a>
            <div class="offer-images">
                <div class="offer-img-initial" style="min-height: 150px;">
                    <img src='../../img/experiences/experience${(rec.id)%17}.jpg' class="cover"/>
                </div>
                <div class="offer-img-item">
                    <img src='../../img/hotels/hotel${(rec.id + 10)%17}.jpg' class="cover"/>
                    <img src='../../img/hotels/hotel${(rec.id + 16)%17}.jpg' class="cover"/>
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
</s:if>
<s:if test="%{recommendations.recommendedItem == 2}">
    <s:iterator value="recommendations.restaurants" var="rec">
        <div class="offer-list recommendation">
            <span class="fa fa-heart-o offer-heart" aria-hidden="true"></span>
            <a href="edit-cart?method=add&type=restaurant&id=${rec.id}"><span class="fa fa-plus offer-add" aria-hidden="true">
                                <span class="tooltiptext">Add to package</span>
                            </span></a>
            <div class="offer-images">
                <div class="offer-img-initial" style="min-height: 150px;">
                    <img src='../../img/restaurants/restaurant${(rec.id)%17}.jpg' class="cover"/>
                </div>
                <div class="offer-img-item">
                    <img src='../../img/hotels/hotel${(rec.id + 10)%17}.jpg' class="cover"/>
                    <img src='../../img/hotels/hotel${(rec.id + 16)%17}.jpg' class="cover"/>
                </div>
            </div>
            <div class="offer-info">
                <div class="offer-info-left">
                    <span class="name">${rec.name}</span>
                    <span class="blurb">${rec.description}</span>
                </div>
                <div class="offer-info-right">
                </div>
            </div>
        </div>
    </s:iterator>
</s:if>