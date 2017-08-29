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
    <link href="css/management-card.css" rel="stylesheet">
    
    <!-- CSS -->
    <link href="css/sidebar-nav.css" rel="stylesheet">
    <link href="css/normalize.css" rel="stylesheet">
    
    <!-- JS -->  
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    
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
                    <label class="prev-dir">Manage Products/</label><label class="current-dir"> Add & Edit Offers</label>
                </div>
                <div class="row">
                    <form>
                        <!-- Main container -->
                        <div class="col-md-8">
                            <div class="management-container">

                                <div class="row">
                                    <div class="card-container col-sm-6 col-md-4 col-lg-3 mt-4" onclick="location.href='createOffer';">
                                        <div class="card">
                                            <img class="card-img-top" src="img/new-form.png">
                                            <div class="card-block">
                                                <h5 class="text-bold">Create New:</h5>
                                            </div>
                                        </div>
                                    </div>

                                    <s:iterator value="hotels" var="hotel">
                                        <div id="${hotel.id}" class="card-container col-sm-6 col-md-4 col-lg-3 mt-4" onclick="location.href='editOffer?id=${hotel.id}';">
                                            <div class="card">
                                                <img id="${hotel.name}" class="card-img-top" src="img/hotels/hotel${hotel.id % 17}.jpg">
                                                <div class="card-block">
                                                    <h5 class="text-bold">${hotel.name}</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </s:iterator>

                                    <s:iterator value="restaurants" var="restaurant">
                                        <div id="${restaurant.id}" class="card-container col-sm-6 col-md-4 col-lg-3 mt-4">
                                            <div class="card">
                                                <img id="${restaurant.name}" class="card-img-top" src="img/restaurants/restaurant${restaurant.id % 17}.jpg">
                                                <div class="card-block">
                                                    <h5 class="text-bold">${restaurant.name}</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </s:iterator>

                                    <s:iterator value="experiences" var="experience">
                                        <div id="${experience.id}" class="card-container col-sm-6 col-md-4 col-lg-3 mt-4">
                                            <div class="card">
                                                <img id="${experience.name}" class="card-img-top" src="img/experiences/experience${experience.id % 17}.jpg">
                                                <div class="card-block">
                                                    <h5 class="text-bold">${experience.name}</h5>
                                                </div>
                                            </div>
                                        </div>
                                    </s:iterator>
                                </div>

                            </div>
                        </div>

                        <!-- Sidebar - Right -->
                        <div class="col-md-4">
                            <div class="management-sidebar">
                                <label class="heading">Settings</label>
                                <hr></hr>

                                <!-- List group -->
                                <div class="form-group">
                                    <label for="sorting">Sort By:</label>
                                    <select id="sorting" name="subject" class="form-control" required="required">
                                        <option value="na" selected="">Choose One:</option>
                                        <option value="accomidation">Alphabetical</option>
                                        <option value="event">Most Popular</option>
                                        <option value="food">Recently Added</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="category">Category</label>
                                    <select id="category" name="subject" class="form-control" required="required">
                                        <option value="na" selected="">Choose One:</option>
                                        <option value="accomidation">Accomidation</option>
                                        <option value="event">Event</option>
                                        <option value="food">Food</option>
                                    </select>
                                </div>

                                <label>Visibility: </label>
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        Display Publicly Visible Products
                                        <div class="material-switch pull-right">
                                            <input id="publicProducts" name="publicProducts" type="checkbox"/>
                                            <label for="publicProducts" class="label-info"></label>
                                        </div>
                                    </li>
                                    <li class="list-group-item">
                                        Display Publically Hidden Products
                                        <div class="material-switch pull-right">
                                            <input id="hiddenProducts" name="hiddenProducts" type="checkbox"/>
                                            <label for="hiddenProducts" class="label-info"></label>
                                        </div>
                                    </li>
                                </ul>

                                <div class="pull-right">
                                    <a class="btn btn-info">Update</a>
                                </div><br><br>
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