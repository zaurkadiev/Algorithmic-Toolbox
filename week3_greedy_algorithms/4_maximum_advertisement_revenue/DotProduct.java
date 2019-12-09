import java.lang.reflect.Array;
import java.util.*;

public class DotProduct {
    private static long maxDotProduct(long[] a, long[] b) {
        int n = a.length;
        long[] c = new long[n];
        //write your code here
        Arrays.sort(b);
        Arrays.sort(a);

        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

