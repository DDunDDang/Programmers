import java.util.*;

class Solution {
    int n, m;
    int[][] land;
    boolean[][] visited;
    Map<Integer, Integer> oilSize;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solution(int[][] land) {
        this.land = land;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        oilSize = new HashMap<>();

        int oilId = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(i, j, oilId);
                    oilSize.put(oilId, size);
                    oilId++;
                }
            }
        }

        int[] columnOil = new int[m];
        for (int j = 0; j < m; j++) {
            Set<Integer> oilIds = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (land[i][j] >= 2) {
                    oilIds.add(land[i][j]);
                }
            }
            for (int id : oilIds) {
                columnOil[j] += oilSize.get(id);
            }
        }

        return Arrays.stream(columnOil).max().getAsInt();
    }

    private int dfs(int r, int c, int oilId) {
        if (r < 0 || r >= n || c < 0 || c >= m || visited[r][c] || land[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;
        land[r][c] = oilId;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            size += dfs(nr, nc, oilId);
        }

        return size;
    }
}