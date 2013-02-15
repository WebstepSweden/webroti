package se.diversify.webroti.rest.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dvalfrid
 * @version 1.0
 */
public class Meeting {
    private final String id;
    private final List<Vote> votes;

    private Meeting(BuilderImp builder) {
        this.id = builder.id;
        this.votes = builder.votes;
    }

    public String getId() {
        return id;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public Double getAverage() {
        double sum = 0.0;
        for(Vote vote : votes){
            sum += vote.getValue();
        }
        return sum / votes.size();
    }

    public int getNumberOfVotes() {
        return votes.size();
    }

    public static Builder getBuilder() {
        return new BuilderImp();
    }

    private static class BuilderImp implements Builder {
        private String id;
        private List<Vote> votes = new ArrayList<Vote>();

        @Override
        public Builder id(String value) {
            this.id = value;
            return this;
        }

        @Override
        public Builder add(Vote value) {
           this.votes.add(value);
           return this;
        }

        @Override
        public Meeting build() {
            return new Meeting(this);
        }


    }

    public interface Builder {
        Builder id(String value);
        Builder add(Vote value);
        Meeting build();
    }

}
