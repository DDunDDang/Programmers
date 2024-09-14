import java.util.*;

class Solution {
    private int m, n;
    private int[][] grid;
    private boolean[][] visited;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        m = maps.length;
        n = maps[0].length();
        grid = new int[m][n];
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = maps[i].charAt(j);
                grid[i][j] = c == 'X' ? 0 : c - '0';
            }
        }
        
        List<Integer> islandDays = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    int days = dfs(i, j);
                    islandDays.add(days);
                }
            }
        }
        
        if (islandDays.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(islandDays);
        
        return islandDays.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int dfs(int x, int y) {
        visited[x][y] = true;
        int days = grid[x][y];
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] > 0 && !visited[nx][ny]) {
                days += dfs(nx, ny);
            }
        }
        
        return days;
    }
}