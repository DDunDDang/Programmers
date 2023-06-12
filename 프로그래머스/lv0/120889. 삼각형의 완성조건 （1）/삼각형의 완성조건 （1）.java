class Solution {
    public int solution(int[] sides) {
        int max = 0;
        int maxIndex = 0;
        int judge = 0;
        
        for (int i = 0; i < sides.length; i++) {
            if (max < sides[i]) {
                max = sides[i];
                maxIndex = i;
            }
        }
        
        for (int i = 0; i < sides.length; i++) {
            judge += maxIndex != i ? sides[i] : 0;
        }
        
        return judge > max ? 1 : 2;
    }
}