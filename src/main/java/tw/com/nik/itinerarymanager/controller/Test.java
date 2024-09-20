package tw.com.nik.itinerarymanager.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.nik.itinerarymanager.model.bean.Journey;
import tw.com.nik.itinerarymanager.model.dao.JourneyDAOImpl;
import tw.com.nik.itinerarymanager.util.ConnectionFactory;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		try (Connection conn = ConnectionFactory.getConnection()) {
//
//			PreparedStatement prepareStatement = conn.prepareStatement(
//					"INSERT into Member(member_account, member_password, member_name)\n" + "  VALUES(?,?,?)");
//
//			Member m = new Member();
//			m.setMemberAccount("abc");
//			m.setMemberPassword("jfio39");
//			m.setMemberName("itsme");
//
//			prepareStatement.setString(1, m.getMemberAccount());
//			prepareStatement.setString(2, m.getMemberPassword());
//			prepareStatement.setString(3, m.getMemberName());
//
//			prepareStatement.executeUpdate();
//			prepareStatement.close();
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//     ==========================	
//		Member m= new Member();
//		m.setMemberAccount("FML");
//		m.setMemberPassword("please");
//		m.setMemberName("Give Me a Sign");
//		
//		try(Connection conn = ConnectionFactory.getConnection()){
//			
//			MemberDAOImpl memberDAOImpl = new MemberDAOImpl(conn);
//			memberDAOImpl.createMember(m);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		=========================
//		Member m= new Member();
//		m.setMemberId(3);
//		m.setMemberAccount("Test");
//		m.setMemberPassword("1154");
//		m.setMemberName("Me");
//		
//		try(Connection conn = ConnectionFactory.getConnection()){
//			
//		MemberService memberService = new MemberService();
//		memberService.updateMemberById(m);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			
//			
//			MemberDAOImpl memberDAOImpl = new MemberDAOImpl(conn);
//			memberDAOImpl.createMember(m);
		
//		Journey j = new Journey();
//		j.setJourneyName("tw");
//		
//		
//		try(Connection conn = ConnectionFactory.getConnection()){
//			JourneyDAOImpl journeyDAOImpl = new JourneyDAOImpl(conn);
//			journeyDAOImpl.createJourney(j);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
