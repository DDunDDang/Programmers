class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            String str = skill_trees[i].replaceAll("[^" + skill + "]", "");
            for (int j = 0; j < skill.length() + 1; j++) {
                String sub_skill = skill.substring(0, j);
                if (str.equals(sub_skill)) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}