import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = kNum(n,k);
        String[] arr = s.split("0");
        
        for(String str : arr){
            if (str.equals("")) continue;
            long num = Long.parseLong(str);                       
            if (isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(long n) {
        if (n <= 1) return false;
        else if (n == 2) return true;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0) 
                return false;
        return true;
    }
    
    public String kNum(int n, int k) {
        String str = "";
        while (n > 0) {
            str = n % k + str;
            n /= k;
        }
        return str;
    }
}