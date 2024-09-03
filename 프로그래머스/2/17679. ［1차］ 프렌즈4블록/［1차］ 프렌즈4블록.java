class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        int answer = 0;
        boolean flag = true;
        
        while (flag) {
            flag = false;
            boolean[][] checked = new boolean[m][n];
            
            // 2x2 블록 찾기
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == '0') continue;
                    if (map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j] && map[i][j] == map[i+1][j+1]) {
                        checked[i][j] = true;
                        checked[i][j+1] = true;
                        checked[i+1][j] = true;
                        checked[i+1][j+1] = true;
                        flag = true;
                    }
                }
            }
            
            // 블록 제거 및 카운트
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (checked[i][j]) {
                        map[i][j] = '0';
                        answer++;
                    }
                }
            }
            
            // 블록 떨어뜨리기
            for (int j = 0; j < n; j++) {
                int index = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != '0') {
                        map[index--][j] = map[i][j];
                    }
                }
                for (int i = index; i >= 0; i--) {
                    map[i][j] = '0';
                }
            }
        }
        
        return answer;
    }
}