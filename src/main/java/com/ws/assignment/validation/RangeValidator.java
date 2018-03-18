package com.ws.assignment.validation;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.ws.assignment.utils.ErrorCodes;
import com.ws.assignment.optimizer.RangeOptimizer;
import com.ws.assignment.utils.OptimizerConstants;
import com.ws.assignment.utils.RangeUtils;

/**
 * This class validates a given set of input ranges
 * 
 * @author Rohit Gupta
 * @since March 2018
 * @version 1.0
 *
 */
public class RangeValidator {

    final static Logger log = Logger.getLogger(RangeOptimizer.class);

    /**
     * Checks if given input is valid or not
     * 
     * @param input
     *            List of ranges
     * @return boolean True if input is valid
     * @throws IllegalArgumentException
     *             if the input is invalid
     */
    public boolean isValid(List<String> input) throws IllegalArgumentException {
        log.debug("Entering isValid() method of RangeValidator");

        isNullOrEmpty(input);
        isValidFormat(input);

        log.debug("Exiting isValid() method of RangeValidator");

        return true;
    }

    /**
     * Checks for the given input if it is empty or null
     * 
     * @param input
     *            Input range like [12345,12367], or [];
     * @throws IllegalArgumentException
     *             if the input is invalid
     */
    public void isNullOrEmpty(List<String> input)
            throws IllegalArgumentException {
        log.debug("Checking for Null or Empty");

        // check for empty input
        if (input == null || input.size() == 0) {
            log.error(ErrorCodes.INV_INPUT_MESSAGE_002);
            throw new IllegalArgumentException(
                    ErrorCodes.INV_INPUT_MESSAGE_002);
        }
    }

    /**
     * Checks for the given input if the given set of ranges is in valid format
     * "[xxxxx,xxxxx]" where xxxxx denotes a 5 digit number
     * 
     * @param input
     *            : Input range like [94133,94133][94200,94299][94600,94699] or
     *            {94133,94133) or [9412,94133]
     * @throws IllegalArgumentException
     *             if the input is invalid
     */
    public void isValidFormat(List<String> input)
            throws IllegalArgumentException {
        // scan each input range and validate its format
        for (String range : input) {
            log.debug("Checking format for input range:" + input);

            if (!Pattern.matches(OptimizerConstants.RANGE_REGEX, range)) {
                log.error(ErrorCodes.INV_INPUT_MESSAGE_001 + range);
                throw new IllegalArgumentException(
                        ErrorCodes.INV_INPUT_MESSAGE_001);
            }

            // check for valid combination of lower and upper bound
            isValidCombination(range);
        }
    }

    /**
     * Checks for the given input for valid lower and upper bounds
     * 
     * @param range
     *            : Input range like [44444,33333]
     * @throws IllegalArgumentException
     *             if the input is invalid
     */
    public void isValidCombination(String range)
            throws IllegalArgumentException {
        String[] strRange = RangeUtils.getRange(range);

        // Check if lower bound number is bigger than upper bound
        if (Integer.valueOf(strRange[0]) > Integer.valueOf(strRange[1])) {
            log.error(ErrorCodes.INV_INPUT_MESSAGE_003 + range);
            throw new IllegalArgumentException(
                    ErrorCodes.INV_INPUT_MESSAGE_003);
        }

    }

}
