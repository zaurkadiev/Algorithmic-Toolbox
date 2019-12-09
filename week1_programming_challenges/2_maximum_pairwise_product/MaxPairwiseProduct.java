import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    // static int getMaxPairwiseProduct(int[] numbers) {
    //     int max_product = 0;
    //     int n = numbers.length;

    //     for (int first = 0; first < n; ++first) {
    //         for (int second = first + 1; second < n; ++second) {
    //             max_product = max(max_product, numbers[first] * numbers[second]);
    //         }
    //     }

    //     return max_product;
    // }

    static long getMaxPairwiseProductFast(int[] numbers) {
        int n = numbers.length;
        int first = 0;
        int second = 1;

        int maximum = -1;
        for (int i = 0; i < n; ++i) {
            if(numbers[i] > maximum){
                maximum = numbers[i];
                first = i;
            }
        }

        maximum = -1;
        for (int i = 0; i < n; ++i) {
            if(numbers[i] > maximum && first != i){
                maximum = numbers[i];
                second = i;
            }
        }

        return ((long) numbers[first])*numbers[second];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProductFast(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}