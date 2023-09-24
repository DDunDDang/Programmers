import java.util.*;

public class Solution {
    public static String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        for (char c : X.toCharArray()) {
            int digit = c - '0';
            countX[digit]++;
        }
        for (char c : Y.toCharArray()) {
            int digit = c - '0';
            countY[digit]++;
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int digit = 9; digit >= 0; digit--) {
            int minCount = Math.min(countX[digit], countY[digit]);
            for (int i = 0; i < minCount; i++) {
                result.append(digit);
            }
        }
        
        if (result.length() == 0) {
            return "-1";
        } else if (result.toString().replaceAll("0", "").isEmpty()) {
            return "0";
        } else {
            return result.toString();
        }
    }
}