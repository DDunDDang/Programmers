import java.util.*;

class Solution {
    public int solution(int n) {
        String three = Integer.toString(n, 3);
        
        String reverse = "";
        ArrayList<Character> revArray = new ArrayList<>();
        
        for (int i = three.length() - 1; i >= 0; i--) {
            reverse += String.valueOf(three.charAt(i));
        }
        
        int result = Integer.parseInt(reverse, 3);
    
        return result;
    }
}