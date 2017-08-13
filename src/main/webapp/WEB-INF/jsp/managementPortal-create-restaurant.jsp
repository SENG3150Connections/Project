<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Management Portal</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/managementPortal.css" rel="stylesheet">

    <!-- CSS -->
    <link href="css/sidebar-nav.css" rel="stylesheet">
    <link href="css/normalize.css" rel="stylesheet">

    <!-- JS -->
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="js/management-loadContent.js"></script>

    <!-- FONTS -->
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">


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
            <form action="/submitOffer">
                <div class="title">
                    <label class="prev-dir">Manage Products/</label><label class="current-dir"> Add Restaurant</label>

                    <div class="pull-right">
                        <button class="btn btn-default" onclick="loadSection('management-display-products', this)">Cancel</button>
                        <button class="btn btn-default">Preview</button>
                        <input type="submit" class="btn btn-info" value="Save Product"></input>
                    </div>
                </div>
                <div class="row">
                    <!-- Main container -->
                    <div class="col-md-8">
                        <div class="management-container">
                            <div class="form-group float-label-control">
                                <label for="">Title</label>
                                <input type="text" name="name" class="form-control" placeholder="Product Title"></input>
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
                                        <input id="publiclyVisible" name="publiclyVisible" type="checkbox"></input>
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
                                <input type="text" name="price" class="form-control" placeholder="$###.##"></input>
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
                                <input type="text" name="address" class="form-control" placeholder="42 Wallaby Way Sydney "></input>
                            </div>

                            <div class="form-group float-label-control">
                                <label for="">Tags</label>
                                <input type="text" name="tags" class="form-control" placeholder="Tag 1, Tag 2, Tag 3, Etc"></input>
                            </div>

                        </div>


                        <div class="management-sidebar">
                            <label class="heading">Contact</label>
                            <hr></hr>

                            <div class="form-group float-label-control">
                                <label for="">Contact Number</label>
                                <input type="text" name="contact" class="form-control" placeholder="0412 345 678"></input>
                            </div>

                            <div class="form-group float-label-control">
                                <label for="">Contact Email</label>
                                <input type="text" name="email" class="form-control" placeholder="example@domain.com"></input>
                            </div>

                            <div class="form-group float-label-control">
                                <label for="">Website</label>
                                <input type="text" name="website" class="form-control" placeholder="www.example.com"></input>
                            </div>

                        </div>
                    </div>

                </div>
            </form>
        </div>
    </div>
</div>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>

