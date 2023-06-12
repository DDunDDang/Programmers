class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        
        if (dot[0] > 0) {
            answer = dot[0] * dot[1] > 0 ? 1 : 4;
        } else {
            answer = dot[0] * dot[1] > 0 ? 3 : 2;
        }
        
        return answer;
    }
}