import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 1;
        
        int count = 3;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        
        while (count <= n) {
            boolean isPrime = true;
            
            if (count % 2 == 0) {
                count ++;
                continue;
            }
            for (int i = 0; i <= arr.size(); i++) {
                
                if(arr.get(i) > Math.sqrt(count)) {
                    break;
                }
                
                if(count % arr.get(i) == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (isPrime) {
                arr.add(count);
                answer ++;
            }
            
            count ++;
        }
        return answer;
    }
}