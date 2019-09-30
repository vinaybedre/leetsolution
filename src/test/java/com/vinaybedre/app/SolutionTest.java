package com.vinaybedre.app;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void myAtoi() {
        assertEquals(42, solution.myAtoi("42"));
        assertEquals(-42, solution.myAtoi("   -42"));
        assertEquals(42, solution.myAtoi("   +42"));
        assertEquals(4193, solution.myAtoi("4193 with words"));
        assertEquals(0, solution.myAtoi("words and 987"));
        assertEquals(-2147483648, solution.myAtoi("-91283472332"));
    }

    @Test
    public void isPalindrome() {
        assertTrue(solution.isPalindrome(121));
        assertFalse(solution.isPalindrome(-121));
        assertFalse(solution.isPalindrome(10));
    }

    @Test
    public void twoSum() {
        int nums[] = new int[]{3, 4};
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(nums, 7));

        nums = new int[]{2, 7, 11, 15};
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(nums, 9));

        nums = new int[]{2, -7, 11, -15};
        assertArrayEquals(new int[]{1, 3}, solution.twoSum(nums, -22));
    }
}
