import java.util.*;
import java.io.*;

public class MajorityElement {
    private static boolean getMajorityElement(int[] a, int left, int right) {
        
        Arrays.sort(a);
        int max = 0;
        while(true){

            if(right == a.length){
                int nmax = right-left;
                if(max < nmax){
                    max = nmax;
                }
                break;
            }

            if(a[left] == a[right]){
                right++;
            }else{
                int nmax = right-left;
                if(max < nmax){
                    max = nmax;
                }
                left = right;
            }
        }

        return a.length / 2 < max;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, 0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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

