package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String strText = "AYZABOBECODXBANC";
        String strCharacters = "ABC";
        System.out.println(MinWindow(strText, strCharacters));

    }

    static String MinWindow(String strText, String strCharacters) {

        Map<Character, Integer> inputMap = new HashMap<Character,Integer>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String result = "-1";

        for (char c : strCharacters.toCharArray()) {
            inputMap.put(c, inputMap.getOrDefault(c,0)+1);
            map.put(c, 0);
        }
        int unavailable = inputMap.keySet().size();
        int left = 0;
        int right = 0;

        while (right < strText.length()) {
            System.out.println("Character at right " + strText.charAt(right));
            if (unavailable > 0) {
                char c = strText.charAt(right);
                if (inputMap.containsKey(c)) {
                    int count = map.get(c) + 1;
                    if (count == inputMap.get(c)) {
                        unavailable--;
                    }
                    map.put(c, count);
                }
                right++;
            }
            while (unavailable == 0) {
                result = saveResult(strText, result, left, right);
                char c = strText.charAt(left);
                if (inputMap.containsKey(c)) {
                    int count = map.get(c) - 1;
                    if (count < inputMap.get(c)) {
                        unavailable++;
                    }
                    if(count>=0) {
                        map.put(c, count);
                    }
                }
                left++;
            }

        }
        return result;

    }

    private static String saveResult(String originalString, String result, int left, int right) {
        if (result.equals("-1") || result.length() > right - left) {
            return originalString.substring(left, right);
        }
        return result;
    }
}
