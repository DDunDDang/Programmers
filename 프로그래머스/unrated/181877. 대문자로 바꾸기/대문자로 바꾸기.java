class Solution {
    public String solution(String myString) {
        String[] answer = new String[myString.length()];
        
        for (int i = 0; i < myString.length(); i++) {
            answer[i] = String.valueOf(myString.charAt(i)).toUpperCase();
        }
        return String.join("", answer);
    }
}