class Solution {
    public int[] solution(int[] arr) {
        if (arr.length <= 1) {
            return new int[] {-1};
        }
        
        int min = arr[0];
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        
        boolean delete = false;
        
        int[] result = new int[arr.length - 1];
        
        for (int i = 0; i < result.length; i++) {
            if (delete) {
                result[i] = arr[i + 1];
            } else {
                if (min == arr[i + 1]) {
                    delete = true;
                }
                result[i] = arr[i];
            }
        }
        
        return result;
    }
}