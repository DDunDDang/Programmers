import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> sequence = generateCollatzSequence(k);
        double[] areas = calculateAreas(sequence);
        
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = sequence.size() - 1 + ranges[i][1];
            
            if (start > end) {
                answer[i] = -1.0;
            } else {
                double sum = 0;
                for (int j = start; j < end; j++) {
                    sum += areas[j];
                }
                answer[i] = sum;
            }
        }
        
        return answer;
    }
    
    private List<Integer> generateCollatzSequence(int k) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(k);
        
        while (k != 1) {
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            sequence.add(k);
        }
        
        return sequence;
    }
    
    private double[] calculateAreas(List<Integer> sequence) {
        double[] areas = new double[sequence.size() - 1];
        
        for (int i = 0; i < sequence.size() - 1; i++) {
            double height1 = sequence.get(i);
            double height2 = sequence.get(i + 1);
            areas[i] = (height1 + height2) / 2.0;
        }
        
        return areas;
    }
}