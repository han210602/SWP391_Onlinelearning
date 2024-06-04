<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Categories List</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="assets/css/styleMC.css">
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();

                // Open modal and set data
                $('.view').click(function () {
                    var name = $(this).closest('tr').find('td:nth-child(2)').text();
                    var description = $(this).closest('tr').find('td:nth-child(3)').text();
                    $('#categoryName').text(name);
                    $('#categoryDescription').text(description);
                    $('#viewprofile').modal('show');
                });
            });
        </script>
    </head>
    <body>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-8"><h2>Category <b>Details</b></h2></div>
                            <div class="col-sm-8" class="dataTables_length">
                                <label>Show
                                    <select name="num" onchange="this.form.submit()">
                                        <option value="10">10</option>
                                        <option value="25">25</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                    </select> entries
                                </label>
                            </div>
                            <div class="col-sm-4">
                                <div class="search-box">
                                    <i class="material-icons">&#xE8B6;</i>
                                    <input type="text" class="form-control" placeholder="Search&hellip;">
                                </div>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Name <i class="fa fa-sort"></i></th>
                                <th>Description</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listC}" var="o">
                                <tr>
                                    <td>${o.id}</td>
                                    <td>${o.name}</td>
                                    <td>${o.description}</td>
                                    <td>
                                        <a href="#" class="view" data-toggle="tooltip" title="View"><i style="color: blue" class="material-icons">&#128065;</i></a>
                                        <a href="managecategory" class="add" title="Add" data-toggle="tooltip"><i style="color: red" class="material-icons">&plus;</i></a>
                                        <a href="managecategory?id=${o.id}" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>       
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="clearfix">
                        <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                        <ul class="pagination">
                            <li class="page-item disabled"><a href="#"><i class="fa fa-angle-double-left"></i></a></li>
                            <li class="page-item active"><a href="#" class="page-link">1</a></li>
                            <li class="page-item"><a href="#" class="page-link">2</a></li>
                            <li class="page-item"><a href="#" class="page-link">3</a></li>
                            <li class="page-item"><a href="#" class="page-link">4</a></li>
                            <li class="page-item"><a href="#" class="page-link">5</a></li>
                            <li class="page-item"><a href="#" class="page-link"><i class="fa fa-angle-double-right"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>  
        </div> 
        <!-- Profile Start -->
        <div class="modal fade" id="viewprofile" tabindex="-1" aria-labelledby="exampleModalLabel1" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header border-bottom p-3">
                        <h5 class="modal-title" id="exampleModalLabel1">Category</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body p-3 pt-4">
                        <div>
                            <h5 class="category-name" id="categoryName">Tên Danh M?c</h5>
                            <p class="category-description" id="categoryDescription">?ây là ph?n mô t? chi ti?t v? danh m?c. Nó cung c?p thông tin và b?i c?nh c?n thi?t.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Profile End -->
    </body>
</html>
