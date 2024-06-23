class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] matrix = new int[n][n];

        int x = -1;
        int y = 0;
        int value = 1;
        // 1: 1
        // 2: 1, 2 3
        // 3: 1, 2 6, 3 4 5
        // 4: 1, 2 9, 3 10 8, 4 5 6 7
        // 5: 1, 2 12, 3 13 11, 4 14 15 10, 5 6 7 8 9

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if(i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                matrix[x][y] = value++;
            }
        }

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) break;
                answer[idx++] = matrix[i][j];
            }
        }

        return answer;
    }
}