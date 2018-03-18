package com.ws.assignment.optimizer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.was.assignment.model.RangeObject;
import com.ws.assignment.utils.RangeUtils;

/**
 * This class optimizes the input range by identifying the overlapping ranges
 * and merging them to provide a list of merged ranges
 * 
 * @author Rohit Gupta
 * @since March 2018
 * @version 1.0
 */
public class RangeOptimizer {

    final static Logger log = Logger.getLogger(RangeOptimizer.class);

    /**
     * This method uses Stack and List data structures to process a given set of
     * input ranges and provides an optimized List of ranges keeping the
     * original constraints intact
     * 
     * @param sortedMap
     *            Validated and sorted set (based on lower bound) of input
     *            ranges
     * @return List of ranges which are optimized
     */

    public List<String> optimizeRanges(Map<Integer, RangeObject> sortedMap) {
        log.debug("Entering optimizeRanges() method of RangeOptimizer");

        List<String> optimizedList = new ArrayList<>();
        List<String> trackingList = new ArrayList<>();

        Iterator<Map.Entry<Integer, RangeObject>> mapIte = sortedMap.entrySet()
                .iterator();

        // push first range combination into tracking list
        pushRangeInTrackingList(trackingList, mapIte.next());

        // scan subsequent ranges to find if there is any overlap between
        // end of previous range and start of next range
        while (mapIte.hasNext()) {
            Map.Entry<Integer, RangeObject> entry = mapIte.next();
            RangeObject obj = entry.getValue();

            log.debug("Processing range:" + obj.getRange());

            int previousUpperBound = Integer.valueOf(trackingList.get(1));

            // compare start of new range with end of previous range
            if (obj.getLowerBound() <= previousUpperBound) {
                // overlap start
                if (obj.getUpperBound() > previousUpperBound) {
                    // Remove previous upperBound and add the new upperBound
                    trackingList.remove(1);
                    trackingList.add(obj.getStrUpperBound());
                    log.debug("Pushed new upper bound in tracking list"
                            + obj.getStrUpperBound());
                }

            } else {
                // overlap ends and push the optimized range in optimized list
                optimizedList.add(RangeUtils.getFormattedStringRange(
                        trackingList.remove(1), trackingList.remove(0)));

                // push the next set into stack for comparison
                pushRangeInTrackingList(trackingList, entry);

            }
        }
        // put the remaining range if any in the optimized list
        if (!trackingList.isEmpty())
            optimizedList.add(RangeUtils.getFormattedStringRange(
                    trackingList.remove(1), trackingList.remove(0)));

        log.debug("Exiting optimizeRanges() method of RangeOptimizer");
        return optimizedList;
    }

    /**
     * This method pushes a specific input range into the stack based on index
     * value passed
     * 
     * @param rangeStack
     *            Stack which contains the lower and upper bound range zip code
     * @param inputRange
     *            Input set of ranges
     * @param index
     *            Position of the input range set that needs to be pushed in the
     *            stack
     */
    private void pushRangeInTrackingList(List<String> trackingList,
            Map.Entry<Integer, RangeObject> entry) {
        RangeObject obj = entry.getValue();

        trackingList.add(obj.getStrLowerBound());
        log.debug("Pushed new lower bound in tracking list"
                + obj.getStrLowerBound());

        trackingList.add(obj.getStrUpperBound());
        log.debug("Pushed new upper bound in tracking list"
                + obj.getStrUpperBound());
    }

}
