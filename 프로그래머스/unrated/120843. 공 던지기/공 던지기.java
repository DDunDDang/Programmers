class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        // 참여자의 수 확인
        if (numbers.length % 2 == 0) { // 짝수
            int num = numbers.length / 2;
            num = (k - 1) % num;
            answer = numbers[(num * 2)];
        } else { // 홀수
            int[] newNumbers = new int[numbers.length];
            
            for (int i = 0; i < numbers.length; i++) {
                if (i % 2 == 0) {
                    newNumbers[i / 2] = numbers[i];
                } else {
                    newNumbers[(numbers.length / 2) + ((i / 2) + 1)] = numbers[i];
                }
            }
            answer = newNumbers[(k - 1) % numbers.length];
        }
        
        return answer;
    }
}