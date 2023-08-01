import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((x1, x2) -> map.get(x2).compareTo(map.get(x1)));
        
        for(int i : keySet) {
            k -= map.get(i);
            answer++;
            if(k <= 0) return answer;
        }
        
        return answer;
    }
}