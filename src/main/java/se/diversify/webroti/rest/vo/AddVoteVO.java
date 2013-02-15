package se.diversify.webroti.rest.vo;

/**
 * @author dvalfrid
 * @version 1.0
 */
public class AddVoteVO {
    private Double value;
    private String meetingId;
    
	public AddVoteVO(Double value, String meetingId){
        this.value = value;
        this.meetingId = meetingId;
    }

    public void setValue(Double value) {
		this.value = value;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

    public Double getValue() {
        return value;
    }

    public String getMeetingId() {
    	return meetingId;
    }

    
}
