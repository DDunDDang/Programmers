import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int minDifference = n;
        
        for (int i = 0; i < wires.length; i++) {
            List<int[]> remainingWires = new ArrayList<>();
            for (int j = 0; j < wires.length; j++) {
                if (i != j) {
                    remainingWires.add(wires[j]);
                }
            }
            
            Set<Integer> group1 = new HashSet<>();
            Set<Integer> group2 = new HashSet<>();
            
            group1.add(remainingWires.get(0)[0]);
            
            for (int k = 1; k <= n; k++) {
                if (!group1.contains(k)) {
                    group2.add(k);
                }
            }
            
            boolean changed;
            do {
                changed = false;
                for (int[] wire : remainingWires) {
                    int v1 = wire[0], v2 = wire[1];
                    if (group1.contains(v1) && !group1.contains(v2)) {
                        group1.add(v2);
                        group2.remove(v2);
                        changed = true;
                    } else if (group1.contains(v2) && !group1.contains(v1)) {
                        group1.add(v1);
                        group2.remove(v1);
                        changed = true;
                    }
                }
            } while (changed);
            
            int difference = Math.abs(group1.size() - group2.size());
            
            minDifference = Math.min(minDifference, difference);
        }
        
        return minDifference;
    }
}