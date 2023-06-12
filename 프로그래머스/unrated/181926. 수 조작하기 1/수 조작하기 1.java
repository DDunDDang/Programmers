class Solution {
    public int solution(int n, String control) {
        int answer = n;
        
        for (int i = 0; i < control.length(); i++) {
            char now = control.charAt(i);
            
            if (now == 'w') {
                answer += 1;
            } else if (now == 's') {
                answer -= 1;
            } else if (now == 'd') {
                answer += 10;
            } else {
                answer -= 10;
            }
        }
        return answer;
    }
}