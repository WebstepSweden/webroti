package se.diversify.webroti.data;

import se.diversify.webroti.time.SystemTime;

import java.util.ArrayList;
import java.util.List;

/**
 * A @{link Meeting} is an immutable object (except for the lastTouched flag)
 * containing information about a meeting.
 */
public class Meeting {

    /** Unique key for a meeting*/
    private final String id;
    /** Name of the meeteing*/
    private final String name;
    /** All votes in the meeting*/
    private final List<Vote> votes = new ArrayList<Vote>();
    /** When the instance was last touched*/
    private Long lastTouched;

    private Meeting(BuilderImpl builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.votes.addAll(builder.votes);
    }

    /**
     * When the object was touched the last time
     * @return Time as a Long
     */
    public Long getLastTouched() {
        return lastTouched;
    }

    /**
     * Get the meeting name
     * @return the meeting name
     */
    public String getName() {
        return name;
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

    public static Builder getBuilder() {
        return new BuilderImpl();
    }

    private static class BuilderImpl implements Builder {
        private String id;
        private String name;
        private List<Vote> votes = new ArrayList<Vote>();

        @Override
        public Builder id(String value) {
            this.id = value;
            return this;
        }

        @Override
        public Builder name(String value) {
            this.name = value;
            return this;
        }

        @Override
        public Builder add(Vote value) {
            this.votes.add(value);
            return this;
        }

        @Override
        public Meeting build() {
            if(name == null) {
                name = "";
            }
            return new Meeting(this);
        }
    }

    public interface Builder {
        Builder id(String value);
        Builder name(String value);
        Builder add(Vote value);
        Meeting build();
    }
}
