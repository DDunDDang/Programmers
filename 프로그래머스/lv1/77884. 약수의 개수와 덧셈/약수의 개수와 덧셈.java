class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            double a = Math.sqrt(i);
            int count = 0;
            for (int j = 1; j <= a; j++) {
                if (i % j == 0) {
                    count += 2;
                } 
            }
            if (a == Math.round(a)) {
                count -= 1;
            }
            if(count % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
}