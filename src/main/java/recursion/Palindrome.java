package recursion;

import java.util.logging.Logger;

public class Palindrome {

    public static void main(String[] args) {
        Logger lg = Logger.getLogger("Palindrome");
        String str = "Bob";
        lg.info("is " + str + " palindrome ? " + checkPalindrome(str.toCharArray(), 0, str.length()-1));

    }

    private static boolean checkPalindrome(char[] cArr, int startIdx, int endIdx) {
        if(startIdx>=endIdx) {
            return true;
        }
        return cArr[startIdx]==cArr[endIdx] && checkPalindrome(cArr, ++startIdx, --endIdx);
    }
}
