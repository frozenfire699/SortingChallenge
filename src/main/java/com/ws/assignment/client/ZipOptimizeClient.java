package com.ws.assignment.client;

import java.util.List;
import java.util.Map;

import com.ws.assignment.optimizer.RangeOptimizer;
import com.ws.assignment.utils.RangeUtils;
import com.ws.assignment.validation.RangeValidator;
import com.was.assignment.model.RangeObject;
import org.apache.log4j.Logger;

/**
 * This class servers as the engine to optimize a given input of 5-digit ZIP
 * code range sets into minimum number of range sets, keeping the original input
 * constraints intact The input range is provided as command line argument and
 * the class performs validations on the input, and prints the final result on
 * the console
 *
 * @author Rohit Gupta
 * @since March 2018
 * @version 1.0
 */
public class ZipOptimizeClient {

    final static Logger log = Logger.getLogger(ZipOptimizeClient.class);

    /**
     * Driver method to start the application
     * @param args
     */
    public static void main(String[] args) {

        // get the input from Util class
        List<String> inputRange = RangeUtils.getInputRange();
        System.out.println(
                "----------------Input provided-------------------------");
        for (String range : inputRange)
            System.out.print(range);
        System.out.println("");

        try {
            // Validate inputs
            RangeValidator validator = new RangeValidator();
            validator.isValid(inputRange);

            // Sort the ranges based on the starting value
            Map<Integer, RangeObject> sortedMap = RangeUtils
                    .getSortedMap(inputRange);

            // optimize the ranges and print the result
            RangeOptimizer optimizer = new RangeOptimizer();
            List<String> optimizedList = optimizer.optimizeRanges(sortedMap);

            System.out.println(
                    "-----------Optimized List---------------------------");
            for (String range : optimizedList)
                System.out.print(range);

        }

        catch (IllegalArgumentException ex) {
            System.out.println(
                    "Input not processed.Please check log file for details");
            log.error(ex.getMessage());
        }

    }

}
