package tw.com.nik.itinerarymanager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.nik.itinerarymanager.model.bean.Member;
import tw.com.nik.itinerarymanager.service.MemberService;

@WebServlet("/deleteMember.do")
@MultipartConfig
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		Member loggedInMember = (Member) request.getSession().getAttribute("loggedInMember");
		int loggedInMemberId = loggedInMember.getMemberId();
		
		request.getSession().setAttribute("deleteMemberId", loggedInMemberId);

		MemberService memberService = new MemberService();
		memberService.deleteMemberById(loggedInMemberId);

		response.sendRedirect("index");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
