package com.was.assignment.model;

/**
 * Model class for Range object that contains String and Integer values for
 * Lower and Upper Bound of ranges
 * 
 * @author Rohit Gupta
 * @since March 2018
 * @version 1.0
 *
 */
public class RangeObject {

    private String strLowerBound; // required to make sure leading 0s are not
                                  // lost
    private String strUpperBound; // required to make sure leading 0s are not
                                  // lost
    private int lowerBound;
    private int upperBound;
    private String range;

    public RangeObject(String range) {
        this.range = range;
        this.strLowerBound = range.substring(1, 6);
        this.strUpperBound = range.substring(7, 12);
        this.lowerBound = Integer.valueOf(this.strLowerBound);
        this.upperBound = Integer.valueOf(this.strUpperBound);
    }

    /**
     * @return the strUpperBound
     */
    public String getStrUpperBound() {
        return strUpperBound;
    }

    /**
     * @return the lowerBound
     */
    public int getLowerBound() {
        return lowerBound;
    }

    /**
     * @return the upperBound
     */
    public int getUpperBound() {
        return upperBound;
    }

    /**
     * @return the strLowerBound
     */
    public String getStrLowerBound() {
        return strLowerBound;
    }

    /**
     * @return the range
     */
    public String getRange() {
        return range;
    }

}
