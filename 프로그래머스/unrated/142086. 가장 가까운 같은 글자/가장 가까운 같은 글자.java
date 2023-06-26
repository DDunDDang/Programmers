import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String[] split = s.split("");
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[split.length];
        
        for (int i = 0; i < split.length; i++) {
            if (map.get(split[i]) == null) {
                answer[i] = -1;
            } else {
                answer[i] = i - map.get(split[i]);
            }
            map.put(split[i], i);
        }
        
        return answer;
    }
}