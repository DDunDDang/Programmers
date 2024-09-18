import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int totalCost = 0;
        int edgeCount = 0;
        
        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int edgeCost = cost[2];
            
            if (find(parent, from) != find(parent, to)) {
                union(parent, from, to);
                totalCost += edgeCost;
                edgeCount++;
                
                if (edgeCount == n - 1) {
                    break;
                }
            }
        }
        
        return totalCost;
    }
    
    private int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent, parent[node]);
    }
    
    private void union(int[] parent, int node1, int node2) {
        int root1 = find(parent, node1);
        int root2 = find(parent, node2);
        if (root1 != root2) {
            parent[root2] = root1;
        }
    }
}
