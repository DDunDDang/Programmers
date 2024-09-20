class Solution {
    public int solution(int[][] board) {
        int rowLength = board.length;
        int colLength = board[0].length;
        int[][] dp = new int[rowLength + 1][colLength + 1];
        int maxSize = 0;

        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= colLength; j++) {
                if (board[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }

        return maxSize * maxSize;
    }
}