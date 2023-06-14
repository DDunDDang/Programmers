class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");
        
        int max = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[0]);
        
        for(int i = 1; i < split.length; i++) {
            int now = Integer.parseInt(split[i]);
            
            if (now > max) {
                max = now;
            }
            
            if (now < min) {
                min = now;
            }
        }
        
        String answer = "" + min + " " + max;
        return answer;
    }
}