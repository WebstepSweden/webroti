package se.diversify.webroti.rest.vo;

/**
 * @author dvalfrid
 * @version 1.0
 */
public class AddVoteVO {
    private Double vote;
    private String meetingId;
    
	public AddVoteVO(Double vote, String meetingId){
        this.vote = vote;
        this.meetingId = meetingId;
    }

    public void setVote(Double vote) {
		this.vote = vote;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

    public Double getVote() {
        return vote;
    }

    public String getMeetingId() {
    	return meetingId;
    }

    
}
