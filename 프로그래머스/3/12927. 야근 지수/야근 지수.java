import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            maxHeap.add(work);
        }

        while (n > 0) {
            if (maxHeap.isEmpty()) break;
            int largest = maxHeap.poll();

            if (largest > 0) {
                largest -= 1;
                n -= 1;
                maxHeap.add(largest);
            }
        }

        long answer = 0;
        while (!maxHeap.isEmpty()) {
            int work = maxHeap.poll();
            answer += (long) work * work;
        }

        return answer;
    }
}
