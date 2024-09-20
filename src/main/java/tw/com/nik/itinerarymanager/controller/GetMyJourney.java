package tw.com.nik.itinerarymanager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.nik.itinerarymanager.model.bean.Journey;
import tw.com.nik.itinerarymanager.model.bean.Member;
import tw.com.nik.itinerarymanager.service.JourneyService;
import tw.com.nik.itinerarymanager.util.PathConverter;


@WebServlet("/my_journey")
public class GetMyJourney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Member loggedInMember=(Member)request.getSession().getAttribute("loggedInMember");
		
		
		JourneyService journeyService = new JourneyService();
		List<Journey> journeys = journeyService.getJourneyByMemberId(loggedInMember.getMemberId());
		
		request.getSession().setAttribute("myJourneys", journeys);
		request.getRequestDispatcher(PathConverter.convertToWebInfPath(request.getServletPath())).forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
