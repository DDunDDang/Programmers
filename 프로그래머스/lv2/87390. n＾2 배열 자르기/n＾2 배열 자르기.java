import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) right - (int) left;
        int[] answer = new int[len + 1];        
        int idx = 0;
        
        for (long i = left; i <= right; i++) {
            long x = i / n;
            long y = i % n;
            answer[idx++] = Math.max((int)x, (int)y) + 1;
        }
        
        return answer;
    }
}