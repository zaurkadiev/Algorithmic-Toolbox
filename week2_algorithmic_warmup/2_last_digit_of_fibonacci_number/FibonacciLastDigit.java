import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    private static long getFibonacciLastDigitFast(long n){

        long prevprev = 0;
        long prev = 1;
        long current = 0;

        for (long i = 2; i <= n; i++) {
            current = (prevprev + prev) % 10;
            prevprev = prev;
            prev = current;
        }

        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long c = getFibonacciLastDigitFast(n);
        System.out.println(c);
    }
}

