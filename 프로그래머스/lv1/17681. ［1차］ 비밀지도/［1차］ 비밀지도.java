class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < answer.length; i++) {
            String row = "";
            String bin1 = Integer.toBinaryString(arr1[i]);
            String bin2 = Integer.toBinaryString(arr2[i]);
            
            bin1 = padBinaryString(bin1, n);
            bin2 = padBinaryString(bin2, n);
            
            for (int j = 0; j < answer.length; j++) {
                if (bin1.charAt(j) == '0' && bin2.charAt(j) == '0') {
                    row += " ";
                } else row += "#";
            }
            
            answer[i] = row;
        }
        return answer;
    }
    
    private String padBinaryString(String binaryString, int length) {
        int paddingLength = length - binaryString.length();
        StringBuilder paddedString = new StringBuilder();
            for (int i = 0; i < paddingLength; i++) {
                paddedString.append("0");
            }
        paddedString.append(binaryString);
        return paddedString.toString();
    }
}