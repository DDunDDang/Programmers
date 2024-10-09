import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];
        int[][] groups = new int[Math.min((minerals.length + 4) / 5, totalPicks)][3];
        
        for (int i = 0; i < minerals.length && i / 5 < totalPicks; i++) {
            if (minerals[i].equals("diamond")) {
                groups[i / 5][0] += 1;
                groups[i / 5][1] += 5;
                groups[i / 5][2] += 25;
            } else if (minerals[i].equals("iron")) {
                groups[i / 5][0] += 1;
                groups[i / 5][1] += 1;
                groups[i / 5][2] += 5;
            } else {
                groups[i / 5][0] += 1;
                groups[i / 5][1] += 1;
                groups[i / 5][2] += 1;
            }
        }
        
        // 피로도가 높은 순으로 그룹 정렬
        Arrays.sort(groups, (a, b) -> b[2] - a[2]);
        
        // 곡괭이로 광물 캐기
        int pickIndex = 0;
        for (int[] group : groups) {
            while (pickIndex < 3 && picks[pickIndex] == 0) {
                pickIndex++;
            }
            if (pickIndex == 3) break;
            
            picks[pickIndex]--;
            answer += group[pickIndex];
        }
        
        return answer;
    }
}