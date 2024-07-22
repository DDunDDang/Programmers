class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int ret = getCntFromMidNight(h2, m2, s2) - getCntFromMidNight(h1, m1, s1);
        if ((h1 == 0 || h1 == 12) && m1 == 0 && s1 == 0) ret += 1;
        return ret;
    }

    private int getCntFromMidNight(int h, int m, int s) {
        double hDegree = (h * 30 + m * 0.5 + s * 0.5 / 60) % 360;
        double mDegree = (m * 6 + s * 0.1) % 360;
        double sDegree = s * 6;
        
        int ret = -1;
        
        if (sDegree >= mDegree) ret += 1;
        if (sDegree >= hDegree) ret += 1;

        ret += (h * 60 + m) * 2;
        ret -= h;
        if (h >= 12) ret -= 2;
        return ret;
    }
}