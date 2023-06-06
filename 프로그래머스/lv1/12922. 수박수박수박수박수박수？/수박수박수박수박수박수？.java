class Solution {
    public String solution(int n) {
        String[] result = new String[n];
        
        for (int i = 0; i < result.length; i++) {
            if (i % 2 == 0) {
                result[i] = "수";
            } else {
                result[i] = "박";
            }
        }
        
        return String.join("", result);
    }
}