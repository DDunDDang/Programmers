class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] procession = new int[rows][columns];

        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                procession[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int r1 = queries[i][0] - 1;
            int c1 = queries[i][1] - 1;
            int r2 = queries[i][2] - 1;
            int c2 = queries[i][3] - 1;

            int tmp = procession[r1][c1];
            int min = tmp;
            for (int j = r1; j < r2; j++) {
                procession[j][c1] = procession[j + 1][c1];
                if (min > procession[j][c1]) min = procession[j][c1];
            }
            for (int j = c1; j < c2; j++) {
                procession[r2][j] = procession[r2][j + 1];
                if (min > procession[r2][j]) min = procession[r2][j];
            }
            for (int j = r2; j > r1; j--) {
                procession[j][c2] = procession[j - 1][c2];
                if(min > procession[j][c2]) min = procession[j][c2];
            }
            for (int j = c2; j > c1; j--) {
                procession[r1][j] = procession[r1][j - 1];
                if (min > procession[r1][j]) min = procession[r1][j];
            }
            procession[r1][c1 + 1] = tmp;

            answer[i] = min;
        }

        return answer;
    }
}