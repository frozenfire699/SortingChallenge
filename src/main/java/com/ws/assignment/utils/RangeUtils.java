package com.ws.assignment.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.was.assignment.model.RangeObject;

/**
 * Class that provides utility methods for the application
 * 
 * @author Rohit Gupta
 * @since March 2018
 * @version 1.0
 *
 */
public class RangeUtils {

    /**
     * Util method to convert a String based input range into an array
     * 
     * @param inputRange
     *            String input range
     * @return Array version of that input range
     */
    public static String[] getRange(String inputRange) {
        String[] range = new String[2];
        range[0] = inputRange.substring(1, 6);
        range[1] = inputRange.substring(7, 12);
        return range;
    }

    /**
     * Util method to convert a given set of range numbers into a formatted
     * range
     * 
     * @param highRange
     *            High end of the range yyyyy
     * @param lowRange
     *            Low end of the range xxxxx
     * @return formatted String of the range [xxxxx,yyyyy]
     */
    public static String getFormattedStringRange(String highRange,
            String lowRange) {
        String range = OptimizerConstants.SQUARE_START + lowRange
                + OptimizerConstants.COMMA + highRange
                + OptimizerConstants.SQUARE_END;

        return range;
    }

    /**
     * Util method to return a Map, whose keys are sorted based on lower ranges
     * 
     * @param list
     *            Input list of ranges
     * @return Map Integer keys sorted based on lower bound range and value as
     *         Range Objects
     */
    public static Map<Integer, RangeObject> getSortedMap(List<String> list) {
        Map<Integer, RangeObject> sortedMap = new TreeMap<>();
        for (String range : list) {
            RangeObject obj = new RangeObject(range);
            sortedMap.put(obj.getLowerBound(), obj);
        }

        return sortedMap;
    }

    /**
     * Util method to construct the input where each entry is one set of range
     * set
     * 
     * @return List which acts as the input to the Optimizer Client
     */

    public static List<String> getInputRange() {
        List<String> input = new ArrayList<>();
        input.add("[49679,52015]");
        input.add("[49800,50000]");
        input.add("[51500,53479]");
        input.add("[45012,46934]");
        input.add("[54012,59607]");
        input.add("[45500,45590]");
        input.add("[45999,47900]");
        input.add("[44000,45000]");
        input.add("[43012,45950]");

        return input;

    }
}
