class Solution {
    public String solution(String s) {
        boolean a = true;
        String[] result = new String[s.length()];
        for(int i = 0; i < result.length; i++) {
            if(s.charAt(i) == ' ') {
                a = true;
                result[i] = String.valueOf(s.charAt(i));
            } else if(a) {
                a = !a;
                result[i] = String.valueOf(s.charAt(i)).toUpperCase();  
            } else {
                a = !a;
                result[i] = String.valueOf(s.charAt(i)).toLowerCase();
            }
        }
        
        return String.join("", result);
    }
}