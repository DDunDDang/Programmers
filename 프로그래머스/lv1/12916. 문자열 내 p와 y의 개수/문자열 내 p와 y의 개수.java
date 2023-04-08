class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);
            if (check == 'p' || check == 'P') {
                p++;
            }
            if (check == 'y' || check == 'Y') {
                y++;
            }
        }
        return (p == y);
    }
}