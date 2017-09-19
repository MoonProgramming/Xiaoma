<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="fragment/_head.jsp" %>

    <style>
        .well {
            margin-top: 150px;
            color: white;
            background: rgba(100, 0, 0, 0.3);
        }
        
/*     .backdrop { */
/*       height: 600px; */
/*       background-image: url("<%=request.getContextPath() %>/resources/images/ipad-hand.png"); */
/*       background-repeat: no-repeat; */
/*       background-position: bottom; */
/*     } */


    </style>
</head>

<body>

    <!-- Fixed navbar -->
    <%@ include file="fragment/_navbar.jsp" %>

    <div id="headerwrap">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 backdrop">
                    <h1>全馬最齊全的陪月服務人員<br/> 最方便的應用
                    </h1>


                    <!--
            <h6 class="btn-app-store">
              <a class="btn" href="#fakelinks" id="testQueryUserButton">
                <img src="asset/images/google-play-badge.png" alt="">
              </a>
              <a class="btn" href="#fakelinks" id="testQuerySPButton">
                <img src="asset/images/appstore-badge.png" alt="">
              </a>
            </h6> 
-->
                    <!-- /.btn-app-store -->
                </div>
                <!-- /col-lg-8 -->
                <div class="col-lg-4">
                    <!--              <h2 align="center">一鍵搜尋</h2>-->
                    <div class="well">
                        <form class="form">
                            <div class="form-group">
                                <label for="client-date-input">寶寶預產期:</label>
                                <input class="form-control client-date-input" type="date" placeholder="2011-08-19" id="client-date-input">
                            </div>

                            <!-- <div class="form-group">
                    <label for="priceto" class="control-label">大約時薪</label>
                    <div class="input-group">
                      <div class="input-group-addon" id="basic-addon2">RM</div>
                      <input type="number" class="form-control" id="priceto" aria-describedby="basic-addon1">
                    </div>
                  </div> -->
                            <h6 class="text-center"><button type="button" class="btn btn-danger btn-lg searchSP" id="searchButton1">
                    <span class="glyphicon glyphicon-search"></span> 搜陪月嫂</button></h6>
                        </form>
                    </div>

                </div>
                <!-- /col-lg-4 -->

            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /headerwrap -->


    <div class="container">
        <div class="row mt centered">
            <div class="col-lg-6 col-lg-offset-3">
                <h1>尋找陪月嫂的煩惱?<br/>我們專門為你解決</h1>
                <h2>簡單步驟1-2-3</h2>
            </div>
        </div>
        <!-- /row -->

        <div class="row mt centered">
            <div class="col-lg-4">
                <img src="<%=request.getContextPath() %>/resources/images/curriculum-vitae.png" width="180" alt="">
                <h3>1 - 透過【小馬陪月】平台搜尋適合的陪月嫂</h3>
                <ul class="mt">
                    <li>參考陪月員過往工作經驗，語言，地點，自我介紹</li>
                    <li>免費註冊帳號，並自行與陪月嫂交流</li>
                    <li>達致雙方合意條件與價格</li>
                </ul>
                <!--                <h6>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever.</h6>-->
            </div>
            <!--/col-lg-4 -->

            <div class="col-lg-4">
                <img src="<%=request.getContextPath() %>/resources/images/padlock.png" width="180" alt="">
                <h3>2 - 通過【小馬陪月-保管定金】交付定金</h3>
                <ul class="mt">
                    <li>由【小馬陪月-保管定金】平台先保管你的定金</li>
                    <li>陪月嫂鎖定為您服務的預產期</li>
                    <li>預產期一個月前及前一星期，雙方將獲得確認通知</li>
                </ul>
                <!--                <h6>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever.</h6>-->

            </div>
            <!--/col-lg-4 -->

            <div class="col-lg-4">
                <img src="<%=request.getContextPath() %>/resources/images/motherhood.png" width="180" alt="">
                <h3>3 - 寶寶出世，陪月嫂上門履行服務</h3>
                <ul class="mt">
                    <li>若陪月嫂因任何原因沒履行協議，我們將立刻為您安排新陪月嫂</li>
                    <li>服務費餘額由雇主自行交予陪月嫂</li>
                    <li>陪月嫂完成任務後，您之前繳付的定金才會交予陪月嫂</li>
                </ul>
                <!--                <h6>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever.</h6>-->

            </div>
            <!--/col-lg-4 -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->

    <div class="container">
        <hr>
        <div class="row centered">
            <div class="col-lg-6 col-lg-offset-3">
                <h1>開始</h1>
                <button type="button" class="btn btn-danger btn-block searchSP" id="searchButton2">
                    <span class="glyphicon glyphicon-search"></span> 搜陪月嫂</button>

            </div>
            <div class="col-lg-3"></div>
        </div>
        <!-- /row -->
        <hr>
    </div>
    <!-- /container -->

    <div class="container">
        <div class="row mt centered">
            <div class="col-lg-6 col-lg-offset-3">
                <h1>Flatty is for Everyone.</h1>
                <h2>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.</h2>
            </div>
        </div>
        <!-- /row -->

        <! -- CAROUSEL -->
        <div class="row mt centered">
            <div class="col-lg-6 col-lg-offset-3">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <img src="<%=request.getContextPath() %>/resources/images/p01.png" alt="">
                        </div>
                        <div class="item">
                            <img src="<%=request.getContextPath() %>/resources/images/p02.png" alt="">
                        </div>
                        <div class="item">
                            <img src="<%=request.getContextPath() %>/resources/images/p03.png" alt="">
                        </div>
                    </div>
                </div>
            </div>
            <!-- /col-lg-8 -->
        </div>
        <!-- /row -->
    </div>
    <! --/container -->

    <div class="container">
        <hr>
        <div class="row centered">
            <div class="col-lg-6 col-lg-offset-3">
                <form class="form-inline" role="form">
                    <div class="form-group">
                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter your email address">
                    </div>
                    <button type="submit" class="btn btn-warning btn-lg">Invite Me!</button>
                </form>
            </div>
            <div class="col-lg-3"></div>
        </div>
        <!-- /row -->
        <hr>
    </div>
    <!-- /container -->

    <div class="container">
        <div class="row mt centered">
            <div class="col-lg-6 col-lg-offset-3">
                <h1>Our Awesome Team.<br/>Design Lovers.</h1>
                <h2>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.</h2>
            </div>
        </div>
        <!-- /row -->

        <div class="row mt centered">
            <div class="col-lg-4">
                <img class="img-circle" src="<%=request.getContextPath() %>/resources/images/pic1.jpg" width="140" alt="">
                <h3>Michael Robson</h3>
                <h6>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever.</h6>
                <h6><i class="glyphicon glyphicon-send"></i> <i class="glyphicon glyphicon-phone"></i> <i class="glyphicon glyphicon-globe"></i></h6>
            </div>
            <!--/col-lg-4 -->

            <div class="col-lg-4">
                <img class="img-circle" src="<%=request.getContextPath() %>/resources/images/pic2.jpg" width="140" alt="">
                <h3>Pete Ford</h3>
                <h6>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever.</h6>
                <h6><i class="glyphicon glyphicon-send"></i> <i class="glyphicon glyphicon-phone"></i> <i class="glyphicon glyphicon-globe"></i></h6>
            </div>
            <!--/col-lg-4 -->

            <div class="col-lg-4">
                <img class="img-circle" src="<%=request.getContextPath() %>/resources/images/pic3.jpg" width="140" alt="">
                <h3>Angelica Finning</h3>
                <h6>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever.</h6>
                <h6><i class="glyphicon glyphicon-send"></i> <i class="glyphicon glyphicon-phone"></i> <i class="glyphicon glyphicon-globe"></i></h6>
            </div>
            <!--/col-lg-4 -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->

    <div class="container">
        <hr>
        <div class="row centered">
            <div class="col-lg-6 col-lg-offset-3">
                <form class="form-inline" role="form">
                    <div class="form-group">
                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter your email address">
                    </div>
                    <button type="submit" class="btn btn-warning btn-lg">Invite Me!</button>
                </form>
            </div>
            <div class="col-lg-3"></div>
        </div>
        <!-- /row -->
        <hr>
        <h6 class="centered">Created by BlackTie.co - Attribution License 3.0 - 2013</h6>
    </div>
    <!-- /container -->

    <modal>
        <!-- user registerModal -->
        <%@ include file="fragment/_modal_registerUser.jsp" %>
        
        <!-- loginModal -->
        <%@ include file="fragment/_modal_login.jsp" %>
        
        <!-- messageModal -->
        <%@ include file="fragment/_modal_message.jsp" %>
        
    </modal>
    <!-- // end of modal -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery-2.2.4.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.js"></script>
</body>

</html>