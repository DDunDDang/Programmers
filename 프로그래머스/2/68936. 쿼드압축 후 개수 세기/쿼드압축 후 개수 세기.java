class Solution {
    int[] count = new int[2];

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return count;
    }

    private void compress(int[][] arr, int x, int y, int size) {
        if (isSame(arr, x, y, size)) {
            count[arr[x][y]]++;
            return;
        }

        int newSize = size / 2;
        compress(arr, x, y, newSize);
        compress(arr, x, y + newSize, newSize);
        compress(arr, x + newSize, y, newSize);
        compress(arr, x + newSize, y + newSize, newSize);
    }

    private boolean isSame(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}