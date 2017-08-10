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
            <div class="title">
                <label class="prev-dir">Manage Products/</label><label class="current-dir"> Add Offer</label>

                <div class="pull-right">
                    <button class="btn btn-default" onclick="loadSection('management-display-products', this)">Cancel</button>
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
                                <input type="text" name="title" class="form-control" placeholder="Product Title"></input>
                            </div>

                            <div class="form-group float-label-control">
                                <label for="">Description - Rich text editor</label>
                                <textarea class="form-control" placeholder="Product Description" rows="5"></textarea>
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
                                <input type="text" name="title" class="form-control" placeholder="$###.##"></input>
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
                                <input type="text" name="title" class="form-control" placeholder="42 Wallaby Way Sydney "></input>
                            </div>

                            <div class="form-group float-label-control">
                                <label for="">Tags</label>
                                <input type="text" name="title" class="form-control" placeholder="Tag 1, Tag 2, Tag 3, Etc"></input>
                            </div>

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

