<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${webName}-My Journey</title>
<jsp:include page="/WEB-INF/view/component/imports.jsp"></jsp:include>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="${external}card-with-map/assets/style.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.10/css/all.css"
	integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="/WEB-INF/view/component/header.jsp"></jsp:include>
	<div class="container">
		<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3">
			<c:forEach items="${myJourneys}" var="journey" varStatus="status">

				<div class="col-md-4 mt-5">
					<div class="card text-center">
						<img class="card-img-top" src="${journey.journeyPhoto} "
							alt="photo">
						<div class="card-body">
							<h5 class="card-title">${journey.journeyName}</h5>
							
							<c:set var="start" value="${journey.journeyStartDate}" />
							<c:set var="end" value="${journey.journeyEndDate}" />
							<c:if test="${start==null || end==null}">
								<h6 class="card-title">Undicided</h6>
							</c:if>
							<c:if test="${start!=null && end!=null}">
								<h6 class="card-title">${journey.journeyStartDate}~
									${journey.journeyEndDate}</h6>
							</c:if>
							<hr>
							<p>
								<a class="btn btn-primary" data-toggle="collapse"
									href="#collapseExample" role="button" aria-expanded="false"
									aria-controls="collapseExample"> <i class="fas fa-map"></i>
									Maps
								</a>
							</p>
							<div class="collapse" id="collapseExample">
								<div class="card card-body">
									<iframe
										src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d11880.492291371422!2d12.4922309!3d41.8902102!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x28f1c82e908503c4!2sColosseo!5e0!3m2!1sit!2sit!4v1524815927977"
										width="100%" height="200" frameborder="0" style="border: 0"
										allowfullscreen></iframe>
								</div>
							</div>
						</div>
						<div class="card-footer text-muted">
							<div class="row">
								<div class="col">
									<a href="#"><i class="fas fa-unlock"></i></a>
								</div>
								<div class="col">
									<a href="#"><i class="fas fa-keyboard"></i></a>
								</div>
								<div class="col">
									<a href="${context.getContextPath}/ItineraryManager/deleteJourney.do?journey_id=${journey.journeyId}"><i class="fas fa-trash"></i></a>
								</div>
							</div>
						</div>
					</div>
				</div>

			</c:forEach>

		</div>
	</div>


	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>