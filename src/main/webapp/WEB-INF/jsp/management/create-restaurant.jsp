<%--
create-restaurant.jsp
Author: Harry Barden

Description:
    This JSP displays the creation page for a new hotel package.
    This page is loaded into create-offer.jsp

    The sidebar is dynamically loaded in via jsp:include at the start of the body tag.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="create-offer">
    <form action="/submitOffer">
        <div class="title">
            <label class="prev-dir">Manage Products/</label><label class="current-dir"> Add Restaurant</label>

            <div class="pull-right">
                <button class="btn btn-default" onclick="loadSection('management-display-products', this)">Cancel</button>
                <button class="btn btn-default">Preview</button>
                <input type="submit" class="btn btn-info" value="Save Product"/>
            </div>
        </div>
        <div class="row">
            <!-- Main container -->
            <div class="col-md-8">
                <div class="management-container">
                    <div class="form-group float-label-control">
                        <label for="">Title</label>
                        <input type="text" name="name" class="form-control" placeholder="Product Title"/>
                    </div>

                    <div class="form-group float-label-control">
                        <label for="">Description - Rich text editor</label>
                        <textarea name="description" class="form-control" placeholder="Product Description" rows="5"></textarea>
                    </div>
                </div>

                <div class="management-container">
                    <label for="imageInput">Images</label>
                    <input name="image" type="file" class="form-control-file" id="imageInput" aria-describedby="fileHelp">
                    <small id="fileHelp" class="form-text text-muted">Upload images of the product to be displayed.</small>
                </div>
            </div>

            <!-- Sidebar - Right -->
            <div class="col-md-4">
                <div class="management-sidebar">
                    <label class="heading">Visibility</label>
                    <hr></hr>

                    <!-- List group -->
                    <ul class="list-group">
                        <li class="list-group-item">
                            Publicly Visible
                            <div class="material-switch pull-right">
                                <input id="publiclyVisible" name="publiclyVisible" type="checkbox"/>
                                <label for="publiclyVisible" class="label-info"></label>
                            </div>
                        </li>
                        <li class="list-group-item">
                            Release on Date
                            <div class="delayedRelease material-switch pull-right">
                                <input id="delayedRelease" name="delayedRelease" type="checkbox">
                                <label for="delayedRelease" class="label-info"></label>
                            </div>
                            <div class="delayedRelease form-group float-label-control">
                                <br>
                                <input name="delayedReleaseDate" class="form-control" placeholder="Release Date" type="text">
                            </div>
                        </li>
                    </ul>
                </div>

                <div class="management-sidebar">
                    <label class="heading">Organisation</label>
                    <hr></hr>

                    <div class="form-group float-label-control">
                        <label for="">Price</label>
                        <input type="text" name="price" class="form-control" placeholder="$###.##"/>
                    </div>

                    <div class="form-group">
                        <label for="subject">Category</label>
                        <select id="subject" name="type" class="form-control" required="required">
                            <option value="na" selected="">Choose One:</option>
                            <option value="hotel">Hotel</option>
                            <option value="experience">Experience</option>
                            <option value="restaurant">Restaurant</option>
                        </select>
                    </div>

                    <div class="form-group float-label-control">
                        <label for="">Location</label>
                        <input type="text" name="address" class="form-control" placeholder="42 Wallaby Way Sydney "/>
                    </div>

                    <div class="form-group float-label-control">
                        <label for="">Tags</label>
                        <input type="text" name="tags" class="form-control" placeholder="Tag 1, Tag 2, Tag 3, Etc"/>
                    </div>

                </div>


                <div class="management-sidebar">
                    <label class="heading">Contact</label>
                    <hr></hr>

                    <div class="form-group float-label-control">
                        <label for="">Contact Number</label>
                        <input type="text" name="contact" class="form-control" placeholder="0412 345 678"/>
                    </div>

                    <div class="form-group float-label-control">
                        <label for="">Contact Email</label>
                        <input type="text" name="email" class="form-control" placeholder="example@domain.com"/>
                    </div>

                    <div class="form-group float-label-control">
                        <label for="">Website</label>
                        <input type="text" name="website" class="form-control" placeholder="www.example.com"/>
                    </div>

                </div>
            </div>

        </div>
    </form>
</div>
