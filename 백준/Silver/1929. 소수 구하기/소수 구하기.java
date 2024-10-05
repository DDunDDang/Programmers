import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    static boolean isPrime(int a) {
        if (a == 2) {
            return true;
        }
        if (a < 2 || a % 2 == 0) {
            return false;
        }

        int b = (int) Math.sqrt(a);
        for (int c = 3; c <= b; c += 2) {
            if (a % c == 0) {
                return false;
            }
        }

        return true;
    }
}
