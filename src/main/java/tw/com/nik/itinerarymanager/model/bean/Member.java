package tw.com.nik.itinerarymanager.model.bean;

import java.util.List;

public class Member {
	
	private int memberId;
	private String memberAccount;
	private String memberPassword;
	private String memberName;
	private Integer memberAge;
	private String memberPhoto;
	private List<Journey> journeys;
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(String memberAccount) {
		this.memberAccount = memberAccount;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Integer getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(Integer memberAge) {
		this.memberAge = memberAge;
	}
	public String getMemberPhoto() {
		return memberPhoto;
	}
	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
	}
	
	public List<Journey> getJourneys() {
		return journeys;
	}
	public void setJourneys(List<Journey> journeys) {
		this.journeys = journeys;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberAccount=" + memberAccount + ", memberPassword="
				+ memberPassword + ", memberName=" + memberName + ", memberAge=" + memberAge + ", memberPhoto="
				+ memberPhoto + ", journeys=" + journeys + "]";
	}
		
}
