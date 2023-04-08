class Solution {
    public int[] solution(long n) {
        String strN = n + "";
        int[] answer = new int[strN.length()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = strN.charAt(strN.length() - i - 1) - 48;
        }
        return answer;
    }
}