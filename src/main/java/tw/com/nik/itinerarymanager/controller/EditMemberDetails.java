package tw.com.nik.itinerarymanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.sqlserver.jdbc.StringUtils;

import tw.com.nik.itinerarymanager.model.bean.Member;
import tw.com.nik.itinerarymanager.service.MemberService;

@WebServlet("/editMemberDetails.do")
@MultipartConfig
public class EditMemberDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Member loggedInMember=(Member)request.getSession().getAttribute("loggedInMember");
		
		Integer memberId = Integer.valueOf(request.getParameter("member_id"));
		String memberAccount = request.getParameter("member_account");
		String memberPassword = request.getParameter("member_password");
		String memberName = request.getParameter("member_name");

		Integer memberAge = StringUtils.isNumeric(request.getParameter("member_age"))
				? Integer.valueOf(request.getParameter("member_age"))
				: null;		
		// 封裝資料
		loggedInMember.setMemberId(memberId);
		loggedInMember.setMemberAccount(memberAccount);
		loggedInMember.setMemberPassword(memberPassword);
		loggedInMember.setMemberName(memberName);
		loggedInMember.setMemberAge(memberAge);
		
		MemberService memberService = new MemberService();
		

		try {
			memberService.editMemberDetails(loggedInMember);
			// 更新 Session 中的會員資料
			request.getSession().setAttribute("loggedInMember", loggedInMember);
			// 重定向到會員資料頁面
			response.sendRedirect("profile");
			;
		} catch (Exception e) {
			// 更新失敗處理邏輯
			request.setAttribute("error", "Fail to update details. Please try again later.");
			request.getRequestDispatcher("/edit_details").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
