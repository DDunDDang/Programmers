import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        dist[1] = 0;
        pq.offer(new int[]{1, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int v = cur[0], d = cur[1];
            
            if (d > dist[v]) continue;
            
            for (int[] next : graph.get(v)) {
                int nv = next[0], nd = d + next[1];
                if (nd < dist[nv]) {
                    dist[nv] = nd;
                    pq.offer(new int[]{nv, nd});
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
}