import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for(int i = 0; i < discount.length - 10 + 1; i++) {
            Map<String, Integer> xMap = new HashMap<>();
            
            for(int j = 0; j < 10; j++) {
                xMap.put(discount[i + j], xMap.getOrDefault(discount[i + j], 0) + 1);
            }
            
            Boolean isChecked = true;
            
            for(String key : map.keySet()) {
                if(map.get(key) != xMap.get(key)) {
                    isChecked = false;
                    break;
                }
            }
            
            answer += isChecked ? 1 : 0; 
        }
        return answer;
    }
}