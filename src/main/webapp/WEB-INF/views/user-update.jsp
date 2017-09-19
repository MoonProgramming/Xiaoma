<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="fragment/_head.jsp"%>
    
    <!--external css-->
    <link href="<%=request.getContextPath() %>/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/resources/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/style-responsive.css" rel="stylesheet">

    
</head>

<body>

    <section id="container">
        <!-- **********************************************************************************************************************************************************
    TOP BAR CONTENT & NOTIFICATIONS
    *********************************************************************************************************************************************************** -->
        <!--header start-->
        <header class="header black-bg">
            <div class="sidebar-toggle-box">
                <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
            </div>
            <!--logo start-->
            <a href="<%=request.getContextPath() %>/home" class="logo"><b>小馬陪月網</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="user-update.html#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme">4</span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 4 pending tasks</p>
                            </li>
                            <li>
                                <a href="user-update.html#">
                                    <div class="task-info">
                                        <div class="desc">DashGum Admin Panel</div>
                                        <div class="percent">40%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="user-update.html#">
                                    <div class="task-info">
                                        <div class="desc">Database Update</div>
                                        <div class="percent">60%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="user-update.html#">
                                    <div class="task-info">
                                        <div class="desc">Product Development</div>
                                        <div class="percent">80%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="user-update.html#">
                                    <div class="task-info">
                                        <div class="desc">Payments Sent</div>
                                        <div class="percent">70%</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%">
                                            <span class="sr-only">70% Complete (Important)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="external">
                                <a href="#">See All Tasks</a>
                            </li>
                        </ul>
                    </li>
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="user-update.html#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme">5</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 5 new messages</p>
                            </li>
                            <li>
                                <a href="user-update.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-zac.jpg"></span>
                                    <span class="subject">
                                  <span class="from">Zac Snider</span>
                                    <span class="time">Just now</span>
                                    </span>
                                    <span class="message">
                                      Hi mate, how is everything?
                                  </span>
                                </a>
                            </li>
                            <li>
                                <a href="user-update.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-divya.jpg"></span>
                                    <span class="subject">
                                  <span class="from">Divya Manian</span>
                                    <span class="time">40 mins.</span>
                                    </span>
                                    <span class="message">
                                   Hi, I need your help with this.
                                  </span>
                                </a>
                            </li>
                            <li>
                                <a href="user-update.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-danro.jpg"></span>
                                    <span class="subject">
                                  <span class="from">Dan Rogers</span>
                                    <span class="time">2 hrs.</span>
                                    </span>
                                    <span class="message">
                                      Love your new Dashboard.
                                  </span>
                                </a>
                            </li>
                            <li>
                                <a href="user-update.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-sherman.jpg"></span>
                                    <span class="subject">
                                  <span class="from">Dj Sherman</span>
                                    <span class="time">4 hrs.</span>
                                    </span>
                                    <span class="message">
                                      Please, answer asap.
                                  </span>
                                </a>
                            </li>
                            <li>
                                <a href="user-update.html#">See all messages</a>
                            </li>
                        </ul>
                    </li>
                    <!-- inbox dropdown end -->
                </ul>
                <!--  notification end -->
            </div>
            <div class="top-menu">
                <ul class="nav pull-right top-menu">
                    <li><a class="logout" id="signOutButton" href="<%=request.getContextPath() %>/home">登出</a></li>
                </ul>
            </div>
        </header>
        <!--header end-->

        <!-- **********************************************************************************************************************************************************
    MAIN SIDEBAR MENU
    *********************************************************************************************************************************************************** -->
        <!--sidebar start-->
        <aside>
            <div id="sidebar" class="nav-collapse ">
            
                <!-- sidebar menu start-->
                <ul class="sidebar-menu" id="nav-accordion">

<!--
                    <p class="centered">
                        <a href="#" data-toggle="modal" data-target="#sp-profileModal">
                            <img src="" class="img-rounded galleryPic1" width="60"></a>
                    </p>
-->
					<h5 class="centered" id="fullName">${user.displayName}</h5>

                    <li class="mt">
                        <a href="<%=request.getContextPath() %>/user/userFavorite">
                            <i class="fa fa-heart"></i>
                            <span>我的人選</span>
                        </a>
                    </li>
                 
                    <li class="sub-menu">
                        <a class="active" href="<%=request.getContextPath() %>/user/userUpdate">
                            <i class="fa fa-edit"></i>
                            <span>更新資料</span>
                        </a>
                    </li>

                    <li class="sub-menu">
                        <a href="<%=request.getContextPath() %>/user/userPayment">
                            <i class="fa fa-dollar"></i>
                            <span>交易記錄</span>
                        </a>
                    </li>

                    <li class="sub-menu">
                        <a href="<%=request.getContextPath() %>/user/userSetting">
                            <i class="fa fa-cogs"></i>
                            <span>設定</span>
                        </a>
                    </li>

                </ul>
                <!-- sidebar menu end-->
            </div>
        </aside>
        <!--sidebar end-->

        <!-- messageModal --> 
		<%@ include file="fragment/_modal_message.jsp"%>

        <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
        <!--main content start-->
        <section id="main-content">
            <section class="wrapper">
                <h3><i class="fa fa-angle-right"></i> 更新個人資料</h3>
                <! -- DISMISSABLE ALERT -->
      				
      					<!-- Check if updateMessage is not null or not empty -->
						<c:if test="${not empty updateMessage}">
						     
						<div class="alert alert-info alert-dismissable alert-block">
						  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						  <strong>${updateMessage}</strong>
						</div>      				
						 </c:if>
 
                <!-- INPUT MESSAGES -->
                <div class="row mt">
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <h4 class="mb"><i class="fa fa-angle-right"></i> 更新預產期</h4>
                            <form class="form-horizontal tasi-form" action="userUpdate" method="post">
                               
                               <div class="form-group">
                                    <label for="user-date-childBirthdate" class="col-sm-3 control-label">寶寶預產期</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="date" value="${user.childBirthdate}" name="user-date-childBirthdate">
                                    </div>
                                </div>
                                                               
                                <button type="submit" name="updateChildBirthdate" value="update" class="btn btn-warning btn-lg btn-block" id="updateChildBirthdate">更新預產期</button>

                            </form>
                        </div>
                        <!-- /form-panel -->
                    </div>
                    <!-- /col-lg-12 -->
                </div>
                <!-- /row -->
                

                <!-- BASIC FORM ELELEMNTS -->
                <div class="row mt">
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <h4 class="mb"><i class="fa fa-angle-right"></i> 更新個人資料</h4>
                            <form class="form-horizontal style-form" action="userUpdate" method="post">

                                <div class="form-group">
                                    <label for="user-input-displayName" class="col-sm-3 control-label">姓名</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="text" maxlength="50" name="user-input-displayName" value="${user.displayName}" id="user-input-displayName">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="user-input-Tel" class="col-sm-3 control-label" data-toggle="tooltip" data-placement="top" title="已預約的陪月嫂將以此電話號碼聯絡你">電話 (Whatsapp)
                    <span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span></label>
                                    <div class="col-sm-9">
                                        <input class="form-control" type="tel" maxlength="20" name="user-input-Tel" placeholder="例: 60123456789" id="user-input-Tel" value="${user.phone}">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-lg-3 col-sm-3 control-label">Email電郵</label>
                                    <div class="col-lg-9">
                                        <p class="form-control-static" id="email">${user.email}</p>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-lg-3 col-sm-3 control-label">居住地址</label>
                                    <div class="col-lg-9">
                                        <p class="form-control-static" id="user-textarea-homeaddress">${user.address}</p>
                                    </div>
                                </div>
                                
<!--
                                <div class="form-group">
                                    <label class="col-sm-3 control-label" for="selectbasic">居住地區</label>
                                    <div class="col-sm-9">
                                        <select id="sp-select-state" name="selectbasic" class="form-control">
                        <option value="Kuala Lumpur">Kuala Lumpur</option>
                        <option value="Selangor">Selangor</option>
                        <option value="Penang">Penang</option>
                        <option value="Johor">Johor</option>
                        <option value="Melaka">Melaka</option>
                        <option value="Sabah">Sabah</option>
                        <option value="Sarawak">Sarawak</option>
                        <option value="Kedah">Kedah</option>
                        <option value="Negeri Sembilan">Negeri Sembilan</option>
                        <option value="Kelantan">Kelantan</option>
                        <option value="Pahang">Pahang</option>
                        <option value="Perak">Perak</option>
                        <option value="Perlis">Perlis</option>
                        <option value="Putrajaya">Putrajaya</option>
                        <option value="Terenggagu">Terenggagu</option>
                        <option value="Labuan">Labuan</option>
                        <option value="Others">Others</option>
                      </select>
                                    </div>
                                </div>
-->
                                
                                
                                <button type="submit" name="updateUserInfo" value="update" class="btn btn-primary btn-lg btn-block" id="updateUserButton">儲存</button>

                            </form>
                        </div>
                    </div>
                    <!-- col-lg-12-->
                </div>
                <!-- /row -->

                

            </section>
            <! --/wrapper -->
        </section>
        <!-- /MAIN CONTENT -->

        <!--main content end-->
        <!--footer start-->
        <footer class="site-footer">
            <div class="text-center">
                2016 - MoonLikeCats
                <a href="#" class="go-top">
                    <i class="fa fa-angle-up"></i>
                </a>
            </div>
        </footer>
        <!--footer end-->
    </section>

    <!-- js placed at the end of the document so the pages load faster -->   
    <script src="<%=request.getContextPath() %>/resources/js/jquery-2.2.4.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.js"></script>
    <script class="include" type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.scrollTo.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="<%=request.getContextPath() %>/resources/js/common-scripts.js"></script>

    <!--script for this page-->


    <!--custom switch-->


    <!--custom tagsinput-->


    <!--custom checkbox & radio-->




</body>

</html>