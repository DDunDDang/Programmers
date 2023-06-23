import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);

        int loserNum = 0;
        for (int i = 1; i < words.length; i++) {
            String preWord = list.get(i - 1);
            String currentWord = words[i];
            if (list.contains(currentWord) || preWord.charAt(preWord.length() - 1) != currentWord.charAt(0)) {
                loserNum = i;
                break;
            }
            list.add(currentWord);
        }

        if (loserNum != 0) {
            return new int[] {loserNum % n + 1 ,loserNum / n + 1};
        }
        return new int[]{0, 0};
    }
}