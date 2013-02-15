package se.diversify.webroti.rest.vo;

/**
 * @author dvalfrid
 * @version 1.0
 */
public class VoteVO {
    private final Double value;
    
    public VoteVO(Double value){
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

}
