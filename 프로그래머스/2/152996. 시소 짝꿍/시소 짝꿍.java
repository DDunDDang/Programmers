import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Map<Double, Integer> weightCount = new HashMap<>();
        long answer = 0;

        for (int weight : weights) {
            double w = weight;
            answer += weightCount.getOrDefault(w, 0);
            answer += weightCount.getOrDefault(w * 2, 0);
            answer += weightCount.getOrDefault(w / 2, 0);
            answer += weightCount.getOrDefault(w * 3 / 2, 0);
            answer += weightCount.getOrDefault(w * 2 / 3, 0);
            answer += weightCount.getOrDefault(w * 4 / 3, 0);
            answer += weightCount.getOrDefault(w * 3 / 4, 0);

            weightCount.put(w, weightCount.getOrDefault(w, 0) + 1);
        }

        return answer;
    }
}