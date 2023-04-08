class Solution {
    public boolean solution(int x) {
        int X = x;
        int y = 0;
        while(x >= 10) {
            y += (x % 10);
            x /= 10;
        }
        y += x;
        return (X % y == 0);
    }
}