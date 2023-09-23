class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int unknown = 0;
        int matchCount = 0;
        
        for (int lottoNum : lottos) {
            if (lottoNum == 0) unknown++;
            else {
                for (int win_num : win_nums) {
                    if (lottoNum == win_num) matchCount++;
                }
            }
        }
        
        int max = 7 - (matchCount + unknown) <= 6 ? 7 - (matchCount + unknown) : 6;
        int min = 7 - matchCount <= 6 ? 7 - matchCount : 6;
        
        return new int[]{max, min};
    }
}