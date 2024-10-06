import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n, m;

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        int[] start = findPosition(board, 'R');
        int[] goal = findPosition(board, 'G');
        
        return bfs(board, start, goal);
    }
    
    private int[] findPosition(String[] board, char target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    private int bfs(String[] board, int[] start, int[] goal) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][4];
        
        queue.offer(new int[]{start[0], start[1], -1, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], dir = current[2], moves = current[3];
            
            if (x == goal[0] && y == goal[1]) {
                return moves;
            }
            
            for (int i = 0; i < 4; i++) {
                if (i == dir) continue;
                
                int nx = x, ny = y;
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx].charAt(ny) == 'D') {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                
                if (!visited[nx][ny][i]) {
                    visited[nx][ny][i] = true;
                    queue.offer(new int[]{nx, ny, i, moves + 1});
                }
            }
        }
        
        return -1;
    }
}