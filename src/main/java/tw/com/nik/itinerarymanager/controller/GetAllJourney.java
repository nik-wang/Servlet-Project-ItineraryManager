package tw.com.nik.itinerarymanager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.nik.itinerarymanager.model.bean.Journey;
import tw.com.nik.itinerarymanager.service.JourneyService;
import tw.com.nik.itinerarymanager.util.PathConverter;

@WebServlet("/all_journey")
public class GetAllJourney extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		JourneyService journeyService = new JourneyService();
		List<Journey> journeys = journeyService.getAllJourney();
		
		request.getServletContext().setAttribute("allJourney", journeys);
		request.getRequestDispatcher(PathConverter.convertToWebInfPath(request.getServletPath())).forward(request,
				response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
