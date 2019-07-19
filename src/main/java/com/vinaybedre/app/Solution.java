package com.vinaybedre.app;

public class Solution {
    // https://leetcode.com/problems/string-to-integer-atoi/
    public int myAtoi(String str) {
        int index;
        char currentChar=' ';
        boolean isNegative = false;
        long resultNumber=0;
        for(index=0;index<str.length();index++){
            currentChar = str.charAt(index);
            if(currentChar!=' '){
                if(currentChar=='-'){
                    isNegative = true;
                    index++;
                }
                if(currentChar=='+'){
                    index++;
                }
                break;
            }
        }

        for(;index<str.length();index++){
            currentChar = str.charAt(index);
            if(Character.isDigit(currentChar)){
                resultNumber *= 10;
                resultNumber += Character.getNumericValue(currentChar);
            }
            else{
                break;
            }

            if(resultNumber>Integer.MAX_VALUE){
                if(isNegative){
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
        }

        resultNumber = isNegative?-resultNumber:resultNumber;

        return (int)resultNumber;
    }

    //https://leetcode.com/problems/palindrome-number/
    public boolean isPalindrome(int x) {
        int originalInput = x;
        if(x<0){
            return false;
        }

        int revNumber=0;

        while(x!=0){
            revNumber *= 10;
            revNumber += x%10;
            x = x/10;
        }

        if(revNumber==originalInput){
            return true;
        }
        return false;
    }
}
