
<div class="create-hotel">
    <form action="/submitOffer">
        <div class="title">
            <label class="prev-dir">Manage Products/</label><label class="current-dir"> Add Hotel</label>

            <div class="pull-right">
                <a class="btn btn-default" href="displayProducts">Cancel</a>
                <a class="btn btn-default">Preview</a>
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

                <div class="management-container">
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

                    <div class="form-group float-label-control">
                        <label for="">Tags</label>
                        <input type="text" name="tags" class="form-control" placeholder="Tag 1, Tag 2, Tag 3, Etc"></input>
                    </div>

                    <div class="form-group float-label-control">
                        <label for="">Location</label>
                        <input type="text" name="location" class="form-control" placeholder="42 Wallaby Way Sydney "></input>
                    </div>

                    <div class="form-group float-label-control">
                        <label for="">Latitude</label>
                        <input type="text" name="latitude" class="form-control" placeholder="-##.######"></input>
                    </div>

                    <div class="form-group float-label-control">
                        <label for="">Longitude</label>
                        <input type="text" name="longitude" class="form-control" placeholder="###.######"></input>
                    </div>

                </div>
            </div>

        </div>
    </form>
</div>