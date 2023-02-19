import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arrlist = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                arrlist.add(arr[i]);
            }
        }
        if(arrlist.isEmpty()) return new int[]{-1};
        
        int[] answer = arrlist.stream().sorted().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}