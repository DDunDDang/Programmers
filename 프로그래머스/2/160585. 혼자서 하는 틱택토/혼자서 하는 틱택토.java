class Solution {
    public int solution(String[] board) {
        int countO = 0;
        int countX = 0;
        boolean winO = false;
        boolean winX = false;
        
        // 개수 세기 및 승리 확인
        for (int i = 0; i < 3; i++) {
            if (board[i].equals("OOO")) winO = true;
            if (board[i].equals("XXX")) winX = true;
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') countO++;
                if (board[i].charAt(j) == 'X') countX++;
            }
        }
        
        // 수직 승리 확인
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O') winO = true;
            if (board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X') winX = true;
        }
        
        // 대각선 승리 확인
        if (board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O') winO = true;
        if (board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O') winO = true;
        if (board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X') winX = true;
        if (board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X') winX = true;
        
        // 규칙 검사
        if (countO < countX || countO > countX + 1) return 0;
        if (winO && winX) return 0;
        if (winO && countO != countX + 1) return 0;
        if (winX && countO != countX) return 0;
        
        return 1;
    }
}