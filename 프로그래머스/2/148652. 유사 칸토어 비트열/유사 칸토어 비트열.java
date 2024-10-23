class Solution {
    public int solution(int n, long l, long r) {
        return countOnes(n, l, r);
    }
    
    private int countOnes(int n, long left, long right) {
        if (n == 0) {
            return 1;
        }
        
        long prevSize = (long) Math.pow(5, n-1);
        long currentSize = 5 * prevSize;
        
        if (right < 1 || left > currentSize) {
            return 0;
        }
        
        int result = 0;
        for (int i = 0; i < 5; i++) {
            long start = i * prevSize + 1;
            long end = (i + 1) * prevSize;
            
            if (left <= end && right >= start) {
                if (i == 2) {
                    continue;
                }
                
                long overlapStart = Math.max(start, left);
                long overlapEnd = Math.min(end, right);
                
                result += countOnes(n-1, 
                                  overlapStart - start + 1, 
                                  overlapEnd - start + 1);
            }
        }
        
        return result;
    }
}