import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        
        for (int i = 0; i< progresses.length; i++) {
            q.add((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        while (!q.isEmpty()) {
		    int days = q.poll();
            int count = 1;

            while (!q.isEmpty() && q.peek() <= days) {
                q.poll();
                count++;
            }
            
            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}