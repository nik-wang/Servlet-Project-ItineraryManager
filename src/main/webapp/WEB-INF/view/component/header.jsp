<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
<link rel="stylesheet"
	href="${external}header-blue/assets/css/style.css">
</head>

<header>
	<div>
		<div class="header-blue">
			<div>
				<nav
					class="navbar navbar-dark navbar-expand-md navigation-clean-search">
					<div class="container">
						<a class="navbar-brand" href="${root}/index">Itinerary Manager</a>
						<button class="navbar-toggler" data-toggle="collapse"
							data-target="#navcol-1">
							<span class="sr-only">Toggle navigation</span><span
								class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navcol-1">
							<ul class="nav navbar-nav">

								<c:if test="${loggedInMember!=null }">
									<li class="nav-item" role="presentation"><a
										class="nav-link active" href="${root}/my_journey">My Journey</a></li>
									<li class="dropdown"><a
										class="dropdown-toggle nav-link dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false" href="#">Add
											New </a>
										<div class="dropdown-menu" role="menu">
											<a class="dropdown-item" role="presentation" href="${root}/add_journey">Journey</a>
											<a class="dropdown-item" role="presentation" href="#">Itinerary</a>
										</div></li>
								</c:if>
							</ul>
							<form class="form-inline mr-auto" target="_self" method="post" action="${context.getContextPath}/ItineraryManager/search.do">
								<div class="form-group">
									<label for="search-field"><i class="fa fa-search"></i></label><input
										class="form-control search-field" type="search" name="search"
										id="search-field">
								</div>
							</form>

							<span class="navbar-text"><c:if
									test="${loggedInMember==null}">
									<a href="${root}/login" class="login">Log In</a>
									<a class="btn btn-light action-button" role="button"
										href="${root}/register">Sign Up</a>
								</c:if> <c:if test="${loggedInMember!=null }">
								<ul class="nav navbar-nav">
									<li><img style="width:60px; padding-right:5px" src="${loggedInMember.memberPhoto }"></li>
									<li class="dropdown"><a
										class="dropdown-toggle nav-link dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false" href="#">${loggedInMember.memberName}</a>
										<div class="dropdown-menu" role="menu">
											<a class="dropdown-item" role="presentation" href="#">Settings</a>
											<a class="dropdown-item" role="presentation" href="${root}/profile">Profile</a>
											<a class="dropdown-item" role="presentation" href="#" id="logOutBtn" data-info="${loggedInMember}">Log Out</a>
										</div></li>
								</ul>
				</c:if>
							</span>
						</div>
					</div>
				</nav>
				<!-- 			<div class="container hero"> -->
				<!-- 				<div class="row"> -->
				<!-- 					<div class="col-12 col-lg-6 col-xl-5 offset-xl-1"> -->
				<!-- 						<h1>The revolution is here.</h1> -->
				<!-- 						<p>Mauris egestas tellus non ex condimentum, ac ullamcorper -->
				<!-- 							sapien dictum. Nam consequat neque quis sapien viverra convallis. -->
				<!-- 							In non tempus lorem.</p> -->
				<!-- 						<button class="btn btn-light btn-lg action-button" type="button">Learn -->
				<!-- 							More</button> -->
				<!-- 					</div> -->
				<!-- 					<div -->
				<!-- 						class="col-md-5 col-lg-5 offset-lg-1 offset-xl-0 d-none d-lg-block phone-holder"> -->
				<!-- 						<div class="iphone-mockup"> -->
				<!-- 							<img src="assets/img/iphone.svg" class="device"> -->
				<!-- 							<div class="screen"></div> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
			</div>
		</div>
	</div>

	<script>
		document.getElementById("logOutBtn").addEventListener("click",()=>{

			fetch("/ItineraryManager/logOut.do");
			window.location.href = "/ItineraryManager/index";
		})
		
	</script>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</header>
</html>