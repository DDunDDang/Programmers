import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        int maxScore = 0;
        
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            List<Integer> group1 = findGroup(cards, i, visited);
            
            for (int j = 0; j < n; j++) {
                if (visited[j]) continue;
                
                List<Integer> group2 = findGroup(cards, j, visited);
                maxScore = Math.max(maxScore, group1.size() * group2.size());
            }
        }
        
        return maxScore;
    }
    
    private List<Integer> findGroup(int[] cards, int start, boolean[] visited) {
        List<Integer> group = new ArrayList<>();
        int current = start;
        
        while (!visited[current]) {
            visited[current] = true;
            group.add(current + 1);
            current = cards[current] - 1;
        }
        
        return group;
    }
}