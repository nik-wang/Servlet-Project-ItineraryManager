<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${webName}-Register</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${external}registration/assets/css/style.css">
</head>
<body id="body">
	<jsp:include page="/WEB-INF/view/component/header.jsp"></jsp:include>
	<h1 style="color: #fff">Sign Up</h1>

	<div class="registration-form">
		<form action="${context.getContextPath}/ItineraryManager/register.do"
			method="post" enctype="multipart/form-data">
			<div class="form-icon">
				<span><i class="icon icon-user"></i></span>
			</div>
			<div class="form-group">
				<input type="text" class="form-control item" name="member_account"
					placeholder="* Account Number" required>
			</div>
			<div class="form-group">
				<input type="password" class="form-control item"
					name="member_password" placeholder="* Password" required>
			</div>
			<div class="form-group">
				<input type="text" class="form-control item" name="member_name"
					placeholder="* Nickname" required>
			</div>
			<div class="form-group">
				<input type="text" class="form-control item" name="member_age"
					placeholder="Age">
			</div>
			<div class="form-group">
				<label for="photo" class="form-control item"> Upload Profile
					Photo <input type="file" name="member_photo" accept="image/*"
					class="file">
				</label>

			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-block create-account">Register</button>
			</div>

			<div class="follow-up-question">
				<span>Already have an account?</span> <a href="${root}/login"> <span
					class="bottom-link">Login here</span>
				</a>
			</div>

		</form>
		<div class="social-media">
			<h5>Sign up with social media</h5>
			<div class="social-icons">
				<a href="#"><i class="icon-social-facebook" title="Facebook"></i></a>
				<a href="#"><i class="icon-social-google" title="Google"></i></a> <a
					href="#"><i class="icon-social-twitter" title="Twitter"></i></a>
			</div>
		</div>
	</div>


	<c:if test="${not empty errorMessage}">
		<script>
			alert('${errorMessage}');
		</script>
	</c:if>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
	<script src="${external}registration/assets/js/script.js"></script>
</body>
</html>