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
                        <a href="<%=request.getContextPath() %>/user/userUpdate">
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
                        <a class="active" href="<%=request.getContextPath() %>/user/userSetting">
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
                <h3><i class="fa fa-angle-right"></i> 設定</h3>
                
                <! -- DISMISSABLE ALERT -->
      				
      					<!-- Check if updateMessage is not null or not empty -->
						<c:if test="${not empty updateMessage}">
						     
						<div class="alert alert-info alert-dismissable alert-block">
						  <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						  <strong>${updateMessage}</strong>
						</div>      				
						 </c:if>


                <div class="row mt">
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <h4 class="mb"><i class="fa fa-angle-right"></i> 更改登入電郵</h4>
                            <form class="form-horizontal tasi-form" action="userSetting" method="post">

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">現今登入電郵是</label>
                                    <div class="col-sm-9">
                                        <span id="email">${user.email}</span>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label">新登入電郵</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" maxlength="50" type="email" name="user-input-email">
                                    </div>
                                </div>

                                <div class="col-sm-offset-9 text-right">
                                    <button type="submit" name="updateUserEmail" value="update" class="btn btn-primary btn-lg " id="updateUserEmail">更改電郵</button>
                                </div>
                            </form>
                        </div>
                        <!-- /form-panel -->
                    </div>
                    <!-- /col-lg-12 -->
                </div>
                <!-- /row -->

                <div class="row mt">
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <h4 class="mb"><i class="fa fa-angle-right"></i> 更改密碼</h4>
                            <form class="form-horizontal tasi-form" action="userSetting" method="post">
                                <div class="form-group">
                                    <label for="example-password-input" class="col-sm-3 control-label">輸入原本密碼</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" maxlength="20" type="password" id="user-input-oldPwd">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="example-password-input" class="col-sm-3 control-label">設定新密碼</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" maxlength="20" type="password" placeholder="最少六個英文字母或數字" name="user-input-pwd">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="example-password-reinput" class="col-sm-3 control-label">再填新密碼</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" maxlength="20" type="password" placeholder="再填一次新密碼" name="user-reinput-pwd">
                                    </div>
                                </div>
                                <div class="col-sm-offset-9 text-right">
                                    <button type="submit" name="updateUserPassword" value="update" class="btn btn-primary btn-lg " id="updateUserPassword">更改密碼</button>
                                </div>
                            </form>
                        </div>
                        <!-- /form-panel -->
                    </div>
                    <!-- /col-lg-12 -->
                </div>
                <!-- /row -->

                <div class="row mt">
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <h4 class="mb"><i class="fa fa-angle-right"></i> 刪除帳戶</h4>
                            <form class="form-horizontal tasi-form" value="delete" id="deleteForm" action="userSetting" method="post">
                                <div class="form-group">
                                    <label class="col-sm-9 control-label">
                    <span class="glyphicon glyphicon-question-sign" aria-hidden="true"></span>
                    注意：帳號刪除後，您的資料將不被保留。</label>
                                    <div class="col-sm-3 text-right">
                                        <button type="submit" name="deleteUserAcc" value="delete" class="btn btn-primary btn-lg " id="deleteUserAcc">刪除帳戶</button>
                                        
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- /form-panel -->
                    </div>
                    <!-- /col-lg-12 -->
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

	<script>
	$('#deleteUserAcc').on('click', function (e) {

		if (confirm('您確定要刪除帳號嗎？')) {
		    return;
		}
		else return false;

	});
	</script>


</body>

</html>