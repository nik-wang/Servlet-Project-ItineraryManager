<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${webName}-Itinerary</title>
<jsp:include page="/WEB-INF/view/component/imports.jsp"></jsp:include>
<link rel="stylesheet" href="${external}schedule-list/assets/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">

</head>
<body>
	<jsp:include page="/WEB-INF/view/component/header.jsp"></jsp:include>

	<%-- 	<h1>Itineraries for Journey ID: ${param.journeyId}</h1>
	<ul>
		<c:forEach items="${itineraries}" var="itinerary" varStatus="status">
			<li>${itinerary.itineraryName}</li>
		</c:forEach>
	</ul> --%>

	<div class="container py-7" style="margin-top:70px">
<!-- 		<h2 -->
<!-- 			class="text-uppercase text-letter-spacing-xs my-0 text-primary font-weight-bold"> -->
<%-- 			ID: ${param.journeyId}</h2> --%>
<!-- 		<p class="text-sm text-dark mt-0 mb-5">There's time and place for -->
<!-- 			everything.</p> -->
		<!-- Days -->
		<div class="row">
			<c:forEach items="${itinerariesByDate}" var="entry">
				<div class="col-lg-4 mb-3" id="${entry.key}">
					<h4 class="mt-0 mb-3 text-dark op-8 font-weight-bold">
						<fmt:formatDate value="${entry.key}" pattern="EEEE, MMM d" />
					</h4>
					<ul class="list-timeline list-timeline-primary">
						<c:forEach items="${entry.value}" var="itinerary">
							<!--               <li class="list-timeline-item show p-0 pb-3 pb-lg-4 d-flex flex-wrap flex-column" data-toggle="collapse" data-target="#day-1-item-2"> -->
							<!--                 <p class="my-0 text-dark flex-fw text-sm text-uppercase"><span class="text-primary font-weight-bold op-8 infinite animated flash" data-animate="flash" data-animate-infinite="1" data-animate-duration="3.5" style="animation-duration: 3.5s;">Now</span> - Vitaly Friedmann</p> -->
							<!--                 <p class="my-0 collapse flex-fw text-uppercase text-xs text-dark op-8 show" id="day-1-item-2"> Talk: Wireframing / <span class="text-primary">Room 19</span> </p> -->
							<!--               </li> -->

							<li
								class="list-timeline-item p-0 pb-3 pb-lg-4 d-flex flex-wrap flex-column"
								data-toggle="collapse" data-target="#day-1-item-4">
								<p class="my-0 text-dark flex-fw text-sm text-uppercase">
									<span class="text-inverse op-8"> <fmt:formatDate
											value="${itinerary.itineraryStartTime}" pattern="HH:mm" /> -
										<fmt:formatDate value="${itinerary.itineraryEndTime}"
											pattern="HH:mm" />
									</span> ${itinerary.itineraryName}
								</p>
								<p
									class="my-0 collapse flex-fw text-uppercase text-xs text-dark op-8"
									id="day-1-item-4">
									Description <span class="text-primary">${itinerary.description}</span>
								</p>
								<p
									class="my-0 collapse flex-fw text-uppercase text-xs text-dark op-8"
									id="day-1-item-4">
									Category <span class="text-primary">${itinerary.category}</span>
								</p>
									<p
									class="my-0 collapse flex-fw text-uppercase text-xs text-dark op-8"
									id="day-1-item-4">
									Budget <span class="text-primary">${itinerary.budget}</span>
								</p>
									<p
									class="my-0 collapse flex-fw text-uppercase text-xs text-dark op-8"
									id="day-1-item-4">
									Note <span class="text-primary">${itinerary.note}</span>
								</p>
								<p
									class="my-0 collapse flex-fw text-uppercase text-xs text-dark op-8"
									id="day-1-item-4">
									URL <span class="text-primary">${itinerary.url}</span>
								</p>
							</li>
						</c:forEach>

					</ul>
				</div>

			</c:forEach>

		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>