package tw.com.nik.itinerarymanager.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.catalina.tribes.membership.MemberImpl;

import tw.com.nik.itinerarymanager.model.bean.Member;
import tw.com.nik.itinerarymanager.model.dao.MemberDAOImpl;
import tw.com.nik.itinerarymanager.util.ConnectionFactory;

public class MemberService {
	
	public void addMember(Member member) {
		try(Connection conn = ConnectionFactory.getConnection()){
			
			MemberDAOImpl memberDAOImpl = new MemberDAOImpl(conn);
			memberDAOImpl.createMember(member);
			
		} catch (Exception e) {
			throw new RuntimeException("Fail to register: "+ e.getMessage());
		}
	}
	
	public Member getMemberById(Integer memberId) {
		try(Connection conn =ConnectionFactory.getConnection()){
			
			MemberDAOImpl memberDAOImpl = new MemberDAOImpl(conn);
			Member member = memberDAOImpl.findMemberById(memberId);
			
			return member;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Member login(String memberAccount, String memberPassword) {
		
		try(Connection conn = ConnectionFactory.getConnection()){		
			
			MemberDAOImpl memberDAOImpl = new MemberDAOImpl(conn);
			Member member = memberDAOImpl.findMemberByAccountAndPassword(memberAccount, memberPassword);
			
			return member;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void editMemberDetails(Member member) {
		try(Connection conn = ConnectionFactory.getConnection()){
			
			MemberDAOImpl memberDAOImpl = new MemberDAOImpl(conn);
			memberDAOImpl.updateMemberDetailsById(member);
			
		} catch (Exception e) {
			throw new RuntimeException("Fail to update details: "+ e.getMessage());
		}
		
	}
	
	public void changeMemberPhoto(Member member) {
		try(Connection conn = ConnectionFactory.getConnection()){
			
			MemberDAOImpl memberDAOImpl = new MemberDAOImpl(conn);
			memberDAOImpl.updateMemberDetailsById(member);
			
		} catch (Exception e) {
			throw new RuntimeException("Fail to change photo: "+ e.getMessage());
		}
		
	}
	
	public void deleteMemberById(int MemberId) {
		try(Connection conn = ConnectionFactory.getConnection()){
			
			MemberDAOImpl memberDAOImpl = new MemberDAOImpl(conn);
			memberDAOImpl.deleteMemberById(MemberId);
			
		} catch (Exception e) {
			throw new RuntimeException("Fail to delete account: "+ e.getMessage());
		}
	}

}
