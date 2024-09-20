package tw.com.nik.itinerarymanager.model.bean;

import java.sql.Time;
import java.util.Date;

public class Itinerary {

	private int itineraryId;
	private Date itineraryStartDate;
	private Date itineraryEndDate;
	private Time itineraryStartTime;
	private Time itineraryEndTime;
	private String itineraryName;
	private String destination;
	private String url;
	private String category;
	private String description;
	private String note;
	private Integer budget;
	private Boolean isPaid;
	private Boolean isChecked;
//	private Journey journey;
	private Integer journeyId;

	public int getItineraryId() {
		return itineraryId;
	}

	public void setItineraryId(int itineraryId) {
		this.itineraryId = itineraryId;
	}

	public Date getItineraryStartDate() {
		return itineraryStartDate;
	}

	public void setItineraryStartDate(Date itineraryStartDate) {
		this.itineraryStartDate = itineraryStartDate;
	}

	public Date getItineraryEndDate() {
		return itineraryEndDate;
	}

	public void setItineraryEndDate(Date itineraryEndDate) {
		this.itineraryEndDate = itineraryEndDate;
	}

	public Date getItineraryStartTime() {
		return itineraryStartTime;
	}

	public void setItineraryStartTime(Time itineraryStartTime) {
		this.itineraryStartTime = itineraryStartTime;
	}

	public Date getItineraryEndTime() {
		return itineraryEndTime;
	}

	public void setItineraryEndTime(Time itineraryEndTime) {
		this.itineraryEndTime = itineraryEndTime;
	}

	public String getItineraryName() {
		return itineraryName;
	}

	public void setItineraryName(String itineraryName) {
		this.itineraryName = itineraryName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public Boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(Boolean ifPaid) {
		this.isPaid = ifPaid;
	}

	public Boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(Boolean ifChecked) {
		this.isChecked = ifChecked;
	}

	public Integer getJourneyId() {
		return journeyId;
	}

	public void setJourneyId(Integer journeyId) {
		this.journeyId = journeyId;
	}

	@Override
	public String toString() {
		return "Itinerary [itineraryId=" + itineraryId + ", itineraryStartDate=" + itineraryStartDate
				+ ", itineraryEndDate=" + itineraryEndDate + ", itineraryStartTime=" + itineraryStartTime
				+ ", itineraryEndTime=" + itineraryEndTime + ", itineraryName=" + itineraryName + ", destination="
				+ destination + ", url=" + url + ", category=" + category + ", description=" + description + ", note="
				+ note + ", budget=" + budget + ", isPaid=" + isPaid + ", isChecked=" + isChecked + ", journeyId="
				+ journeyId + "]";
	}
}