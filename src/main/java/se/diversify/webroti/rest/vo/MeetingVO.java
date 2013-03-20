package se.diversify.webroti.rest.vo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dvalfrid
 * @version 1.0
 */
public class MeetingVO {
    private static DecimalFormat DF = new DecimalFormat("0.0");

    private final String id;
    private final List<VoteVO> votes;
    private final String  average;
    private final String min;
    private final String max;

    private MeetingVO(BuilderImp builder) {
        this.id = builder.id;
        this.average = builder.getAverage();
        this.votes = builder.votes;
        this.min = builder.getMin();
        this.max = builder.getMax();
    }

    public String getId() {
        return id;
    }

    public List<VoteVO> getVotes() {
        return votes;
    }

    public String getAverage() {
        return average;
    }

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
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

        private String getAverage() {
            double sum = 0.0;
            for(VoteVO vote : votes){
                sum += vote.getValue();
            }

            return votes.size() == 0 ? "-" : DF.format(sum / votes.size());
        }

        public String getMin() {
            double min = 5.0;

            for(VoteVO vote : votes){
                min = Math.min(min, vote.getValue());
            }

            return votes.size() == 0 ? "" : DF.format(min);
        }

        public String getMax() {
            double max = 0.0;

            for(VoteVO vote : votes){
                max = Math.max(max, vote.getValue());
            }

            return votes.size() == 0 ? "" : DF.format(max);
        }
    }

    public interface Builder {
        Builder id(String value);
        Builder add(VoteVO value);
        MeetingVO build();
    }

}
