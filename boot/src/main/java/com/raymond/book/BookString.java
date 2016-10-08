package com.raymond.book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

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

    //Replace spaces with %20
    public String urlify(String url) {
        char[] stringChar = url.toCharArray();
        int numberOfSpaces = 0;
        for (int i = 0; i < stringChar.length; i++) {//A BC
            if (stringChar[i] == ' ') {
                numberOfSpaces++;
            }
        }
        char[] increasedSize = new char[stringChar.length + (numberOfSpaces*3)];
        int j = 0;
        for (int i = 0; i < stringChar.length; i++) {//A BC
            increasedSize[j] = stringChar[i];
            if (stringChar[i] == ' ') {
                increasedSize[j] = 37;
                increasedSize[j + 1] = 50;
                increasedSize[j + 2] = 48;
                j = j + 2;
            }
            j++;
        }
        return new String(increasedSize);
    }

    public String urlify2(char[] url, int length) {
        int numberOfSpaces = 0;
        for (int i = 0; i < url.length; i++) {//A BC
            if (url[i] == ' ') {
                numberOfSpaces++;
            }
        }
        char[] increasedSize = new char[length + (numberOfSpaces*3)];
        int j = 0;
        for (int i = 0; i < url.length; i++) {//A BC
            increasedSize[j] = url[i];
            if (url[i] == ' ') {
                increasedSize[j] = 37;
                increasedSize[j + 1] = 50;
                increasedSize[j + 2] = 48;
                j = j + 2;
            }
            j++;
        }
        return new String(increasedSize);
    }

    public String urlify3(char[] url, int length) { //4
        int numberOfSpaces = 0;
        for (int i = 0; i < url.length; i++) {
            if (url[i] == ' ') {
                numberOfSpaces++;
            }
        }
        char[] increasedSize = new char[length + (numberOfSpaces*3)];
        int counter = length + (numberOfSpaces*3) - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (url[i] == ' ') {
                increasedSize[counter] = '0';
                increasedSize[counter-1] = '2';
                increasedSize[counter-2] = '%';
                counter = counter - 3;
            }
            else {
                increasedSize[counter] = url[i];
                counter--;
            }
        }
        return new String(increasedSize);
    }

    //Palindrome Permutation
    //Tact Coa -> true, taco cat
    public boolean palindromePermutation(String str) {
        //as I go from left to right, I remove the letters that match, if one or none remain, true
        String temp = str.toUpperCase();
        char[] chars = temp.toCharArray();
        HashMap<Character, Integer> abc = new HashMap();
        for (int i = 0; i < str.length(); i++) {
            Character c = chars[i];
            //System.out.print(c);
            if (abc.containsKey(c)) {
                Integer count = abc.get(c);
                count++;
                abc.put(c, count);
            }
            else {
                if (c != ' ') {
                    abc.put(c, new Integer(1));
                }
            }
        }

        int isOneOdd = 0;
        for (int i = 0; i < str.length(); i++) {
            Integer count = abc.get(chars[i]);
            if (count != null && count.intValue() % 2 == 1) {
                isOneOdd++;
            }
            if (isOneOdd > 1) {
                return false;
            }
        }
        return true;
    }

    //Tact Coa -> true, taco cat
    public boolean palindromePermutation2(String str) {
        //as I go from left to right, I remove the letters that match, if one or none remain, true
        //Add count into array
        int[] letters = new int[128];
        char[] s1_array = str.toCharArray(); //a b c
        for (int i = 0; i < s1_array.length; i++) {
            letters[s1_array[i]]++;
        }
        int isOneOdd = 0;
        for (int i = 0; i < s1_array.length; i++) {
            System.out.println(s1_array[i]);
            int count = letters[s1_array[i]];
            System.out.println(count);
            if (count % 2 == 1) {
                isOneOdd++;
            }
            if (isOneOdd > 1) {
                return false;
            }
        }
        return true;
    }

    //Insert, Delete, Replace to get true
    //pale, ple   -> true //insertToEnd
    //pales, pale -> true //delete
    //pale, bale  -> true //replace
    //pale, bake  -> false
    public boolean oneAway(String str1, String str2) { //5
        if (str1.length() == str2.length()) { //if same length, replace
            return replaceAway(str1, str2);
        }
        else if (str1.length() - 1 == str2.length()) { //if 1 length difference
            return insertDeleteAway(str2, str1);
        }
        else if (str1.length() + 1 == str2.length()) { //if 1 length difference
            return insertDeleteAway(str1, str2);
        }
        else { //possibly too large
            return false;
        }
    }

    private boolean replaceAway(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        boolean allowOne = false;
        for (int i = 0; i < str1.length(); i++) {
            if (chars1[i] != chars2[i]) {
                if (allowOne) {
                    return false;
                }
                allowOne = true;
            }
        }
        return true;
    }

    //"pale", "ple"
    private boolean insertDeleteAway(String smaller, String larger) {
        char[] chars1 = smaller.toCharArray();
        char[] chars2 = larger.toCharArray();
        boolean allowOne = false;

        int i = 0;
        int j = 0;
        while (i < chars1.length && j < chars2.length) {
            if (chars1[i] != chars2[j]) {//pale pales
                if (allowOne) {
                    return false;
                }
                allowOne = true;
            }
            else {
                i++;
            }
            j++;
        }
        return true;
    }

    //aabcccccaaa -> a2b1c5a3
    //assume all lower case
    //if it won't be smaller then return original str
    public String compression(String str) {
        int[] letterCount = new int[128];
        char[] chars = str.toCharArray();
        boolean isAllOne = true;
        for (int i = 0; i < chars.length; i++) {
            letterCount[chars[i]]++;
            if (letterCount[chars[i]] > 1) {
                isAllOne = false;
            }
        }
        if (isAllOne) {
            return str;
        }

        char alreadyPrinted = 0;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (alreadyPrinted != chars[i]) {
                output.append(chars[i]);
                output.append(letterCount[chars[i]]);
            }
            alreadyPrinted = chars[i];
        }
        return output.toString();
    }

    public String compression2(String str) {
        int count = countCompression(str);
        if (count >= str.length()) {
            return str;
        }

        StringBuilder output = new StringBuilder(count);
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {//aebcc 012, 3
            countConsecutive++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                output.append(str.charAt(i));
                output.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return output.toString();
    }

    private int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {//aebcc
            countConsecutive++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        System.out.println(compressedLength);
        return compressedLength;
    }

    //Rotate image by 90 degrees
    //Assumption is that eah pixel in the imgage is 4 bytes.
    //DO in place
    public int[][] rotateImage(int[][] image) {
        for (int y = 0; y < image.length / 2; y++) {//0
            int first = y;//0
            int last = image.length - 1 - y;//2
            for (int x = first; x < last; x++) {//0,1
                int offset = x - first;//0,1
                //top
                int top = image[first][x];
                //left->top
                image[first][x]=image[last-offset][first];
                //bottom->left
                image[last-offset][first] = image[last][last-offset];
                //right->bottom
                image[last][last-offset] = image[x][last];
                //top->right
                image[x][last]=top;
            }
        }
        return image;
    }

    public int[][] rotateImage2(int[][] image) {
        for (int y = 0; y < image.length / 2; y++) {//0
            int last = image.length - 1 - y;//2
            for (int x = y; x < last; x++) {//0,1
                int offset = x - y;//0,1
                //top
                int top = image[y][x];
                //left->top
                image[y][x]=image[last-offset][y];
                //bottom->left
                image[last-offset][y] = image[last][last-offset];
                //right->bottom
                image[last][last-offset] = image[x][last];
                //top->right
                image[x][last]=top;
            }
        }
        return image;
    }

    //Zero Matrix
    //If an element in an MxN matrix is 0, its entire row and column are set to 0
    //Do not wipe out whole matrix
    public int[][] zeroMatrix(int[][]matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        boolean allRows = true;
        for (int r = 0; r < row.length; r++) {
            if (row[r] == 1) {
                for (int c = 0; c < col.length; c++) {
                    matrix[r][c] = 0;
                }
            } else {
                allRows = false;
            }
        }

        if (!allRows) {
            for (int c = 0; c < col.length; c++) {
                if (col[c] == 1) {
                    for (int r = 0; r < row.length; r++) {
                        matrix[r][c] = 0;
                    }
                }
            }
        }
        return matrix;
    }

    //Is str1 a rotation of str2,
    //We are only allowed one call to a fake method call isSubstring(String str1, String str2)
    public boolean isRotation(String str1, String str2) {
        if (str1.length() == str2.length() && str1.length() > 0) {
            return isSubstring(str1 + str1, str2);
        }
        return false;
    }

    public boolean isSubstring(String str1, String str2) {
        return (str1.indexOf(str2) > -1);
    }

    public boolean toLike(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        if (str1.length() == 1) {
            return str1.equals(str2);
        }

        int position = 1;
        while (position < str1.length()) {
            String part1 = str1.substring(0, position);
            String part2 = str1.substring(position, str1.length());
            if ((part2+part1).equals(str2)) {
                return true;
            }
            position++;
        }
        return false;
    }

    /*public static void main (String[] args) {
        BookString book = new BookString();
        System.out.println(book.checkUniqueCharacters("Abc"));
        System.out.println(book.checkUnique2("Abc"));
        System.out.println(book.checkPermutation1("abcc", "acbb"));
        System.out.println(book.checkPermutation2("abcc", "acbb"));
        char[] url = new char[]{'A',' ','B','C'};
        System.out.println(book.urlify3(url, 4));
        String permutation = "tactcooa";
        System.out.println(book.palindromePermutation2(permutation));
        System.out.println(book.oneAway("pale", "pales"));

        //System.out.println(book.compression("aebcc"));
        //System.out.println(book.compression2("abcc"));



        //int[][] image = { //[3][3]
        //        { 1, 2, 3 },
        //        { 4, 5, 6 },
        //        { 7, 8, 9 }
        //};
        int[][] image = { //[3][3]
                { 0, 2, 3 },
                { 0, 0, 6 },
                { 7, 8, 9 }
        };
        image = book.zeroMatrix(image);
        for (int y = 0; y < image.length; y++) {
            for (int x = 0; x < image[y].length; x++) {
                System.out.print(image[y][x] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(book.toLike("abc","abc"));
        System.out.println(book.isRotation("abc","abc"));

    }*/
}
