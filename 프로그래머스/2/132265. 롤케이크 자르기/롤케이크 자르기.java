import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int size = topping.length;

        HashSet<Integer> brother_1 = new HashSet<>();
        HashMap<Integer, Integer> brother_2 = new HashMap<>();

        brother_1.add(topping[0]);
        for (int i = 1;i < size; i++) {
            brother_2.put(topping[i], brother_2.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 1;i < size; i++) {
            brother_1.add(topping[i]);
            brother_2.put(topping[i], brother_2.get(topping[i]) - 1);
            if (brother_2.get(topping[i]) == 0) {
                brother_2.remove(topping[i]);
            }
            if (brother_1.size() == brother_2.size()) answer++;
        }


        return answer;
    }
}