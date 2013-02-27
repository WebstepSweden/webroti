package se.diversify.webroti.rest.vo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

/**
 * An immutable object that contains information about the meeting.
 *
 * @author dvalfrid
 * @version 1.0
 */
public class MeetingVO {

    /** Unique key for a meeting */
    private final String id;
    /** Name of the meeting*/
    private final String name;
    /** All votes in the meeting*/
    private final List<VoteVO> votes;
    /** Average votes points*/
    private final String  average;

    private MeetingVO(BuilderImp builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.average = builder.getAverage();
        this.votes = builder.votes;
    }

    public String getName() {
        return name;
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

    public int getNumberOfVotes() {
        return votes.size();
    }

    public static Builder getBuilder() {
        return new BuilderImp();
    }

    private static class BuilderImp implements Builder {
        private final DecimalFormatSymbols symbols;
        private final DecimalFormat DF;
        private String id;
        private String name;
        private List<VoteVO> votes = new ArrayList<VoteVO>();

        private BuilderImp(){
            symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator('.');
            DF = new DecimalFormat("0.0", symbols);
        }

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

            return DF.format(votes.size() == 0 ? 0.0 : sum / votes.size());
        }


    }

    public interface Builder {
        Builder id(String value);
        Builder name(String value);
        Builder add(VoteVO value);
        MeetingVO build();
    }

}
