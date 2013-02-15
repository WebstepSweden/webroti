package se.diversify.webroti.data;

import se.diversify.webroti.time.SystemTime;

import java.util.ArrayList;
import java.util.List;

/**
 * A meeting
 */
public class Meeting {

    private final String id;
    private final List<Vote> votes = new ArrayList<Vote>();
    private Long lastTouched;

    /**
     * Create a new meeting
     */
    public Meeting(String id) {
        this.id = id;
    }

    public Long getLastTouched() {
        return lastTouched;
    }

    /**
     * Get the list of votes for this meeting
     * @return the list of votes for this meeting
     */
    public List<Vote> getVotes() {
        synchronized (votes){
            return new ArrayList<Vote>(votes);
        }
    }

    /**
     * Get the meeting id
     * @return the meeting id
     */
    public String getId() {
        return id;
    }

    /**
     * Add a vote for this meeting
     * @param vote the new vote to add
     */
    public void addVote(Vote vote) {
        synchronized (votes){
            votes.add(vote);
        }
    }

    public Meeting touch() {
        lastTouched = SystemTime.now();
        return this;
    }
}
