package se.diversify.webroti.rest.vo;

/**
 * @author dvalfrid
 * @version 1.0
 */
public class Vote {
    private final Double value;
    private final String meetingId;
    
    public Vote(Double value, String meetingId){
        this.value = value;
        this.meetingId = meetingId;
    }

    public Double getValue() {
        return value;
    }

    public String getMeetingId() {
    	return meetingId;
    }
}
