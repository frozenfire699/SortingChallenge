package com.ws.assignment.validation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ws.assignment.utils.ErrorCodes;

/**
 * Class containing tests for RangeValidator Class
 * 
 * @author Rohit Gupta
 * @since March 2018
 * @version 1.0
 *
 */

public class RangeValidatorTest {

    /**
     * Test to check for invalid input with a space in between range number
     */
    @Test
    public void testInValidInputSpace() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[00000, 12345]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ErrorCodes.INV_INPUT_MESSAGE_001,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with a non integer number in lower range
     */
    @Test
    public void testInValidInputLowerRange() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[000E4,12345]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ErrorCodes.INV_INPUT_MESSAGE_001,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with a non integer number in higher range
     */
    @Test
    public void testInValidInputUpperRange() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[00345,1EE45]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ErrorCodes.INV_INPUT_MESSAGE_001,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with special characters in lower/upper
     * range
     */
    @Test
    public void testInValidInputSpecialCharacters() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[00$45,1E@45]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ErrorCodes.INV_INPUT_MESSAGE_001,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with no range values passed
     */
    @Test
    public void testInValidInputLowerBoundBiggerThanUpperBound() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[99999,88888]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ErrorCodes.INV_INPUT_MESSAGE_003,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with range surrounded by non square
     * brackets
     */
    @Test
    public void testInValidInputNoSquareBrackets() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("{12345,34567}");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ErrorCodes.INV_INPUT_MESSAGE_001,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with no range values passed
     */
    @Test
    public void testInValidInputNoRangeProvided() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ErrorCodes.INV_INPUT_MESSAGE_001,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with no range values passed
     */
    @Test
    public void testInValidInputNoInputProvided() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ErrorCodes.INV_INPUT_MESSAGE_002,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with 4 digit zip code
     */
    @Test
    public void testInValidInputFourDigitZipCode() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[1234,12345]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ErrorCodes.INV_INPUT_MESSAGE_001,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with no range values passed
     */
    @Test
    public void testInValidInputOneRangeInvalidMultiInput() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[49679,52015]");
        input.add("[49800, 50000]");
        input.add("[51500,53479]");
        try {
            validator.isValid(input);
            Assert.fail();
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ErrorCodes.INV_INPUT_MESSAGE_001,
                    ex.getMessage());
        }
    }

    /**
     * Test to check for invalid input with no range values passed
     */
    @Test
    public void testValidInput() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[49679,52015]");
        input.add("[49800,50000]");
        input.add("[51500,53479]");
        try {
            boolean result = validator.isValid(input);
            Assert.assertEquals(true, result);
        } catch (IllegalArgumentException ex) {
            Assert.fail();
        }
    }

    /**
     * Test to check for valid input with range having leading zeroes
     */
    @Test
    public void testValidInputLeadingZeroInRange() {
        RangeValidator validator = new RangeValidator();
        List<String> input = new ArrayList<String>();
        input.add("[01234,12345]");
        try {
            boolean result = validator.isValid(input);
            Assert.assertEquals(true, result);
        } catch (IllegalArgumentException ife) {
            Assert.fail();
        }
    }

}
