class Solution {
    public String solution(String s) {
        char[] charArr = new char[s.length()];
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = s.charAt(i);
        }
        boolean change = true;
        while (change) {
            change = false;
            for (int i = 0; i < charArr.length - 1; i++) {
                if (charArr[i] < charArr[i + 1]) {
                    char temp = charArr[i];
                    charArr[i] = charArr[i + 1];
                    charArr[i + 1] = temp;
                    change = true;
                }
            }
        }
        return String.join("", String.valueOf(charArr));
    }
}