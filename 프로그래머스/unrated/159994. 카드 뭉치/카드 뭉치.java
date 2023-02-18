class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int count1 = 0;
        int count2 = 0;
        int a = 0;
        
        while(a < goal.length) {
            
            int check1 = count1;
            int check2 = count2;
            
            if (cards1.length != count1) {
                if (goal[a].equals(cards1[count1])) {
                    count1++;
                    a++;
                }
            }
            
            if (cards2.length != count2) {
                if (goal[a].equals(cards2[count2])) {
                    count2++;
                    a++;
                }
            }
            
            if(check1 == count1 && check2 == count2) {
                return "No";
            }
        }
        return "Yes";
    }
}