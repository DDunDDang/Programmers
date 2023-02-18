class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] material = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            material[i] = s.charAt(i);
        }
        
        for (int i = 0; i < material.length; i++) {
            for (int j = 0; j < index; j++){
                
                if(material[i] == 'z') {
                    material[i] = 'a';
                } else {
                    material[i]++;
                }
                while (skip.contains(String.valueOf(material[i]))){
                    if(material[i] == 'z') {
                        material[i] = 'a';
                    } else {
                        material[i]++;
                    }
                }
            }
            answer += String.valueOf(material[i]);
        }
        
        
        return answer;
    }
}