package com.raymond.interviewproblems;

/**
 * Created by Raymond Kwong on 11/13/2016.
 */
public class OneAway {

    public boolean oneEditAway(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();

        if (char1.length == char2.length) {
            return checkSameLength(char1, char2);
        }
        else if (differenceInLength(char1.length, char2.length) >= 2) {//length difference is greater than 2
            return false;
        }
        else { // length is only off by 1
            return checkIfReplace(char1, char2);
        }
    }

    public boolean checkSameLength(char[] char1, char[] char2) {
        boolean oneAway = false;
        int i = 0;
        while (i < char1.length) {
            if (char1[i] != char2[i]) {
                if (oneAway == true) {
                    return false;
                }
                oneAway = true;
            }
            i++;
        }
        return true;
    }

    //start with largest length
    //check if removal will work
    public boolean checkIfReplace(char[] char1, char[] char2) {
        char[] larger;
        char[] smaller;
        if (char1.length > char2.length) {
            larger = char1;
            smaller = char2;
        }
        else {
            larger = char2;
            smaller = char1;
        }
        boolean oneAway = false;
        int i = 0;
        int j = 0;
        while (i < larger.length && j < smaller.length)
        {
            if (larger[i] != smaller[j]) {
                if (oneAway == true) {
                    return false;
                }
                oneAway = true;
                i++;
            }
            else {
                i++;
                j++;
            }
        }
        return true;
    }

    public int differenceInLength(int l1, int l2) {
        int diff = (l1 - l2);
        if (diff < 0) {
            return diff * -1;
        }
        return diff;
    }

    public static void main (String[] args) {
        OneAway oneAway = new OneAway();
        String str1 = "acbd";
        String str2 = "ab";

        boolean isIt = oneAway.oneEditAway(str1, str2);
        System.out.println(isIt);
    }
}
