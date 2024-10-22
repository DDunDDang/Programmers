class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        int minMove = length - 1;
        
        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            int up = c - 'A';
            int down = 'Z' - c + 1;
            answer += Math.min(up, down);
            
            int nextIndex = i + 1;
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            
            minMove = Math.min(minMove, 
                     Math.min(i * 2 + (length - nextIndex), 
                             (length - nextIndex) * 2 + i));
        }
        
        return answer + (minMove < 0 ? 0 : minMove);
    }
}