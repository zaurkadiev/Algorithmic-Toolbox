import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here

        int n = a.length;
        int m = b.length;
        int p = c.length;

        int[][][] D = new int[n+1][m+1][p+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= p; k++) {

                    int insertion = D[i][j-1][k];
                    int deletion = D[i-1][j][k];
                    int peletion = D[i][j][k-1];

                    int match = D[i-1][j-1][k-1];

                    if(i==0 || j==0 || k==0){
                        D[i][j][k] = 0;
                    } else if(a[i-1] == b[j-1] && a[i-1] == c[k - 1]){
                        D[i][j][k] = match + 1;
                    } else{
                        D[i][j][k] = Math.max(insertion, deletion);
                        D[i][j][k] = Math.max(D[i][j][k], peletion);
                    }
                }
            }
        }

        return D[n][m][p];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

