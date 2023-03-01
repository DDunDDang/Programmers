class Solution {
    public int solution(int[][] sizes) {
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        int w = sizes[0][0];
        int h = sizes[0][1];
        for (int i = 1; i < sizes.length; i++) {
            w = w < sizes[i][0] ? sizes[i][0] : w;
            h = h < sizes[i][1] ? sizes[i][1] : h;
        }
        return h * w;
    }
}