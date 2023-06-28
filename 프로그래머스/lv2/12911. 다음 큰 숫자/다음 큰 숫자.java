class Solution {
    public int solution(int n) {
        String current = Integer.toBinaryString(n);
            int cntOne = 0;
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) == '1') {
                    cntOne++;
                }
            }

            for (int i = n + 1;; i++) {
                String next = Integer.toBinaryString(i);

                int nextCntOne = 0;
                for (int j = 0; j < next.length(); j++) {
                    if (next.charAt(j) == '1') {
                        nextCntOne++;
                    }
                }

                if (cntOne == nextCntOne) {
                    return i;
                }
            }
    }
}