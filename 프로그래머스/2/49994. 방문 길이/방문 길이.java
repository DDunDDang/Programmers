import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        
        int currentX = 0;
        int currentY = 0;

        for(int i = 0; i < dirs.length(); i++) {
            int nextX = currentX;
            int nextY = currentY;
            String way = "";
            
            if (dirs.charAt(i) == 'U') {
                nextY++;
                way += currentX;
                way += currentY;
                way += nextX;
                way += nextY;
            } else if (dirs.charAt(i) == 'D') {
                nextY--;
                way += nextX;
                way += nextY;
                way += currentX;
                way += currentY;
            } else if (dirs.charAt(i) == 'R') {
                nextX++;
                way += currentX;
                way += currentY;
                way += nextX;
                way += nextY;
            } else if (dirs.charAt(i) == 'L') {
                nextX--;
                way += nextX;
                way += nextY;
                way += currentX;
                way += currentY;
            }

            if (nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5)
                continue;

            set.add(way);
            currentX = nextX;
            currentY = nextY;
        }
        
        answer = set.size();
        return answer;
    }
}