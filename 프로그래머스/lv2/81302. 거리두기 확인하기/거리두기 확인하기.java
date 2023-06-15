import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private static final int SIZE = 5;
    private static final int[][] DIRS = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };
    
    private boolean isValid(int r, int c) {
        return 0 <= r && r < SIZE && 0 <= c && c < SIZE;
    }
    
    public int[] solution(String[][] places) {
       // 목표: 각 대기실별로 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 배열에 담아 return
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[][] place = new String[SIZE][SIZE];
            for (int r = 0; r < SIZE; r++) {
                place[r] = places[i][r].split("");
            }

            List<int[]> people = getPeople(place);
            boolean isSafe = people.stream()
                    .allMatch(p -> bfs(p, place));
            answer[i] = isSafe ? 1 : 0;
        }
        return answer;
    }

    // 각 방의 모든 사람의 좌표를 List 에 담아 리턴
    public List<int[]> getPeople(String[][] place) {
        List<int[]> peopleList = new ArrayList<>();

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (place[r][c].equals("P")) {
                    peopleList.add(new int[]{r, c, 0});
                }
            }
        }

        return peopleList;
    }

    public boolean bfs(int[] p, String[][] place) {
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(p);

        while (!Q.isEmpty()) {
            int[] current = Q.poll();
            int r = current[0];
            int c = current[1];
            int cnt = current[2];
            place[r][c] = "X";

            for (int[] dir : DIRS) {
                int dR = dir[0];
                int dC = dir[1];
                int R = r + dR;
                int C = c + dC;
                
                if (isValid(R, C) && !place[R][C].equals("X") && cnt < 2) {
                    if (place[R][C].equals("P")) {
                        return false;
                    } else {
                        Q.offer(new int[]{R, C, cnt + 1});
                    }
                }
            }
        }
        return true;
    }

}