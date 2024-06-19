<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/courses.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:10:19 GMT -->
    <head>

        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assetsAdmin/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assetsAdmin/css/assets.css">
        <link rel="stylesheet" type="text/css" href="assetsAdmin/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assetsAdmin/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assetsAdmin/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assetsAdmin/css/style.css">
        <link rel="stylesheet" type="text/css" href="assetsAdmin/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assetsAdmin/css/color/color-1.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.css">
        <style>
            .error{
                color: red;
            }
        </style>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <header class="ttr-header">
            <div class="ttr-header-wrapper">
                <!--sidebar menu toggler start -->
                <div class="ttr-toggle-sidebar ttr-material-button">
                    <i class="ti-close ttr-open-icon"></i>
                    <i class="ti-menu ttr-close-icon"></i>
                </div>
                <!--sidebar menu toggler end -->
                <!--logo start -->
                <div class="ttr-logo-box">
                    <div>
                        <a href="index.html" class="ttr-logo">
                            <img alt="" class="ttr-logo-mobile" src="assetsAdmin/images/logo-mobile.png" width="30" height="30">
                            <img alt="" class="ttr-logo-desktop" src="assetsAdmin/images/logo-white.png" width="160" height="27">
                        </a>
                    </div>
                </div>
                <!--logo end -->
                <div class="ttr-header-menu">
                    <!-- header left menu start -->
                    <ul class="ttr-header-navigation">
                        <li>
                            <a href="../index.html" class="ttr-material-button ttr-submenu-toggle">HOME</a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle">QUICK MENU <i class="fa fa-angle-down"></i></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="../courses.html">Our Courses</a></li>
                                    <li><a href="../event.html">New Event</a></li>
                                    <li><a href="../membership.html">Membership</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                    <!-- header left menu end -->
                </div>
                <div class="ttr-header-right ttr-with-seperator">
                    <!-- header right menu start -->
                    <ul class="ttr-header-navigation">
                        <li>
                            <a href="#" class="ttr-material-button ttr-search-toggle"><i class="fa fa-search"></i></a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle"><i class="fa fa-bell"></i></a>
                            <div class="ttr-header-submenu noti-menu">
                                <div class="ttr-notify-header">
                                    <span class="ttr-notify-text-top">9 New</span>
                                    <span class="ttr-notify-text">User Notifications</span>
                                </div>
                                <div class="noti-box-list">
                                    <ul>
                                        <li>
                                            <span class="notification-icon dashbg-gray">
                                                <i class="fa fa-check"></i>
                                            </span>
                                            <span class="notification-text">
                                                <span>Sneha Jogi</span> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 02:14</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-yellow">
                                                <i class="fa fa-shopping-cart"></i>
                                            </span>
                                            <span class="notification-text">
                                                <a href="#">Your order is placed</a> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 7 Min</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-red">
                                                <i class="fa fa-bullhorn"></i>
                                            </span>
                                            <span class="notification-text">
                                                <span>Your item is shipped</span> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 2 May</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-green">
                                                <i class="fa fa-comments-o"></i>
                                            </span>
                                            <span class="notification-text">
                                                <a href="#">Sneha Jogi</a> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 14 July</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-primary">
                                                <i class="fa fa-file-word-o"></i>
                                            </span>
                                            <span class="notification-text">
                                                <span>Sneha Jogi</span> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 15 Min</span>
                                            </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button ttr-submenu-toggle"><span class="ttr-user-avatar"><img alt="" src="assetsAdmin/images/testimonials/pic3.jpg" width="32" height="32"></span></a>
                            <div class="ttr-header-submenu">
                                <ul>
                                    <li><a href="user-profile.html">My profile</a></li>
                                    <li><a href="list-view-calendar.html">Activity</a></li>
                                    <li><a href="mailbox.html">Messages</a></li>
                                    <li><a href="../login.html">Logout</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="ttr-hide-on-mobile">
                            <a href="#" class="ttr-material-button"><i class="ti-layout-grid3-alt"></i></a>
                            <div class="ttr-header-submenu ttr-extra-menu">
                                <a href="#">
                                    <i class="fa fa-music"></i>
                                    <span>Musics</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-youtube-play"></i>
                                    <span>Videos</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-envelope"></i>
                                    <span>Emails</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-book"></i>
                                    <span>Reports</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-smile-o"></i>
                                    <span>Persons</span>
                                </a>
                                <a href="#">
                                    <i class="fa fa-picture-o"></i>
                                    <span>Pictures</span>
                                </a>
                            </div>
                        </li>
                    </ul>
                    <!-- header right menu end -->
                </div>
                <!--header search panel start -->
                <div class="ttr-search-bar">
                    <form class="ttr-search-form">
                        <div class="ttr-search-input-wrapper">
                            <input type="text" name="qq" placeholder="search something..." class="ttr-search-input">
                            <button type="submit" name="search" class="ttr-search-submit"><i class="ti-arrow-right"></i></button>
                        </div>
                        <span class="ttr-search-close ttr-search-toggle">
                            <i class="ti-close"></i>
                        </span>
                    </form>
                </div>
                <!--header search panel end -->
            </div>
        </header>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <div class="ttr-sidebar">
            <div class="ttr-sidebar-wrapper content-scroll">
                <!-- side menu logo start -->
                <div class="ttr-sidebar-logo">
                    <a href="#"><img alt="" src="assetsAdmin/images/logo.png" width="122" height="27"></a>
                    <!-- <div class="ttr-sidebar-pin-button" title="Pin/Unpin Menu">
                            <i class="material-icons ttr-fixed-icon">gps_fixed</i>
                            <i class="material-icons ttr-not-fixed-icon">gps_not_fixed</i>
                    </div> -->
                    <div class="ttr-sidebar-toggle-button">
                        <i class="ti-arrow-left"></i>
                    </div>
                </div>
                <!-- side menu logo end -->
                <!-- sidebar menu start -->
                <nav class="ttr-sidebar-navi">
                    <ul>
                        <li>
                            <a href="dashboard" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-home"></i></span>
                                <span class="ttr-label">Dashboard</span>
                            </a>
                        </li>
                        <li>
                            <a href="customersmanager" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Customers Manager</span>
                            </a>
                        </li>
                        <li>
                            <a href="coursesmanager?pageIndex=1" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Courses Manager</span>
                            </a>
                        </li>
                        <li>
                        <li>
                            <a href="teachermanager?pageIndex=1" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Teacher Manager</span>
                            </a>
                        </li>
                        <li>
                        <li>
                        <li>
                            <a href="courses.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Staff Manager</span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-email"></i></span>
                                <span class="ttr-label">Mailbox</span>
                                <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                            </a>
                            <ul>
                                <li>
                                    <a href="mailbox.html" class="ttr-material-button"><span class="ttr-label">Mail Box</span></a>
                                </li>
                                <li>
                                    <a href="mailbox-compose.html" class="ttr-material-button"><span class="ttr-label">Compose</span></a>
                                </li>
                                <li>
                                    <a href="mailbox-read.html" class="ttr-material-button"><span class="ttr-label">Mail Read</span></a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-calendar"></i></span>
                                <span class="ttr-label">Calendar</span>
                                <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                            </a>
                            <ul>
                                <li>
                                    <a href="basic-calendar.html" class="ttr-material-button"><span class="ttr-label">Basic Calendar</span></a>
                                </li>
                                <li>
                                    <a href="list-view-calendar.html" class="ttr-material-button"><span class="ttr-label">List View</span></a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="bookmark.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-bookmark-alt"></i></span>
                                <span class="ttr-label">Bookmarks</span>
                            </a>
                        </li>
                        <li>
                            <a href="review.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-comments"></i></span>
                                <span class="ttr-label">Review</span>
                            </a>
                        </li>
                        <li>
                            <a href="add-listing.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-layout-accordion-list"></i></span>
                                <span class="ttr-label">Add listing</span>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-user"></i></span>
                                <span class="ttr-label">My Profile</span>
                                <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                            </a>
                            <ul>
                                <li>
                                    <a href="user-profile.html" class="ttr-material-button"><span class="ttr-label">User Profile</span></a>
                                </li>
                                <li>
                                    <a href="teacher-profile.html" class="ttr-material-button"><span class="ttr-label">Teacher Profile</span></a>
                                </li>
                            </ul>
                        </li>
                        <li class="ttr-seperate"></li>
                    </ul>
                    <!-- sidebar menu end -->
                </nav>
                <!-- sidebar menu end -->
            </div>
        </div>
        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Customers</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Customers</li>
                    </ul>
                </div>	
                <div class="row">

                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">



                            <!--content-->
                            <div>
                                <div >
                                    <div class="table-wrapper">
                                        <div class="table-title">
                                            <div class="row" style="padding-bottom: 16px">
                                                <!--                            <div class="col-sm-5">
                                                                                <h2>User <b>Management</b></h2>
                                                                            </div>-->

                                                <div class="col-6">
                                                    <a href="#addNewUser" class="btn btn-secondary" data-toggle="modal" data-target="#addNewUser"><span>Add New User</span></a>
                                                </div>
                                                <div class="col-6">
                                                    <div style="float: right">
                                                        <form action="customersmanager" method="get">
                                                        <div class="input-group mb-3">
                                                            <input type="text" name="txtSearch" value="${txtSearch}" class="form-control" placeholder="Search name..." aria-label="Search name..." aria-describedby="basic-addon2">
                                                            <div class="input-group-append">
                                                                <button class="btn btn-outline-secondary" type="submit">Search</button>
                                                            </div>
                                                        </div>
                                                            </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <table class="table table-striped table-hover">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Full Name</th>
                                                    <th>Username</th>
                                                    <th>Email</th>
                                                    <th>Phone</th>
                                                    <th>Gender</th>
                                                    <th>Address</th>

                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${users}" var="item" varStatus="loop">
                                                    <tr>
                                                        <td>${item.id}</td>
                                                        <td>${item.name}</td>
                                                        <td>${item.username}</td>
                                                        <td>${item.getEmail()}</td>  
                                                        <td>${item.getPhone()}</td>                        
                                                        <td>${item.getGender()}</td>                        
                                                        <td>${item.getAddress()}</td>                            
                                                        <td>
                                                            <a href="EditUser?id=${item.id}" class="settings" title="Settings"><i class="material-icons">&#xE8B8;</i></a>
                                                            <a href="DeleteUser?id=${item.id}" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE5C9;</i></a>
                                                        </td>
                                                    </tr>

                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        <div class="clearfix">
                                            <ul class="pagination">

                                                <c:forEach begin="1" end="${requestScope.total}" var="item">
                                                    <li class="page-item ${page==item ? "active": ""}"><a href="customersmanager?page=${item}&txtSearch=${txtSearch}" class="page-link">${item}</a></li>
                                                    </c:forEach>

                                            </ul>
                                        </div>
                                    </div>
                                </div>


                                <div class="modal" id="editUser">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Edit User</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="EditUser" method="post" id="form-edit">
                                                    <input type="hidden" name="id" value="${c.id}">
                                                    <div class="form-group">
                                                        <label for="recipient-name" class="col-form-label">User Name</label>
                                                        <input type="text" class="form-control" id="recipient-name" name="username" required="" value="${c.username}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="message-text" class="col-form-label">Password</label>
                                                        <input type="text" class="form-control" id="recipient-name" name="password" required="" value="${c.getPass()}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="message-text" class="col-form-label">Phone</label>
                                                        <input type="text" class="form-control" id="recipient-name" name="phone" required="" value="${c.phone}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="message-text" class="col-form-label">Email</label>
                                                        <input type="email" class="form-control" id="recipient-name" name="email" required="" value="${c.getEmail()}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="message-text" class="col-form-label">Full Name</label>
                                                        <input type="text" class="form-control" id="recipient-name" name="fullname" required="" value="${c.name}">
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Gender</label>
                                                        <select class="form-select form-control" name="gender">
                                                            <option value="male" ${c.gender eq 'male' ? 'selected' : ''}>Male</option>
                                                            <option value="female" ${c.gender eq 'female' ? 'selected' : ''}>Female</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="message-text" class="col-form-label">Address</label>
                                                        <textarea class="form-control" id="message-text" name="address" required="">${c.getAddress()}</textarea>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                        <button type="submit" class="btn btn-primary">Save</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="modal fade" id="addNewUser" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Add New User</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="addNewUser" method="post" id="form-add">
                                                    <div class="form-group">
                                                        <label for="recipient-name" class="col-form-label">User Name</label>
                                                        <input type="text" class="form-control" id="recipient-name" name="username" required="">
                                                    </div>
<!--                                                    <div class="form-group">
                                                        <label for="message-text" class="col-form-label">Password</label>
                                                        <input type="password" class="form-control" id="recipient-name" name="password" required="">
                                                    </div>-->
                                                    <div class="form-group">
                                                        <label for="message-text" class="col-form-label">Email</label>
                                                        <input type="email" class="form-control" id="recipient-name" name="email" required="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="message-text" class="col-form-label">Phone</label>
                                                        <input type="text" class="form-control" id="recipient-name" name="phone" required="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="message-text" class="col-form-label">Full Name</label>
                                                        <input type="text" class="form-control" id="recipient-name" name="fullname" required="">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="message-text" class="col-form-label">Gender</label>
                                                        <select class="form-control" name="gender" required="">
                                                            <option value="male">Male</option>
                                                            <option value="female">Female</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="message-text" class="col-form-label">Address</label>
                                                        <textarea class="form-control" id="message-text" name="address" required=""></textarea>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                        <button type="submit" class="btn btn-primary">Save</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>   
                            <!--endcontent-->

                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>



















        <!-- External JavaScripts -->
        <script src="assetsAdmin/js/jquery.min.js"></script>
        <script src="assetsAdmin/vendors/bootstrap/js/popper.min.js"></script>
        <script src="assetsAdmin/vendors/bootstrap/js/bootstrap.min.js"></script>
        <!--<script src="assetsAdmin/vendors/bootstrap-select/bootstrap-select.min.js"></script>-->
        <script src="assetsAdmin/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="assetsAdmin/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="assetsAdmin/vendors/counter/waypoints-min.js"></script>
        <script src="assetsAdmin/vendors/counter/counterup.min.js"></script>
        <script src="assetsAdmin/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="assetsAdmin/vendors/masonry/masonry.js"></script>
        <script src="assetsAdmin/vendors/masonry/filter.js"></script>
        <script src="assetsAdmin/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='assetsAdmin/vendors/scroll/scrollbar.min.js'></script>
        <script src="assetsAdmin/js/functions.js"></script>
        <script src="assetsAdmin/vendors/chart/chart.min.js"></script>
        <script src="assetsAdmin/js/admin.js"></script>
        <script src='assetsAdmin/vendors/switcher/switcher.js'></script>


        <c:if test="${showEditDialog}"> <script>$("#editUser").modal('show');</script></c:if>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
            <script type="text/javascript">
               $(document).ready(function () {
                   // Custom validation rule for phone number
                   $.validator.addMethod("phone10digits", function (value, element) {
                       return this.optional(element) || /^\d{10}$/.test(value);
                   }, "Please enter a valid phone number with exactly 10 digits.");
                   $.validator.addMethod("emailFormat", function (value, element) {
                       var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
                       return this.optional(element) || emailPattern.test(value);
                   }, "Please enter a valid email address.");
//                   $.validator.addMethod("passwordFormat", function (value, element) {
//                       return this.optional(element) || /^(?=.*[A-Z])(?=.*[\W_]).{8,}$/.test(value);
//                   }, "Password must be at least 8 characters long, contain at least one uppercase letter and one special character.");



                   // Validate the form
                   $("#form-edit").validate({
                       rules: {
                           phone: {
                               required: true,
                               phone10digits: true

                           },
                           email: {
                               required: true,
                               emailFormat: true
                           },
                           password: {
                               required: true,
                               passwordFormat: true
                           }



                       },
                       messages: {
                           phone: {
                               required: "Please enter your phone number",
                               phone10digits: "Please enter a valid phone number with exactly 10 digits"
                           }
                       }
                   });
                   // Validate the form
                   $("#form-add").validate({
                       rules: {
                           phone: {
                               required: true,
                               phone10digits: true
                           },
                           email: {
                               required: true,
                               emailFormat: true

                           }
//                           ,
//                           password: {
//                               required: true,
//                               passwordFormat: true
//                           }
                       },
                       messages: {
                           phone: {
                               required: "Please enter your phone number",
                               phone10digits: "Please enter a valid phone number with exactly 10 digits"
                           },
                           email: {
                               required: "Please enter your email",
                               emailFormat: "Please enter a valid email address "
                           }
//                           ,
//                           password: {
//                               required: true,
//                               passwordFormat: "please nhap lai"
//                           }
                       }
                   });
               });
            </script>

            <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" /><script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
        <c:if test="${message != null}">
            <script type="text/javascript">
       toastr.success(`${message}`, 'Success', {timeOut: 1000});
            </script>
        </c:if>
        <c:if test="${error != null}">
            <script type="text/javascript">
        toastr.error(`${error}`, 'Error', {timeOut: 2000});
            </script>
        </c:if>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/courses.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>