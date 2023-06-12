class Solution {
    public String solution(String my_string, String letter) {
        if (!my_string.contains(letter)) {
            return my_string;
        }
        String[] answer = my_string.split(letter);
        
        return String.join("", answer);
    }
}