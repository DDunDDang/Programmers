public class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey != 0) {
            int one = storey % 10;
            int ten = (storey / 10) % 10;

            if (one > 5) {
                answer += (10 - one);
                storey += 10 - one;
            } else if (one == 5) {
                if (ten >= 5) {
                    answer += (10 - one);
                    storey += 10 - one;
                } else {
                    answer += one;
                    storey -= one;
                }
            } else {
                answer += one;
                storey -= one;
            }

            storey /= 10;
        }

        return answer;
    }
}
