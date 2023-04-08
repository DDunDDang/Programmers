import java.util.*;

public class Solution {
    public int solution(int n) {
        String strN = n + "";
        
        int result = 0;
        
        for (int i = 0; i < strN.length(); i++) {
            result += (int) (strN.charAt(i)) - 48;
        }
        return result;
    }
}