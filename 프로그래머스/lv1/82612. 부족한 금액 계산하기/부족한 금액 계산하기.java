class Solution {
    public long solution(int price, int money, int count) {
        
        long sum = 0;
        
        for (int i = 1; i <= count; i++) {
            sum += i;
        }

        return money >= price * sum ? 0 : (price * sum) - money;
    }
}