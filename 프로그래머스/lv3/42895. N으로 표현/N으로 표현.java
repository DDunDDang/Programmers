import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        
        List<Set<Integer>> memo = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            memo.add(new HashSet<>());
        }

        memo.get(1).add(N);

        for (int LEN = 2; LEN <= 8; LEN++) {
            Set<Integer> currentNum = memo.get(LEN);

            for (int left = 1; left < LEN; left++) {
                Set<Integer> leftSet = memo.get(left);
                Set<Integer> rightSet = memo.get(LEN - left);

                for (int leftNum : leftSet) {
                    for (int rightNum : rightSet) {
                        int plus = leftNum + rightNum;
                        int minus = leftNum - rightNum;
                        int multi = leftNum * rightNum;

                        if(plus == number || minus == number || multi == number) {
                            return LEN;
                        }
                        currentNum.add(plus);
                        currentNum.add(minus);
                        currentNum.add(multi);
                        if (leftNum != 0 && rightNum != 0) {
                            int div = leftNum / rightNum;
                            currentNum.add(div);

                            if(div == number) {
                                return LEN;
                            }
                        }
                    }
                }
            }

            int sum = Integer.parseInt(String.valueOf(N).repeat(LEN));
            if (sum == number) {
                return LEN;
            }
            currentNum.add(sum);
        }
        return -1;
    }
}