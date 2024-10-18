class Solution {
    public int[] solution(long begin, long end) {
        int b = (int)begin;
        int e = (int)end;
        int[] answer = new int[e - b + 1];
        
        for (int i = b; i <= e; i++) {
            int idx = i - b;
            
            if (i == 1) {
                answer[idx] = 0;
                continue;
            }
            
            answer[idx] = findLargestDivisor(i);
        }
        
        return answer;
    }
    
    private int findLargestDivisor(int num) {
        int sqrt = (int)Math.sqrt(num);
        int maxDivisor = 1;
        
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                maxDivisor = i;
                
                if (num/i <= 10000000) {
                    return num/i;
                }
            }
        }
        
        return maxDivisor;
    }
}