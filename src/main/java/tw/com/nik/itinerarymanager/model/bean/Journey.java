package tw.com.nik.itinerarymanager.model.bean;

import java.sql.Date;
import java.util.List;

public class Journey {

	private int journeyId;
	private String journeyName;
	private Date journeyStartDate;
	private Date journeyEndDate;
	private String journeyPhoto;
	private Boolean isPublic;
//	private Member member;
	private Integer memberId;

	private List<Itinerary> itineraries;

	public int getJourneyId() {
		return journeyId;
	}

	public void setJourneyId(int journeyId) {
		this.journeyId = journeyId;
	}

	public String getJourneyName() {
		return journeyName;
	}

	public void setJourneyName(String journeyName) {
		this.journeyName = journeyName;
	}

	public Date getJourneyStartDate() {
		return journeyStartDate;
	}

	public void setJourneyStartDate(Date journeyStartDate) {
		this.journeyStartDate = journeyStartDate;
	}

	public Date getJourneyEndDate() {
		return journeyEndDate;
	}

	public void setJourneyEndDate(Date journeyEndDate) {
		this.journeyEndDate = journeyEndDate;
	}

	public String getJourneyPhoto() {
		return journeyPhoto;
	}

	public void setJourneyPhoto(String journeyPhoto) {
		this.journeyPhoto = journeyPhoto;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
//
//	public Member getMember() {
//		return member;
//	}
//
//	public void setMember(Member member) {
//		this.member = member;
//	}

	public List<Itinerary> getItineraries() {
		return itineraries;
	}

	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}

	public Integer getMemberId() {
		return memberId;
	}
	
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Journey [journeyId=" + journeyId + ", journeyName=" + journeyName + ", journeyStartDate="
				+ journeyStartDate + ", journeyEndDate=" + journeyEndDate + ", isPublic=" + isPublic + ", memberId="
				+ memberId + ", itineraries=" + itineraries + "]";
	}
	


}
