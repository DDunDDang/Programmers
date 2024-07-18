class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int targetX = balls[i][0];
            int targetY = balls[i][1];
            
            int minDistance = Integer.MAX_VALUE;
            
            // 왼쪽 쿠션
            if (!(startY == targetY && startX > targetX)) {
                int dist = (startX + targetX) * (startX + targetX) + (startY - targetY) * (startY - targetY);
                minDistance = Math.min(minDistance, dist);
            }
            
            // 오른쪽 쿠션
            if (!(startY == targetY && startX < targetX)) {
                int dist = (2*m - startX - targetX) * (2*m - startX - targetX) + (startY - targetY) * (startY - targetY);
                minDistance = Math.min(minDistance, dist);
            }
            
            // 위쪽 쿠션
            if (!(startX == targetX && startY < targetY)) {
                int dist = (startX - targetX) * (startX - targetX) + (2*n - startY - targetY) * (2*n - startY - targetY);
                minDistance = Math.min(minDistance, dist);
            }
            
            // 아래쪽 쿠션
            if (!(startX == targetX && startY > targetY)) {
                int dist = (startX - targetX) * (startX - targetX) + (startY + targetY) * (startY + targetY);
                minDistance = Math.min(minDistance, dist);
            }
            
            answer[i] = minDistance;
        }
        
        return answer;
    }
}