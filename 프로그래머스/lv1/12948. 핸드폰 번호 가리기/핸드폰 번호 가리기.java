class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        String[] answer = new String[len];
        
        for (int i = 0; i < len; i++) {
            answer[i] = "*";
        }
        
        for (int i = len - 4; i < len; i++) {
            answer[i] = String.valueOf(phone_number.charAt(i));
        }
        
        return String.join("", answer);
    }
}