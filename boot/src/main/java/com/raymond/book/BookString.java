package com.raymond.book;

/**
 * Created by Raymond Kwong on 6/22/2016.
 */
public class BookString {

    //Implement method to see if the values in a string are unique

    /**
     * This method takes the the first char and search the remaining of the string and repeats
     * O(n^2)
     * @param str
     * @return
     */
    public boolean checkUniqueCharacters(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }
        char[] characters = str.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            for (int j = i+1; j < characters.length; j++) {
                if (characters[i] == characters[j]) {
                    System.out.println(characters[i] + " " + characters[j]);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This assumes ASCII string, 128, which covers most
     * This solution is based on the fact that a String contains characters
     * Characters can be represented as a decimal, in the case of ASCII, 128 possible characters
     * * O(n)
     * @param str
     * @return
     */
    public boolean checkUnique2(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    //Given 2 strings, write a method to determine if one string is a permutation of the other

    //Example
    //str1 abcdef
    //str2 defcba
    //if different lengths, then no
    //We take one character and loop it through the other string to compare
    //O(nm)
    //Another solution we do math and add the values of the char
    //O(n+m)
    public boolean checkPermutation1(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        //we therefore further assume they are the same length
        int sumOfStr1 = 0;
        for (int i = 0; i < str1.length(); i++) {
            sumOfStr1 = sumOfStr1 + str1.charAt(i);
        }

        int sumOfStr2 = 0;
        for (int i = 0; i < str2.length(); i++) {
            sumOfStr2 = sumOfStr2 + str2.charAt(i);
        }

        return sumOfStr1 == sumOfStr2;
    }

    /**
     * This solution relies on counting the number of characters
     * This also relies on the fact that a character is represented by a decimal value to store into an index of an array
     * @param str1
     * @param str2
     * @return
     */
    public boolean checkPermutation2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        //Add count into array
        int[] letters = new int[128];
        char[] s1_array = str1.toCharArray(); //a b c
        for (int i = 0; i < s1_array.length; i++) {
            letters[s1_array[i]]++;
            System.out.print(s1_array[i] + " ");
        }
        //Remove the count
        char[] s2_array = str2.toCharArray();
        for (int i = 0; i < s2_array.length; i++) {
            letters[s2_array[i]]--;
            if (letters[s2_array[i]] < 0) {//solution 2a. this here assumes that if there is a different char, then it would be -1.
                return false;
            }
        }

        //solution 2b. should be all 0
        /*for (int i = 0; i < letters.length; i++) {
            if (letters[i] > 0) {
                return false;
            }
        }*/
        return true;
    }

    public static void main (String[] args) {
        BookString book = new BookString();
        System.out.println(book.checkUniqueCharacters("Abc"));
        System.out.println(book.checkUnique2("Abc"));
        System.out.println(book.checkPermutation1("abcc", "acbb"));
        System.out.println(book.checkPermutation2("abcc", "acbb"));
    }
}
