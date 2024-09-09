import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        Set<Set<String>> result = new HashSet<>();
        backtrack(user_id, banned_id, 0, new HashSet<>(), result);
        return result.size();
    }

    private void backtrack(String[] user_id, String[] banned_id, int start, Set<String> current, Set<Set<String>> result) {
        if (current.size() == banned_id.length) {
            result.add(new HashSet<>(current));
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!current.contains(user_id[i]) && match(user_id[i], banned_id[current.size()])) {
                current.add(user_id[i]);
                backtrack(user_id, banned_id, i + 1, current, result);
                current.remove(user_id[i]);
            }
        }
    }

    private boolean match(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length())
            return false;

        for (int i = 0; i < user_id.length(); i++) {
            if (banned_id.charAt(i) == '*')
                continue;
            if (user_id.charAt(i) != banned_id.charAt(i))
                return false;
        }

        return true;
    }
}