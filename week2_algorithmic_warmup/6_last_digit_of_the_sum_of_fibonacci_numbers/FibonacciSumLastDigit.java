import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    private static long getFibonacciSumFast(long n) {
        if (n <= 1)
            return n;
        

        long pp = getPisanoPeriod(10); // last digit
        long q = n / pp;
        long r = n - q*pp;


        long sum = getFn(r + 2) - 1;

        return sum % 10;
    }

    private static long getPisanoPeriod(long m){
        // ищем товый 01 и считаем его длинну через i
        // сurr - сумма 2 пред и взять оcтаток от деления то есть посление цифры
        // так как нужны 01, то можно элементами иметь остатки от m
        // складывать по фибоначи и тоже иметь отаток по m -> нет переполнений
        long prev = 1;
        long prevprev = 0;
        for (long i = 2; true; i++) {
            long current = (prev + prevprev) % m;
            prevprev = prev;
            prev = current;
            if(current == 1 && prevprev == 0){
                return i - 1;
            }
            prev = current;
        }
    }


    private static long getFn(long n){

        int prevprev = 0;
        int prev = 1;
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = (prevprev + prev) % 100;
            prevprev = prev;
            prev = current;
        }

        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumFast(n);
        System.out.println(s);
    }
}

