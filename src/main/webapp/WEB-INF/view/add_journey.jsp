<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${webName}-CreateNewJourney</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="${external}progressbar/assets/style.css">

</head>
<body id="body">
	<jsp:include page="/WEB-INF/view/component/header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div
				class="col-11 col-sm-9 col-md-7 col-lg-6 col-xl-5 text-center p-0 mt-3 mb-2">
				<div class="card px-0 pt-4 pb-0 mt-3 mb-3">
					<h2 id="heading">Add Your Journey</h2>
					<p></p>
					<p>Create memories that will last a lifetime.</p>

					<form id="msform"
						action="${context.getContextPath}/ItineraryManager/addJourney.do"
						method="post" enctype="multipart/form-data">
						<input type="hidden" value="${loggedInMember.memberId}"
										name="member_id">
						<!-- progressbar -->
						<ul id="progressbar">
							<li class="active" id="account"><strong>Journey
									Details</strong></li>
							<li id="personal"><strong>Additional Info</strong></li>
							<li id="payment"><strong>Image</strong></li>
							<li id="confirm"><strong>Finish</strong></li>
						</ul>
						<div class="progress">
							<div
								class="progress-bar progress-bar-striped progress-bar-animated"
								role="progressbar" aria-valuemin="0" aria-valuemax="100"></div>
						</div>
						<br>
						<!-- fieldsets -->
						<fieldset>
							<div class="form-card">
								<div class="row">
									<div class="col-7">
										<h2 class="fs-title">Journey Details:</h2>
									</div>
									<div class="col-5">
										<h2 class="steps">Step 1 - 4</h2>
									</div>
								</div>
								<label class="fieldlabels">Journey Name: *</label> <input
									type="email" name="journey_name" placeholder="name"
									style="border-radius: 10px" required /> <label
									class="fieldlabels">Start Date: </label> <input type="date"
									name="journey_start_date" style="border-radius: 10px" /> <label
									class="fieldlabels">End Date: </label> <input type="date"
									name="journey_end_date" style="border-radius: 10px" />
							</div>
							<input type="button" name="next" class="next action-button"
								value="Next" />
						</fieldset>
						<fieldset>
							<div class="form-card">
								<div class="row">
									<div class="col-7">
										<h2 class="fs-title">Additional:</h2>
									</div>
									<div class="col-5">
										<h2 class="steps">Step 2 - 4</h2>
									</div>
								</div>
								<label class="fieldlabels">Purpose: </label> <input type="text"
									placeholder="Purpose" style="border-radius: 10px" /> <label
									class="fieldlabels">Category: </label> <input type="text"
									placeholder="Category" style="border-radius: 10px" /> <label
									class="fieldlabels">Visability: </label>
								<div style="display: flex; align-items: center;">
									<span style="display: flex; margin-right: 20px;"> <input
										type="radio" id="private" name="is_public" value="0"
										style="border-radius: 10px;"> <label for="private"
										style="margin: 0;">Private</label>
									</span> <span style="display: flex;"> <input type="radio"
										id="public" name="is_public" value="1"
										style="border-radius: 10px;"> <label for="public"
										style="margin: 0;">Public</label>
									</span>
								</div>

								<label class="fieldlabels">Notes: </label> <input type="text"
									name="notes" style="border-radius: 10px" />
							</div>
							<input type="button" name="next" class="next action-button"
								value="Next" /> <input type="button" name="previous"
								class="previous action-button-previous" value="Previous" />
						</fieldset>
						<fieldset>
							<div class="form-card">
								<div class="row">
									<div class="col-7">
										<h2 class="fs-title">Image Upload:</h2>
									</div>
									<div class="col-5">
										<h2 class="steps">Step 3 - 4</h2>
									</div>
								</div>
								<label class="fieldlabels">Upload Your Journey Cover:</label> <input
									type="file" name="journey_photo" accept="image/*"
									style="font-size: 14px; border-radius: 10px">
							</div>
							<input type="submit" id="submitBtn" class="next action-button"
								value="Submit" /> <input type="button" name="previous"
								class="previous action-button-previous" value="Previous" />
						</fieldset>
						<fieldset>
							<div class="form-card">
								<div class="row">
									<div class="col-7">
										<h2 class="fs-title">Finish:</h2>
									</div>
									<div class="col-5">
										<h2 class="steps">Step 4 - 4</h2>
									</div>
								</div>
								<br> <br>
								<h2 class="purple-text text-center">
									<strong>PERFECT !</strong>
								</h2>
								<br>
								<div class="row justify-content-center">
									<div class="col-3">
										<img src="https://i.imgur.com/GwStPmg.png" class="fit-image">
									</div>
								</div>
								<br> <br>
								<div class="row justify-content-center">
									<div class="col-7 text-center">
										<h5 class="purple-text text-center">You Have Successfully
											Added a Journey</h5>
									</div>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${not empty errorMessage}">
		<script>
			alert('${errorMessage}');
		</script>
	</c:if>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#submitBtn").click(function() {
				$("msform").submit();
			});
		});
	</script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="${external}progressbar/assets/progressbar.js"></script>


</body>
</html>