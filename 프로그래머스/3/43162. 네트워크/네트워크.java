class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int[][] computers, boolean[] visited, int v) {
        visited[v] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (computers[v][i] == 1 && !visited[i]) {
                dfs(computers, visited, i);
            }
        }
    }
}