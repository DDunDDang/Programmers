import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> subRail = new Stack<>();
        int answer = 0;
        int num = 1;
        int idx = 0;

        while (true) {
            if (idx >= order.length) break;

            if (num < order[idx]) {
                subRail.push(num++);
            } else if (num == order[idx]) {
                num++;
                idx++;
                answer++;
            } else if (subRail.peek() == order[idx]) {
                subRail.pop();
                idx++;
                answer++;
            } else break;
        }

        return answer;
    }
}