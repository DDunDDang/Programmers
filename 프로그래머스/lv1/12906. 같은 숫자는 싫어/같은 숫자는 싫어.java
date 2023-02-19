import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int prev = arr[0];
        list.add(prev);

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            if (prev != curr) {
                list.add(curr);
                prev = curr;
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}