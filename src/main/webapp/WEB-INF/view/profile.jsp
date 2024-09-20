<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>${webName}-Profile</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="${external}profile-page/assets/style.css">
<jsp:include page="/WEB-INF/view/component/imports.jsp"></jsp:include>
</head>
<body id="body">
	<jsp:include page="/WEB-INF/view/component/header.jsp"></jsp:include>
	<c:if test="${loggedInMember == null }">
		<div class="not-logged-in">OOps! You are not logged in yet.</div>
	</c:if>
	<c:if test="${loggedInMember != null }">
		<div class="container emp-profile">

			<!-- <form method="post">  -->
			<div>

				<!-- 			取得當下登入的會員的member_id -->
				<!-- 				<input type="hidden" class="form-control item" -->
				<%-- 					value="${loggedInMember.memberId}" name="member_id" id="memberId"> --%>
				<div class="row">
					<div class="col-md-4">
						<form method="post" enctype='multipart/form-data'
							action="${context.getContextPath}/ItineraryManager/changeMemberPhoto.do"
							onchange="submitForm()" id="changePhoto">
							<div class="profile-img">
								<img src="${loggedInMember.memberPhoto}" />
								<div class="file btn btn-lg btn-primary">
									<input type="hidden" value="${loggedInMember.memberId}"
										name="member_id"> Change Photo <input type="file"
										name="member_photo" />
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-6">
						<div class="profile-head">
							<h5>${loggedInMember.memberName}</h5>
							<h6>VIP Member</h6>
							<p class="proile-rating">
								RANKINGS : <span>8/10</span>
							</p>
							<ul class="nav nav-tabs" id="myTab" role="tablist">
								<li class="nav-item"><a class="nav-link active"
									id="home-tab" data-toggle="tab" href="#home" role="tab"
									aria-controls="home" aria-selected="true">About</a></li>
								<li class="nav-item"><a class="nav-link" id="profile-tab"
									data-toggle="tab" href="#profile" role="tab"
									aria-controls="profile" aria-selected="false">My Journey</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-2">
						<a href="${root}/edit_details"><input type="button"
							class="profile-edit-btn" name="btnAddMore" value="Edit Profile" /></a>
					</div>

				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="profile-work">
							<p>My Concern</p>
							<a href="#" class="icon-heart"> Favorite</a><br /> <a href="#"
								class="icon-clock"> Recently Viewed</a><br /> <a href=""
								class="icon-user-following"> Follow</a>
							<p>Other Service</p>
							<a href="#" class="icon-phone"> Contact Us</a><br /> <a href="#"
								class="icon-note"> Survey Center</a><br /> <a href="#"
								class="icon-lock"> Privacy &amp; Cookie Policy</a><br /> <a
								href="#" class="icon-support"> Terms &amp; Condition</a><br />
						</div>
					</div>
					<div class="col-md-8">
						<div class="tab-content profile-tab" id="myTabContent">
							<div class="tab-pane fade show active" id="home" role="tabpanel"
								aria-labelledby="home-tab">
								<div class="row">
									<div class="col-md-6">
										<label>Account Number:</label>
									</div>
									<div class="col-md-6">
										<p>${loggedInMember.memberAccount}</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Nickname:</label>
									</div>
									<div class="col-md-6">
										<p>${loggedInMember.memberName}</p>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<label>Age:</label>
									</div>
									<div class="col-md-6">
										<p>${loggedInMember.memberAge}</p>
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="profile" role="tabpanel"
								aria-labelledby="profile-tab">

								<c:forEach items="${sessionScope.myJourneys}" var="journey"
									varStatus="status">
									<div class="row">
										<div class="col-md-2">
											<label>Journey</label>
										</div>
										<div class="col-md-8">
											<a href="#">${journey.journeyName}</a>
											<c:set var="start" value="${journey.journeyStartDate}" />
											<c:set var="end" value="${journey.journeyEndDate}" />
											<c:if test="${start==null || end==null}">
												<span class="col-md-7">Undicided</span>
											</c:if>
											<c:if test="${start!=null && end!=null}">
												<span class="col-md-7">${journey.journeyStartDate}~
													${journey.journeyEndDate}</span>
											</c:if>
											
											<input type="button" value="D" style="font-size: 12px; width:25px; height:25px; float:right">
											<input type="button" value="U" style="font-size: 12px; width:25px; height:25px; float:right">
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-md-2">
						<input data-id="${deleteMemberId}" type="button"
							class="profile-edit-btn" name="btnDelete" value="Delete Account"
							style="width: 100%;" />
					</div>
				</div>
			</div>
			<!-- 			</form> -->
		</div>
	</c:if>

	<c:if test="${not empty photoError}">
		<script>
			alert('${photoError}');
		</script>
	</c:if>
	<script>
	
	function submitForm(){
		document.forms["changePhoto"].submit();
// 		document.getElementById("changePhoto").submit();
	}
	
		var deleteBtn = document.getElementsByName('btnDelete');
		for (let btn of deleteBtn){
			btn.addEventListener("click",()=>{
			    if(confirm("It's sad to see you leave. Are you sure you want to delete account?")){    
			        var xhr = new XMLHttpRequest();
			        xhr.open("get","/ItineraryManager/deleteMember.do?member_id="+btn.dataset["id"],true);
			        
			        xhr.onreadystatechange = function(){
			            if(xhr.readyState === 4){
			                if(xhr.status === 200){
			                    alert("Bye bye now.");
			                    
			                    // Create a new XMLHttpRequest for logOut
			                    var xhrLogOut = new XMLHttpRequest();
			                    xhrLogOut.open("get", "/ItineraryManager/logOut.do", true);
			                    xhrLogOut.onreadystatechange = function(){
			                        if(xhrLogOut.readyState === 4){
			                            if(xhrLogOut.status === 200){
			                                // Redirect to the homepage
			                                window.location.href = "/ItineraryManager/index";
			                            } else{
			                                alert("Failed to log out, please try again.");
			                            }
			                        }
			                    };
			                    xhrLogOut.send();
			                    
			                } else{
			                    alert("Failed to delete, please try again.");
			                }
			            }
			        };    
			        xhr.send();
			    }
			})
			};
	</script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>