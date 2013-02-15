package se.diversify.webroti.rest.vo;

/**
 * @author dvalfrid
 * @version 1.0
 */
public class Vote {
    private final Double value;

    public Vote(Double value){
        this.value = value;
    }

    public Double getValue() {
        return value;
    }
}
