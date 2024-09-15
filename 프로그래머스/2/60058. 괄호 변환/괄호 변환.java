class Solution {
    public String solution(String p) {
        if (p.isEmpty()) return "";

        int balanceIndex = getBalanceIndex(p);
        String u = p.substring(0, balanceIndex);
        String v = p.substring(balanceIndex);

        if (isCorrect(u)) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            sb.append(reverseParentheses(u.substring(1, u.length() - 1)));
            return sb.toString();
        }
    }

    // 균형잡힌 괄호 문자열의 인덱스를 찾는 메소드
    private int getBalanceIndex(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            else count--;
            if (count == 0) return i + 1;
        }
        return s.length();
    }

    // 올바른 괄호 문자열인지 확인하는 메소드
    private boolean isCorrect(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    // 괄호 방향을 뒤집는 메소드
    private String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') sb.append(")");
            else sb.append("(");
        }
        return sb.toString();
    }
}