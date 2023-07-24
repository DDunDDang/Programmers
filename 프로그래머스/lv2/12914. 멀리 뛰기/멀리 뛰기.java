class Solution {
    public long solution(int n) {
        long[] arr = new long[2001];
        arr[1] = (long)1;
        arr[2] = (long)2;
        
        for (int i = 3; i < 2001; i++) {
          arr[i] = (arr[i - 2] + arr[i - 1]) % (long)1234567;
        }
        
        return arr[n];
    }
}