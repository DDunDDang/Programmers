import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int c = 0; c < commands.length; c++) {
            int startIdx = commands[c][0] - 1;
            int endIdx = commands[c][1] - 1;
            int[] arr = new int[endIdx - startIdx + 1];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = array[i + startIdx];
            }

            Arrays.sort(arr);
            answer[c] = arr[commands[c][2] - 1];
        }
        return answer;
    }
}