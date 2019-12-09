import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }

    private static long getFibonacciSumSquaresFast(long n) {
        if (n <= 1)
            return n;


        long pp = getPisanoPeriod(10); // last digit
    
        long q = n / pp;
        long r1 = n - q*pp;

        q = (n + 1) / pp;
        long r2 = n + 1 - q*pp;

        long res1 = getFn(r2);
        long res2 = getFn(r1);

        // System.out.println(r1);
        // System.out.println(r2);

        return (res1*res2) % 10;
    }

    private static long getFn(long n){

        long prevprev = 0;
        long prev = 1;
        long current = 0;

        for (long i = 2; i <= n; i++) {
            current = (prevprev + prev) % 100;
            prevprev = prev;
            prev = current;
        }

        return current;
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

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresFast(n);
        System.out.println(s);
    }
}

