import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }
    
    private static long getFibonacciSumFast(long m, long n) {
        if (n <= 1)
            return n;
        

        long pp = getPisanoPeriod(10); // last digit
        
        long q = n / pp;
        long rn = n - q*pp;

        q = m / pp;
        long rm = m - q*pp;
    

        long sum1 = getFn(rn + 2) - 1;
        long sum2 = getFn(rm + 2 - 1) - 1;

        sum2 = sum2 > 0 ? sum2 : 0;
        sum1 = sum1 > 0 ? sum1 : 0;


        // System.out.println(sum1);
        // System.out.println(sum2);
        // System.out.println(sum1-sum2);

        return (sum1-sum2 % 10) % 10;
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


    private static long getFn(long n){

        long prevprev = 0;
        long prev = 1;
        long current = 0;

        for (int i = 2; i <= n; i++) {
            current = (prevprev + prev) % 100;
            prevprev = prev;
            prev = current;
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciSumFast(from, to));
    }
}

