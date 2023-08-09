import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i+1);
            q.add(str);
        }
        
        for (int i = 0; i < s.length(); i++) {
            String first = q.poll();
            q.add(first);
            
            Stack<String> stack = new Stack<>();
            
            for (int j = 0; j < s.length(); j++) {
                String rest = q.poll();
                q.add(rest);
                
                if(stack.isEmpty()){
                    stack.push(rest);
                } 
                else if(rest.equals(")") && stack.peek().equals("(")){
                    stack.pop();
                }
                else if(rest.equals("]") && stack.peek().equals("[")){
                    stack.pop();
                }
                else if(rest.equals("}") && stack.peek().equals("{")){
                    stack.pop();
                }
                else{
                    stack.push(rest);
                }
            }
            if(stack.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}