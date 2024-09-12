import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = getArrayGCD(arrayA);
        int gcdB = getArrayGCD(arrayB);
        
        int candidateA = canDivide(gcdA, arrayB) ? gcdA : 0;
        int candidateB = canDivide(gcdB, arrayA) ? gcdB : 0;
        
        return Math.max(candidateA, candidateB);
    }
    
    private int getArrayGCD(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = gcd(result, array[i]);
        }
        return result;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private boolean canDivide(int divisor, int[] array) {
        if (divisor == 1) return false;
        for (int num : array) {
            if (num % divisor == 0) return false;
        }
        return true;
    }
}