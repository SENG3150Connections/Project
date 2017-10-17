<%--
create-offer-selection.jsp
Author: Harry Barden

Description:
    This JSP is loaded into create-offer.jsp when no selection method is supplied.

    The sidebar is dynamically loaded in via jsp:include at the start of the body tag.
--%>

<div class="create-offer-selection">
    <div class="title">
        <label class="prev-dir">Choose a product to create</label>

        <div class="pull-right">
            <button class="btn btn-default" href="displayProducts">Cancel</button>
        </div>
    </div>
    <div class="management-container">
        <div class="row">

            <!-- Show create hotel button -->
            <div class="card-container col-sm-6 col-md-4 col-lg-3 mt-4" onclick="location.href='createOffer?offerType=hotel';">
                <div class="card">
                    <img class="card-img-top" src="img/new-form.png">
                    <div class="card-block">
                        <h5 class="text-bold">Create Hotel</h5>
                    </div>
                </div>
            </div>

            <!-- Show create restaurant button -->
            <div class="card-container col-sm-6 col-md-4 col-lg-3 mt-4" onclick="location.href='createOffer?offerType=restaurant';">
                <div class="card">
                    <img class="card-img-top" src="img/new-form.png">
                    <div class="card-block">
                        <h5 class="text-bold">Create Restaurant</h5>
                    </div>
                </div>
            </div>

            <!-- Show create experience button -->
            <div class="card-container col-sm-6 col-md-4 col-lg-3 mt-4" onclick="location.href='createOffer?offerType=experience';">
                <div class="card">
                    <img class="card-img-top" src="img/new-form.png">
                    <div class="card-block">
                        <h5 class="text-bold">Create Experience</h5>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>


