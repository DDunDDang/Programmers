import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = d.length;
        int currentSum = Arrays.stream(d).sum();
        
        Arrays.sort(d);
        
        for (int i = d.length - 1; i >= 0; i--) {
            if (currentSum <= budget) {
                return answer;
            }
            
            currentSum = currentSum - d[i];
            answer--;
        }
        
        return answer;
    }
}