import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] && lost[i] != 0) {
                    answer++;
                    lost[i] = 0;
                    reserve[j] = 0;
                    break;
                }
            }
        }
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if ((lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) && reserve[j] != 0 && lost[i] != 0) {
                    answer++;
                    reserve[j] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}