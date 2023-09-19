import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dict = new HashMap<>();
        ArrayList<Integer> answerList = new ArrayList<>();        
        
        int dictIdx = 1;
        for(int i = 'A'; i <= 'Z'; i++) {
            dict.put(String.valueOf((char)i), dictIdx++);
        }
        
        int idx = 0;
        while(idx < msg.length()) {
            String str = "";
            
            while(idx < msg.length()) {
                if(!dict.containsKey(str + msg.charAt(idx))) {
                    break;
                } else {
                    str += msg.charAt(idx);
                }
                
                idx++;
            }
            
            answerList.add(dict.get(str));
            
            if (idx < msg.length()) {
                dict.put(str + msg.charAt(idx), dictIdx++);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
           
        return answer;
    }
}