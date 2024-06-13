<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:08:15 GMT -->
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
        <style>
            .new-user-list {
                max-width: 600px;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #f9f9f9;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }

            .new-user-list ul {
                list-style-type: none;
                padding: 0;
                margin: 0;
            }

            .new-user-list li {
                display: flex;
                align-items: center;
                margin-bottom: 15px;
                padding: 10px;
                border-bottom: 1px solid #ddd;
            }

            .new-users-pic {
                width: 50px;
                height: 50px;
                margin-right: 15px;
            }

            .new-users-pic img {
                width: 100%;
                height: 100%;
                object-fit: cover;
                border-radius: 50%;
            }

            .new-users-text {
                flex-grow: 1;
            }

            .new-users-name {
                font-weight: bold;
                text-decoration: none;
                color: #333;
            }

            .new-users-info {
                display: block;
                color: #666;
            }

            .new-users-btn {
                margin-left: 10px;
            }

            .btn {
                display: inline-block;
                padding: 5px 10px;
                font-size: 14px;
                color: white;
                background-color: #4CAF50;
                border: none;
                border-radius: 3px;
                text-decoration: none;
            }

            .btn:hover {
                background-color: #45a049;
            }

            .outline {
                background-color: transparent;
                color: #4CAF50;
                border: 1px solid #4CAF50;
            }

            .outline:hover {
                background-color: #4CAF50;
                color: white;
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
                            <img class="ttr-logo-mobile" alt="" src="assetsAdmin/images/logo-mobile.png" width="30" height="30">
                            <img class="ttr-logo-desktop" alt="" src="assetsAdmin/images/logo-white.png" width="160" height="27">
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
                                <span class="ttr-label">Dashborad</span>
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
                            <a href="manageStaffAccounts" class="ttr-material-button">
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
<!--                        <li>
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
                        </li>-->
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
<!--                        <li>
                            <a href="add-listing.html" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-layout-accordion-list"></i></span>
                                <span class="ttr-label">Add listing</span>
                            </a>
                        </li>-->
                        <li>
                            <a href="adminprofile" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-user"></i></span>
                                <span class="ttr-label">My Profile</span>
                            </a>
                           
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
                    <h4 class="breadcrumb-title">Dashboard</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Manage Staff Accounts</li>
                    </ul>
                </div>	
                <!-- Card -->

                <!-- Card END -->
                <div class="row">

                    <div class="col-lg-6 m-b30">
                        <div class="widget-box">
                            <span class="orders-btn">
                                <a href="createStaff" class="btn button-sm green">ADD STAFF</a>
                            </span>
                            <div class="wc-title">
                                <h4>New Users</h4>
                            </div>
                            <div class="widget-inner">

                                <form action="manageStaffAccounts" method="get">
                                    <li>
                                        <span class="orders-info">Member of page </span>&nbsp
                                        <select name="recordsPerPage" onchange="this.form.submit()">
                                            <option value="5" ${recordsPerPage == 5 ? 'selected' : ''}>5</option>
                                            <option value="10" ${recordsPerPage == 10 ? 'selected' : ''}>10</option>
                                            <option value="15" ${recordsPerPage == 15 ? 'selected' : ''}>15</option>
                                            <option value="20" ${recordsPerPage == 20 ? 'selected' : ''}>20</option>
                                        </select>
                                    </li>
                                </form>

                                <!--                                <form action="manageStaffAccounts" method="get">
                                                                    <li>
                                                                        <span class="orders-info">Page: </span>&nbsp
                                                                        <input type="text" name="recordsPerPage" value="${recordsPerPage}" min="1" />
                                                                        <button type="submit" class="btn button-sm green">Enter</button>
                                                                        </br>
                                                                    </li>
                                                                </form>-->
                                <c:forEach var="c" items="${requestScope.data}">
                                    <div class="new-user-list">

                                        <ul>

                                            <li>

                                                <c:if test="${c.gender == 'female'}">
                                                    <span class="new-users-pic">
                                                        <img src="ImageCourse/fermale.jpg" alt=""/>
                                                    </span>
                                                </c:if>
                                                <c:if test="${c.gender == 'Male'}">
                                                    <span class="new-users-pic">
                                                        <img src="ImageCourse/male.jpg" alt=""/>                                                    </span>
                                                    </c:if>

                                                <span class="new-users-text">
                                                    <a class="new-users-name">${c.fullname}</a>
                                                    <span class="new-users-info">${c.address}</span>
                                                </span>
                                                <span class="new-users-btn">
                                                    <a href="updateStaff?id=${c.id}" class="btn button-sm outline">UPDATE</a>
                                                </span>
                                            </li>
                                        </ul>
                                    </div>
                                </c:forEach>
                                <c:if test="${currentPage > 1}">
                                    <a href="manageStaffAccounts?page=${currentPage - 1}&recordsPerPage=${recordsPerPage}">Previous</a>
                                </c:if>
                                <c:forEach var="i" begin="1" end="${noOfPages}">
                                    <c:choose>
                                        <c:when test="${i == currentPage}">
                                            ${i}
                                        </c:when>
                                        <c:otherwise>
                                            <a href="manageStaffAccounts?page=${i}&recordsPerPage=${recordsPerPage}">${i}</a>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                <c:if test="${currentPage < noOfPages}">
                                    <a href="manageStaffAccounts?page=${currentPage + 1}&recordsPerPage=${recordsPerPage}">Next</a>
                                </c:if>
                            </div>
                            <div>

                            </div>
                        </div>

                    </div>



                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>

        <!-- External JavaScripts -->
        <script src="assetsAdmin/js/jquery.min.js"></script>
        <script src="assetsAdmin/vendors/bootstrap/js/popper.min.js"></script>
        <script src="assetsAdmin/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="assetsAdmin/vendors/bootstrap-select/bootstrap-select.min.js"></script>
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
        <script src='assetsAdmin/vendors/calendar/moment.min.js'></script>
        <script src='assetsAdmin/vendors/calendar/fullcalendar.js'></script>
        <script src='assetsAdmin/vendors/switcher/switcher.js'></script>
        <script>
                            $(document).ready(function () {

                                $('#calendar').fullCalendar({
                                    header: {
                                        left: 'prev,next today',
                                        center: 'title',
                                        right: 'month,agendaWeek,agendaDay,listWeek'
                                    },
                                    defaultDate: '2019-03-12',
                                    navLinks: true, // can click day/week names to navigate views

                                    weekNumbers: true,
                                    weekNumbersWithinDays: true,
                                    weekNumberCalculation: 'ISO',

                                    editable: true,
                                    eventLimit: true, // allow "more" link when too many events
                                    events: [
                                        {
                                            title: 'All Day Event',
                                            start: '2019-03-01'
                                        },
                                        {
                                            title: 'Long Event',
                                            start: '2019-03-07',
                                            end: '2019-03-10'
                                        },
                                        {
                                            id: 999,
                                            title: 'Repeating Event',
                                            start: '2019-03-09T16:00:00'
                                        },
                                        {
                                            id: 999,
                                            title: 'Repeating Event',
                                            start: '2019-03-16T16:00:00'
                                        },
                                        {
                                            title: 'Conference',
                                            start: '2019-03-11',
                                            end: '2019-03-13'
                                        },
                                        {
                                            title: 'Meeting',
                                            start: '2019-03-12T10:30:00',
                                            end: '2019-03-12T12:30:00'
                                        },
                                        {
                                            title: 'Lunch',
                                            start: '2019-03-12T12:00:00'
                                        },
                                        {
                                            title: 'Meeting',
                                            start: '2019-03-12T14:30:00'
                                        },
                                        {
                                            title: 'Happy Hour',
                                            start: '2019-03-12T17:30:00'
                                        },
                                        {
                                            title: 'Dinner',
                                            start: '2019-03-12T20:00:00'
                                        },
                                        {
                                            title: 'Birthday Party',
                                            start: '2019-03-13T07:00:00'
                                        },
                                        {
                                            title: 'Click for Google',
                                            url: 'http://google.com/',
                                            start: '2019-03-28'
                                        }
                                    ]
                                });

                            });

        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>