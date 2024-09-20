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

import tw.com.nik.itinerarymanager.model.bean.Member;
import tw.com.nik.itinerarymanager.service.MemberService;


@WebServlet("/changeMemberPhoto.do")
@MultipartConfig
public class ChangeMemberPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Member loggedInMember=(Member)request.getSession().getAttribute("loggedInMember");
		
		Integer memberId = Integer.valueOf(request.getParameter("member_id"));
//		System.out.println(memberId);
		Part memberPhotoPart = request.getPart("member_photo");
		
		String memberPhotoBase64;
		if (memberPhotoPart != null && memberPhotoPart.getSize() > 0) {
			BufferedInputStream bis = new BufferedInputStream(memberPhotoPart.getInputStream());
			memberPhotoBase64 = "data:image/png;base64," + Base64.getEncoder().encodeToString(bis.readAllBytes());
			bis.close();
		} else {
			memberPhotoBase64 = null;
		}
		
		//封裝資料
		loggedInMember.setMemberId(memberId);
		loggedInMember.setMemberPhoto(memberPhotoBase64);
		
		MemberService memberService = new MemberService();
		
		try {
			memberService.changeMemberPhoto(loggedInMember);
			// 更新 Session 中的會員資料
			request.getSession().setAttribute("loggedInMember", loggedInMember);
			// 重定向到會員資料頁面
			response.sendRedirect("profile");
			;
		} catch (Exception e) {
			// 更新失敗處理邏輯
			request.setAttribute("photoError", "Fail to change photo. Please try again later.");
			request.getRequestDispatcher("/profile").forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
