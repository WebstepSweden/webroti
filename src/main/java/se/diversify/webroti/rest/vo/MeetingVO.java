package se.diversify.webroti.rest.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dvalfrid
 * @version 1.0
 */
public class MeetingVO {
    private final String id;
    private final List<VoteVO> votes;

    private MeetingVO(BuilderImp builder) {
        this.id = builder.id;
        this.votes = builder.votes;
    }

    public String getId() {
        return id;
    }

    public List<VoteVO> getVotes() {
        return votes;
    }

    public Double getAverage() {
        double sum = 0.0;
        for(VoteVO vote : votes){
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
        private List<VoteVO> votes = new ArrayList<VoteVO>();

        @Override
        public Builder id(String value) {
            this.id = value;
            return this;
        }

        @Override
        public Builder add(VoteVO value) {
           this.votes.add(value);
           return this;
        }

        @Override
        public MeetingVO build() {
            return new MeetingVO(this);
        }


    }

    public interface Builder {
        Builder id(String value);
        Builder add(VoteVO value);
        MeetingVO build();
    }

}
