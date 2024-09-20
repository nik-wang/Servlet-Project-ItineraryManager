package tw.com.nik.itinerarymanager.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.microsoft.sqlserver.jdbc.StringUtils;

import tw.com.nik.itinerarymanager.model.bean.Member;
import tw.com.nik.itinerarymanager.service.MemberService;

@WebServlet("/register.do")
@MultipartConfig
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String memberAccount = request.getParameter("member_account");
		String memberPassword = request.getParameter("member_password");
		String memberName = request.getParameter("member_name");

		Integer memberAge = StringUtils.isNumeric(request.getParameter("member_age"))
				? Integer.valueOf(request.getParameter("member_age"))
				: null;
		
		Part memberPhotoPart = request.getPart("member_photo");
		String memberPhotoBase64;
		if (memberPhotoPart != null && memberPhotoPart.getSize() > 0) {
			BufferedInputStream bis = new BufferedInputStream(memberPhotoPart.getInputStream());
			memberPhotoBase64 = "data:image/png;base64," + Base64.getEncoder().encodeToString(bis.readAllBytes());
			bis.close();
		} else {
			memberPhotoBase64 = null;
		}

		// 封裝資料
		Member member = new Member();
		member.setMemberAccount(memberAccount);
		member.setMemberPassword(memberPassword);
		member.setMemberName(memberName);
		member.setMemberAge(memberAge);
		member.setMemberPhoto(memberPhotoBase64);

		MemberService memberService = new MemberService();
		try {
			memberService.addMember(member);
			request.getSession().setAttribute("loggedInMember", member);
			response.sendRedirect("index");
		} catch (Exception e) {
			request.setAttribute("errorMessage", "Registration failed. Account Number may be used.");
			request.getRequestDispatcher("register").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
