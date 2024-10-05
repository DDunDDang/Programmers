import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (num != 0) {
            int count = 0;
            for (int i = num + 1; i <= num * 2; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }
            System.out.println(count);
            num = scanner.nextInt();
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
