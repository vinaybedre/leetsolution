package com.vinaybedre.app;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

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

    @Test
    public void temp() {
        solution.linkedList();
    }

    @Test
    public void longestCommonPrefix() {
        String[] strs = {"flower", "flow", "fl"};
        String result = solution.longestCommonPrefix(strs);
        System.out.println(result);
    }

    @Test
    public void findDuplicates() {
        int x[] = {4, 3, 2, 7, 8, 2, 3, 1};
        solution.findDuplicates(x);
    }

    @Test
    public void isPerfectSquare() {
        assertTrue(solution.isPerfectSquare(4));
        assertTrue(solution.isPerfectSquare(16));
        assertTrue(solution.isPerfectSquare(1));
        assertFalse(solution.isPerfectSquare(15));
        assertFalse(solution.isPerfectSquare(Integer.MAX_VALUE));
    }

    @Test
    public void removeElement() {
        int x[] = {3, 2, 2, 3};
        assertEquals(2, solution.removeElement(x, 2));
        int y[] = {0, 1, 2, 2, 3, 0, 4, 2};
        assertEquals(5, solution.removeElement(y, 2));
    }

    @Test
    public void searchInsert() {
        int x[] = {1, 3, 5, 6};
        int y[] = {1, 3};
        int res[];
        assertEquals(2, solution.searchInsert(x, 5));
        assertEquals(1, solution.searchInsert(x, 2));
        assertEquals(4, solution.searchInsert(x, 7));
        assertEquals(0, solution.searchInsert(x, 0));
        assertEquals(1, solution.searchInsert(y, 2));
    }

    @Test
    public void permute() {
        int x[] = {1, 3, 5, 6};
        solution.permute(x);
    }

    @Test
    public void reverseList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode x = solution.reverseList(head);
        System.out.println(x.val);
    }

    @Test
    public void removeNthFromEnd() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode x = solution.removeNthFromEnd(head, 5);
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }

    @Test
    public void addTwoNumbers() {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);

        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(2);
        n2.next.next = new ListNode(3);

        ListNode x = solution.addTwoNumbers(n1, n2);
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }
}
