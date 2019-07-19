package com.vinaybedre.app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void myAtoi(){
        Assert.assertEquals(42,solution.myAtoi("42"));
        Assert.assertEquals(-42,solution.myAtoi("   -42"));
        Assert.assertEquals(42,solution.myAtoi("   +42"));
        Assert.assertEquals(4193,solution.myAtoi("4193 with words"));
        Assert.assertEquals(0,solution.myAtoi("words and 987"));
        Assert.assertEquals(-2147483648,solution.myAtoi("-91283472332"));
    }

    @Test
    public void isPalindrome(){
        Assert.assertEquals(true,solution.isPalindrome(121));
        Assert.assertEquals(false,solution.isPalindrome(-121));
        Assert.assertEquals(false,solution.isPalindrome(10));
    }
}
