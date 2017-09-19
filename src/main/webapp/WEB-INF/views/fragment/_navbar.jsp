<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home"><b>小馬陪月網</b></a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="home">首頁</a></li>
				<li><a href="#">FAQ</a></li>
				<li><a id="more" href="#">More</a></li>

				<!-- Check if user is logged in to show diff nav element -->
				<c:choose>
					<c:when test="${empty loggedInUser}">

						<li><a id="nav-sp-register" href="registerSP">註冊陪月員</a></li>
						<li><button type="button"
								class="btn btn-danger navbar-btn navbar-btn-margin-left"
								id="nav-user-register" data-toggle="modal"
								data-target="#registerModal">免費註冊</button></li>
						<li><button type="button"
								class="btn btn-warning navbar-btn navbar-btn-margin-left"
								id="nav-login" onclick="window.location.href='login'">登入</button></li>

					</c:when>
					<c:otherwise>
						<li><button type="button"
								class="btn btn-info navbar-btn navbar-btn-margin-left"
								id="nav-sp-dashboard"
								onclick="window.location.href='dashboard'">我的帳戶</button></li>
						<li><button type="button"
								class="btn btn-warning navbar-btn navbar-btn-margin-left"
								id="nav-signOutButton" 
								onclick="window.location.href='logout'">登出</button></li>

					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>