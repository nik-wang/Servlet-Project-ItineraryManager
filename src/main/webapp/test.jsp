<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="msform"
		action="${context.getContextPath}/ItineraryManager/addJourney.do"
		method="post" enctype="multipart/form-data">

		<fieldset>
			<div class="form-card">
				<div class="row">
					<div class="col-7">
						<h2 class="fs-title">Journey Details:</h2>
					</div>
				</div>
				<label class="fieldlabels">Journey Name: *</label> <input
					type="text" name="journey_name" required /> <label class="fieldlabels">Start
					Date: </label> 
					<input type="date" name="journey_start_date"
					/> 
					<label class="fieldlabels">End
					Date: </label> <input type="date" name="journey_end_date"
					 />
<!-- 					 這邊輸入id -->
<label class="fieldlabels">MemberId: </label> <input type="text" name="fk_member_id"
					 />
					 
			</div>
			<input type="submit" name="next" class="next action-button"
				value="Next" />
		</fieldset>
		<fieldset>
			<div class="form-card">
				<div class="row">
					<div class="col-7">
						<h2 class="fs-title">Additional:</h2>
					</div>
				</div>
				
					 <label
					class="fieldlabels">Visability: </label>
				<div style="display: flex; align-items: center;">
					<input
						type="radio" id="private" name="is_public" value="0"> 
						<label for="private"
						>Private</label>
					
					<input type="radio"
						id="public" name="is_public" value="1"
						> 
						<label for="public"
						>Public</label>
					
					<label class="fieldlabels">Notes: </label> <input type="text"
									name="notes" style="border-radius: 10px" />
				</div>
			</div>
			<input type="button" name="next" class="next action-button"
				value="Next" />
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
				<label class="fieldlabels">Upload Your Journey Cover: <input
					type="file" name="journey_photo" accept="image/*"></label>
			</div>
			<input type="submit" name="next" class="next action-button"
				value="Submit" />
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
				<h2 class="purple-text text-center">
					<strong>PERFECT !</strong>
				</h2>
			</div>
		</fieldset>
	</form>
</body>
</html>