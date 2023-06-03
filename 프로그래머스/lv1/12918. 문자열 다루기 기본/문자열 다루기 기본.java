class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char n = s.charAt(i);
            if (n < 48 || n > 57) {
                return false;
            }
        }
        return answer;
    }
}