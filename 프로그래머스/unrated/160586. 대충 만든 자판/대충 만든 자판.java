class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];         
        
        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                int min = 101;
                for (int k = 0; k < keymap.length; k++) {
                    if (keymap[k].contains(String.valueOf(targets[i].charAt(j)))) {
                        min = min > keymap[k].indexOf(targets[i].charAt(j)) ? keymap[k].indexOf(targets[i].charAt(j)) : min;
                    }
                }       
                if (min == 101) {
                    answer[i] = -1;
                    break;
                }
                count += min + 1;     
            }
            if (answer[i] != -1) answer[i] = count;    
        }
        return answer;
    }
}