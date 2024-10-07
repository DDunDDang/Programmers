import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        for (int num : queue1) sum1 += num;
        for (int num : queue2) sum2 += num;

        long totalSum = sum1 + sum2;

        if (totalSum % 2 != 0) return -1;

        long targetSum = totalSum / 2;

        int n = queue1.length;
        int[] combined = new int[n * 2];
        for (int i = 0; i < n; i++) {
            combined[i] = queue1[i];
            combined[i + n] = queue2[i];
        }

        int start = 0, end = n;
        long currentSum = sum1;
        int operations = 0;

        while (start < end && end < combined.length) {
            if (currentSum == targetSum) {
                return operations;
            } else if (currentSum < targetSum) {
                currentSum += combined[end++];
            } else {
                currentSum -= combined[start++];
            }
            operations++;
        }

        return -1;
    }
}
