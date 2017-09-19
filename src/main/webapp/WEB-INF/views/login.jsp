<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="fragment/_head.jsp"%>

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath() %>/resources/css/style.css" rel="stylesheet" type="text/css">
	<style>
html, body {
	padding-right: 0px !important;
	position: relative !important;
}
</style>
</head>

<body>

	<!-- Fixed navbar -->
	<%@ include file="fragment/_navbar.jsp"%>


	<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	<div id="login-page">
		<div class="container">

			<form class="form-login" action="login" method="post">
				<h2 class="form-login-heading">登入</h2>
				<div class="login-wrap">
				<p style="color: red;">${errorString}</p>
					<input name="email" type="email" maxlength="50" value="${user.email}"
						class="form-control" placeholder="電郵" autofocus> <br>
							<input name="password" type="password" maxlength="20" value="${user.password}"
							class="form-control" placeholder="密碼"> <br>
							
							<input type="checkbox" name="rememberMe" value= "Y" /> Remember Me
							<label class="checkbox"> 
							<span class="pull-right"> 
							<a data-toggle="modal" href="#forgotPasswordModal">忘記密碼？</a>

								</span>
							</label>
								<button id="doLogin" class="btn btn-theme btn-block"
									data-toggle="modal" data-target="#messageModal" type="submit" >
									<i class="fa fa-lock"></i> 登入
								</button>
								<hr>

									<div class="login-social-link centered">
										<p>or you can sign in via your social network</p>
										<button class="btn btn-facebook" type="submit">
											<i class="fa fa-facebook"></i> Facebook
										</button>
										<button class="btn btn-twitter" type="submit">
											<i class="fa fa-twitter"></i> Twitter
										</button>
									</div>
									<div class="registration">
										Don't have an account yet?<br /> <a data-toggle="modal"
											href="#registerModal"> Create an account </a>
									</div>
				</div>

				<!-- Modal -->
				<!-- forgotPasswordModal -->
				<%@ include file="fragment/_modal_forgotPassword.jsp"%>
				<!-- modal -->

			</form>

		</div>
	</div>

	<!-- **********************************************************************************************************************************************************
      MODAL
      *********************************************************************************************************************************************************** -->

	<modal> 
	
	<!-- user registerModal --> 
	<%@ include file="fragment/_modal_registerUser.jsp"%> 
	
	<!-- loginModal -->
	<%@ include file="fragment/_modal_login.jsp"%>

	<!-- messageModal --> 
	<%@ include file="fragment/_modal_message.jsp"%>
	</modal>
	<!-- // end of modal -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<%=request.getContextPath() %>/resources/js/jquery-2.2.4.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/js/bootstrap.js"></script>

	<!--BACKSTRETCH-->
	<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.backstretch.min.js"></script>
	<script>
		$.backstretch("<%=request.getContextPath() %>/resources/images/whitebaby.jpg", {
			speed : 500
		});
	</script>

	

</body>

</html>