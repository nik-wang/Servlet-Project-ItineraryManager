package tw.com.nik.itinerarymanager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.nik.itinerarymanager.model.bean.Member;
import tw.com.nik.itinerarymanager.service.MemberService;


@WebServlet("/profile.do")
public class TestGetMemberProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String memberId = request.getParameter("member_id");
//		
//		MemberService memberService = new MemberService();
//		Member member = memberService.getMemberById(Integer.valueOf(memberId));
//		
//		request.setAttribute("member", member);
//		request.getRequestDispatcher("profile").forward(request, response);
//		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
