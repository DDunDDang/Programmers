import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0});
        int answer = 0;

        while(Q.isEmpty() == false) {
            int[] current = Q.poll();

            if (current[0] == target && current[1] == numbers.length) {
                answer++;
            }

            if (current[1] < numbers.length) {
               Q.offer(new int[]{current[0] + numbers[current[1]], current[1] + 1});
               Q.offer(new int[]{current[0] - numbers[current[1]], current[1] + 1});
            }
        }

        return answer;
    }
}