class Solution {
    public String solution(String s) {
        String[] result = new String[s.length()];
        boolean upper = true;
        
        for(int i = 0; i < result.length; i++) {
            char now = s.charAt(i);
            if (now == ' ') {
                upper = true;
                result[i] = " ";
            } else if (upper) {
                upper = false;
                result[i] = String.valueOf(now).toUpperCase();
            } else {
                result[i] = String.valueOf(now).toLowerCase();
            }
        }
        
        return String.join("", result);
    }
}