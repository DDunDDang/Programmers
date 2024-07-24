import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n, m;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        int[] start = findPosition(maps, 'S');
        int[] lever = findPosition(maps, 'L');
        int[] end = findPosition(maps, 'E');
        
        int toLever = bfs(maps, start, lever);
        if (toLever == -1) return -1;
        
        int toEnd = bfs(maps, lever, end);
        if (toEnd == -1) return -1;
        
        return toLever + toEnd;
    }
    
    private int[] findPosition(String[] maps, char target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    private int bfs(String[] maps, int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], dist = current[2];
            
            if (x == end[0] && y == end[1]) {
                return dist;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    queue.offer(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return -1;
    }
}