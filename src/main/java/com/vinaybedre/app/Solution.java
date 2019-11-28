package com.vinaybedre.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Solution {
    // https://leetcode.com/problems/string-to-integer-atoi/
    public int myAtoi(String str) {
        int index;
        char currentChar = ' ';
        boolean isNegative = false;
        long resultNumber = 0;
        for (index = 0; index < str.length(); index++) {
            currentChar = str.charAt(index);
            if (currentChar != ' ') {
                if (currentChar == '-') {
                    isNegative = true;
                    index++;
                }
                if (currentChar == '+') {
                    index++;
                }
                break;
            }
        }

        for (; index < str.length(); index++) {
            currentChar = str.charAt(index);
            if (Character.isDigit(currentChar)) {
                resultNumber *= 10;
                resultNumber += Character.getNumericValue(currentChar);
            } else {
                break;
            }

            if (resultNumber > Integer.MAX_VALUE) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
        }

        resultNumber = isNegative ? -resultNumber : resultNumber;

        return (int) resultNumber;
    }

    //https://leetcode.com/problems/palindrome-number/
    public boolean isPalindrome(int x) {
        int originalInput = x;
        if (x < 0) {
            return false;
        }

        int revNumber = 0;

        while (x != 0) {
            revNumber *= 10;
            revNumber += x % 10;
            x = x / 10;
        }

        if (revNumber == originalInput) {
            return true;
        }
        return false;
    }

    //https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        //operand and index
        Map<Integer, Integer> possibleOperands = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (possibleOperands.containsKey(nums[i])) {
                return new int[]{possibleOperands.get(nums[i]), i};
            }
            int diff = target - nums[i];
            possibleOperands.put(diff, i);
        }
        return new int[2];
    }

    public void linkedList() {
        LinkedList list = new LinkedList();
        Node head = null;
        list.appendToEnd(head, 10);
        list.appendToEnd(head, 20);
        list.printLL(head);
    }

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                y++;
            }
            if (moves.charAt(i) == 'D') {
                y--;
            }
            if (moves.charAt(i) == 'L') {
                x--;
            }
            if (moves.charAt(i) == 'R') {
                x++;
            }
        }
        return x == 0 && y == 0;
    }

    public String longestCommonPrefix(String[] strs) {
        int currentIndex = 0;
        Set<Character> currentCharacter = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean exhausted = false;

        while (!exhausted) {
            currentCharacter.clear();
            for (String str : strs) {
                if (currentIndex <= str.length() - 1) {
                    currentCharacter.add(str.charAt(currentIndex));
                } else {
                    exhausted = true;
                }
            }
            currentIndex++;

            if (currentCharacter.size() != 1) {
                break;
            }

            sb.append(currentCharacter.toArray()[0]);
        }


        return sb.toString();
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode(0);
//        int remainder = 0;
//        while (l1 != null || l2 != null) {
//            ListNode current = head;
//            int sum = 0;
//            if (l1 == null) {
//                current.next = new ListNode(l2.val);
//                current = current.next;
//                l2 = l2.next;
//                continue;
//            }
//            if (l2 == null) {
//                current.next = new ListNode(l1.val);
//                l1 = l1.next;
//                current = current.next;
//                continue;
//            }
//            sum = l1.val + l2.val;
//
//            if (sum > 9) {
//                remainder = 1;
//                sum = sum / 10;
//            }
//            current.next = new ListNode()
//        }
//    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (nums[current - 1] < 1) {
                result.add(current);
            }
            nums[current - 1] *= -1;
        }
        return result;
    }

    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        if (num <= 0) {
            return false;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            double res = (double) mid * mid;
            if (res == num) {
                return true;
            }
            if (res > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int n : nums) {
            if (n != val) {
                nums[index] = n;
                index++;
            }
        }
        return index;
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;

            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int thirdMax(int[] nums) {
        int x = nums[0];
        int y = nums[0];
        int z = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > z) {
                x = y;
                y = z;
                z = nums[i];
                continue;
            }
            if (nums[i] > y) {
                x = y;
                y = nums[i];
                continue;
            }
            if (nums[i] > x) {
                x = nums[i];
            }
        }
        return x;
    }

    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    private List<List<Integer>> permute(int[] nums, int index) {
        if (index == nums.length) {
            return Arrays.asList(Collections.emptyList());
        }
        List<List<Integer>> next = permute(nums, index + 1);

        List<List<Integer>> cur = new ArrayList<>();

        for (List<Integer> list : next) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> copy = new ArrayList<>(list);
                copy.add(i, nums[index]);
                cur.add(copy);
            }
        }
        return cur;
    }

    ListNode head;

    public ListNode reverseList(ListNode head) {
        reverseRecurr(head);
        return this.head;
    }

    public ListNode reverseRecurr(ListNode node) {
        if (node == null || node.next == null) {
            this.head = node;
            return node;
        }

        ListNode prev = reverseRecurr(node.next);
        prev.next = node;
        node.next = null;
        return node;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        getNthRecurr(head, n);
        return head;
    }

    public int getNthRecurr(ListNode head, int n) {
        if (head == null || head.next == null) {
            return 1;
        }
        int i = getNthRecurr(head.next, n);
        if (i == n) {
            head.next = head.next.next;
            //delete the current node
        }
        return ++i;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1, h2 = l2;
        ListNode head = null;
        int carry = 0;
        while (h1 != null || h2 != null) {
            if (h1 == null) {
                head = addNode(head, h2.val);
                h2 = h2.next;
                continue;
            }
            if (h2 == null) {
                head = addNode(head, h1.val);
                h1 = h1.next;
                continue;
            }
            head = addNode(head, h1.val + h2.val);
            h1 = h1.next;
            h2 = h2.next;
        }
        return head;
    }

    ListNode addNode(ListNode head, int num) {
        ListNode current = head;
        if (head == null) {
            head = new ListNode(num);
            return head;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(num);
        return head;
    }

}
