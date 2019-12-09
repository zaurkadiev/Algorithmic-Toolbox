import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static int getPisanoPeriod(long m){
        // ищем товый 01 и считаем его длинну через i
        // сurr - сумма 2 пред и взят отаток от деления то есть посление цифры
        // так как нужны 01, то можно элементами иметь остатки от m
        // складывать по фибоначи и тоже иметь отаток по m -> нет переполнений
        long prev = 1;
        long prevprev = 0;
        for (int i = 2; true; i++) {
            long current = (prev + prevprev) % m;
            prevprev = prev;
            prev = current;
            if(current == 1 && prevprev == 0){
                return i - 1;
            }
            prev = current;
        }
    }

    private static long getFibonacciHugeFast(long n, long m) {
        if (n <= 1)
            return n;

        long pp = getPisanoPeriod(m);
        long q = n / pp;
        long r = n - q * pp;
        // System.out.println(pp);
        // System.out.println(r);
        return getFibonacciLastDigitFast(r, m);
    }

    private static long getFibonacciLastDigitFast(long n, long m) {
        if (n <= 1)
            return n;
        
        long[] arr = new long[(int) n + 1];
        arr[0] = 0;
        arr[1] = 1;
    
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % m;
        }
    
        return arr[(int) n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeFast(n, m));
    }
}

