package tw.com.nik.itinerarymanager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.nik.itinerarymanager.model.bean.Member;
import tw.com.nik.itinerarymanager.service.MemberService;

@WebServlet("/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String memberAccount = request.getParameter("member_account");
		String memberPassword = request.getParameter("member_password");

		MemberService memberService = new MemberService();
		Member member = memberService.login(memberAccount, memberPassword);

		if (member == null) {
			request.getSession().setAttribute("message",
					"The password is incorrect or the account number cannot be recognized.");
			response.sendRedirect("login");

			return;
		}

		if (member != null) {
			request.getSession().setAttribute("loggedInMember", member);
			response.sendRedirect("index");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
