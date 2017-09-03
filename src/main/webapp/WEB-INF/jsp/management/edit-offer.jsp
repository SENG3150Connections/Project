<%--
edit-offer.jsp
Author: Harry Barden

Description:
    The edit offer page. Details are pre-loaded in for ease persistence

    The sidebar is dynamically loaded in via jsp:include at the start of the body tag.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
    <jsp:include page="static-head.jsp"/>
    <title>Management - Edit Offer</title>
</head>
<body>
<!-- Sidebar -->
<div id="sidebar" class="sidebar">
    <jsp:include page="management-sidebar-nav.jsp" />
</div>

<!-- Main Body -->
<div class="management-mainbody">
    <div class="menuContent">
        <div class="create-offer">
            <div class="title">
                <label class="prev-dir">Manage Products/</label><label class="current-dir"> Edit Offer</label>

                <div class="pull-right">
                    <button class="btn btn-default" href="managementPortal">Cancel</button>
                    <button class="btn btn-default">Preview</button>
                    <button class="btn btn-info">Save Product</button>
                </div>
            </div>
            <div class="row">
                <form>
                    <!-- Main container -->
                    <div class="col-md-8">
                        <div class="management-container">
                            <div class="form-group float-label-control">
                                <label for="">Title</label>
                                <input type="text" name="title" class="form-control" placeholder="Product Title" value="${hotel.name}"/>
                            </div>

                            <div class="form-group float-label-control">
                                <label for="">Description - Rich text editor</label>
                                <textarea class="form-control" placeholder="Product Description" rows="5">${hotel.description}</textarea>
                            </div>
                        </div>

                        <div class="management-container">
                            <label for="imageInput">Images</label>
                            <input type="file" class="form-control-file" id="imageInput" aria-describedby="fileHelp">
                            <small id="fileHelp" class="form-text text-muted">Upload images of the product to be displayed.</small>
                        </div>
                    </div>

                    <!-- Sidebar - Right -->
                    <div class="col-md-4">
                        <div class="management-sidebar">
                            <label class="heading">Visibility</label>
                            <hr/>

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
                                    <div class="material-switch pull-right">
                                        <input id="delayedRelease" name="delayedRelease" type="checkbox"/>
                                        <label for="delayedRelease" class="label-info"></label>
                                    </div>
                                </li>
                            </ul>
                        </div>

                        <div class="management-sidebar">
                            <label class="heading">Organisation</label>
                            <hr></hr>

                            <div class="form-group float-label-control">
                                <label for="">Price</label>
                                <input type="text" name="title" class="form-control" placeholder="$###.##"/>
                            </div>

                            <div class="form-group">
                                <label for="subject">Category</label>
                                <select id="subject" name="subject" class="form-control" required="required">
                                    <option value="na" selected="">Choose One:</option>
                                    <option value="accomidation">Accomidation</option>
                                    <option value="event">Event</option>
                                    <option value="food">Food</option>
                                </select>
                            </div>

                            <div class="form-group float-label-control">
                                <label for="">Location</label>
                                <input type="text" name="title" class="form-control" placeholder="42 Wallaby Way Sydney" value="${hotel.address}"/>
                            </div>

                            <div class="form-group float-label-control">
                                <label for="">Tags</label>
                                <input type="text" name="title" class="form-control" placeholder="Tag 1, Tag 2, Tag 3, Etc"/>
                            </div>

                            <a class="btn btn-danger" href="#">
                                <i class="fa fa-trash-o fa-lg"></i> Delete
                            </a>

                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
