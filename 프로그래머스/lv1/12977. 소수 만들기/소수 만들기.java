import java.util.*;

class Solution {
    public int solution(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                   arr.add(nums[i] + nums[j] + nums[k]); 
                }
            }
        }
        
        for (int i = 0; i < arr.size(); i++) {
            int now = arr.get(i);
            boolean check = true;
            
            for (int j = 2; j <= Math.sqrt(now); j++) {
                if(now % j == 0) {
                    check = false;
                }
            }
            
            if(check) {
                result ++;
            }
        }
        
        return result;
        
    }
}