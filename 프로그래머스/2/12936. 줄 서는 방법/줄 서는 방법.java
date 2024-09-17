import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        long factorial = 1;
        
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial *= i;
        }
        
        k--;
        
        for (int i = 0; i < n; i++) {
            factorial /= (n - i);
            int index = (int) (k / factorial);
            answer[i] = numbers.get(index);
            numbers.remove(index);
            k %= factorial;
        }
        
        return answer;
    }
}