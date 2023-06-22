import java.util.*;

class Solution {
    private HashMap<Integer, Integer> log;

    public int solution(int n) {
        log = new HashMap<>();
        int result = fibonacci(n);
        return result;
    }

    public int fibonacci(int num) {
        if (num <= 1) return num;
        if (num == 2) return 1;

        if (log.containsKey(num)) {
            return log.get(num);
        }
        
        int result = (fibonacci(num - 1) + fibonacci(num - 2)) % 1234567;
        log.put(num, result);

        return result;
    }
}