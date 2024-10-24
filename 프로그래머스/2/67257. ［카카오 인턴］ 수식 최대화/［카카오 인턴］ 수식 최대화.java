import java.util.*;

class Solution {
    private final String[] operators = {"+", "-", "*"};
    private List<Long> numbers = new ArrayList<>();
    private List<String> ops = new ArrayList<>();
    
    public long solution(String expression) {
        splitExpression(expression);
        return getMaxResult();
    }
    
    private void splitExpression(String expression) {
        StringBuilder num = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                numbers.add(Long.parseLong(num.toString()));
                num = new StringBuilder();
                ops.add(String.valueOf(c));
            }
        }
        numbers.add(Long.parseLong(num.toString()));
    }
    
    private long getMaxResult() {
        List<List<String>> priorities = generatePriorities();
        long maxResult = 0;
        
        for (List<String> priority : priorities) {
            maxResult = Math.max(maxResult, Math.abs(calculateWithPriority(priority)));
        }
        
        return maxResult;
    }
    
    private List<List<String>> generatePriorities() {
        List<List<String>> result = new ArrayList<>();
        generatePermutations(new ArrayList<>(), new boolean[3], result);
        return result;
    }
    
    private void generatePermutations(List<String> current, boolean[] used, List<List<String>> result) {
        if (current.size() == 3) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(operators[i]);
                generatePermutations(current, used, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }
    
    private long calculateWithPriority(List<String> priority) {
        List<Long> nums = new ArrayList<>(numbers);
        List<String> operations = new ArrayList<>(ops);
        
        for (String op : priority) {
            for (int i = 0; i < operations.size(); i++) {
                if (operations.get(i).equals(op)) {
                    long result = calculate(nums.get(i), nums.get(i + 1), op);
                    nums.remove(i + 1);
                    nums.set(i, result);
                    operations.remove(i);
                    i--;
                }
            }
        }
        
        return nums.get(0);
    }
    
    private long calculate(long a, long b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            default: return a * b;
        }
    }
}