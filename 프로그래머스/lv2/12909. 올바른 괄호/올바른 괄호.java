class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if(now == '(') {
                num += 1;
            } else if(now == ')') {
                num -= 1;
            }
            if (num < 0) {
                return false;
            }
        }

        return num == 0 ? true : false;
    }
}