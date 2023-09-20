import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
	        String type = clothes[i][1];
            hash.put(type, hash.getOrDefault(type, 0) + 1);
        }
        
        Iterator<Integer> iter = hash.values().iterator();

        while (iter.hasNext()) {
            // 입지 않은 경우 + 1
	        answer *= iter.next().intValue() + 1;
        }

        return answer - 1;
    }
}