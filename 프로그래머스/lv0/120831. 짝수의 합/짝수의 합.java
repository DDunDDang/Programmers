class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int now = 0;
        while (now <= n) {
            answer += now;
            now += 2;
        }
        
        return answer;
    }
}