package me.danielhoyos.cybersolutions.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberUtilsTest {

    @Test
    public void testGetLowerRange() {
        assertEquals(10l, NumberUtils.getLowerRangeLimit(2));
        assertEquals(100l, NumberUtils.getLowerRangeLimit(3));
        assertEquals(10000l, NumberUtils.getLowerRangeLimit(5));
    }

    @Test
    public void testGetRange() {
        assertEquals(99l, NumberUtils.getUpperRangeLimit(2));
        assertEquals(999l, NumberUtils.getUpperRangeLimit(3));
        assertEquals(99999l, NumberUtils.getUpperRangeLimit(5));
    }
}