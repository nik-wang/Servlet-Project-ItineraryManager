package tw.com.nik.itinerarymanager.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Base64;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.microsoft.sqlserver.jdbc.StringUtils;

import tw.com.nik.itinerarymanager.model.bean.Journey;
import tw.com.nik.itinerarymanager.service.JourneyService;

@WebServlet("/addJourney.do")
@MultipartConfig
public class AddJourney extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String journeyName = request.getParameter("journey_name");

		String journeyStartString = request.getParameter("journey_start_date");
		String journeyEndString = request.getParameter("journey_end_date");

		Date journeyStartDate;
		if (!journeyStartString.isEmpty()) {
			journeyStartDate = Date.valueOf(journeyStartString);
		} else {
			journeyStartDate = null;
		}

		Date journeyEndDate;
		if (!journeyEndString.isEmpty()) {
			journeyEndDate = Date.valueOf(journeyEndString);
		} else {
			journeyEndDate = null;
		}

		Part journeyPhotoPart = request.getPart("journey_photo");
		String journeyPhotoBase64;
		if (journeyPhotoPart != null && journeyPhotoPart.getSize() > 0) {
			BufferedInputStream bis = new BufferedInputStream(journeyPhotoPart.getInputStream());
			journeyPhotoBase64 = "data:image/jpg;base64," + Base64.getEncoder().encodeToString(bis.readAllBytes());
		} else {
			journeyPhotoBase64 = null;
		}

		Boolean isPublic;
		String isPublicString = request.getParameter("is_public");
		if (isPublicString != null) {
			isPublic = Boolean.parseBoolean(isPublicString);
		} else {
			isPublic = null;
		}

		Integer memberIdFk = StringUtils.isNumeric(request.getParameter("member_id"))
				? Integer.valueOf(request.getParameter("member_id"))
				: null;

		// 封裝資料
		Journey journey = new Journey();
		journey.setJourneyName(journeyName);
		journey.setJourneyStartDate(journeyStartDate);
		journey.setJourneyEndDate(journeyEndDate);
		journey.setJourneyPhoto(journeyPhotoBase64);
		journey.setIsPublic(isPublic);
		journey.setMemberId(memberIdFk);
		
		JourneyService journeyService = new JourneyService();
		try {
			journeyService.addJourney(journey);
			request.getSession().setAttribute("journey", journey);
			response.sendRedirect("index");
		} catch (Exception e) {	
			request.setAttribute("addJourneyErrorMessage", "Failed to add journey. Please try again later.");
			request.getRequestDispatcher("add_journey").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
