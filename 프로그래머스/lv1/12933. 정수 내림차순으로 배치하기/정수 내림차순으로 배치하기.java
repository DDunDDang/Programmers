class Solution {
    public long solution(long n) {
        String strN = Long.toString(n);
        String[] arr = strN.split("");
        boolean change = true;
        while(change) {
            change = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (Integer.valueOf(arr[i]) < Integer.valueOf(arr[i + 1])) {
                    String temp =  arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    change = true;
                }
            }
        }
        String sortedStr = String.join("", arr);
        return Long.parseLong(sortedStr);
    }
}