import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        
        List<String> DICs = new ArrayList<>();
        String[] AEIOU = {"A", "E", "I", "O", "U"};
        StringBuffer sb = new StringBuffer();
        pick(sb, AEIOU, DICs);
        
        answer = DICs.indexOf(word) + 1;
        return answer;
    }
    
    public void pick(StringBuffer picked, String[] AEIOU, List<String> DICs) {
        if (picked.length() > 0) {
            DICs.add(picked.toString());
        }
        
        if (picked.length() <= 4) {
            for (int i = 0; i < AEIOU.length; i++) {
                picked.append(AEIOU[i]);
                pick(picked, AEIOU, DICs);
                picked.deleteCharAt(picked.length() - 1);
            }
        }
    }
}