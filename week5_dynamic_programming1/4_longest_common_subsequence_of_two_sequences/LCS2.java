import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int n = a.length;
        int m = b.length;

        int[][] D = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            D[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            D[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                int insertion = D[i][j-1];
                int deletion = D[i-1][j];
                int match = D[i-1][j-1];
                // int mismatch = D[i-1][j-1] + 1;

                if(a[i-1] == b[j-1]){
                    D[i][j] = match + 1;
                    // D[i][j] = Math.min(D[i][j], match);
                } else{
                    D[i][j] = Math.max(insertion, deletion);
                    // D[i][j] = Math.min(D[i][j], mismatch);
                }
            }
        }

        // Print Table
        // for (int i = 0; i <= m; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         System.out.print(D[j][i] + " ");
        //     }
        //     System.out.println();
        // }
        
        // outputAligment(D, n, m, res);
        return D[n][m];
    }

    // private static void outputAligment(int[][] D, int i, int j, int[] res){
    //     if(i==0 && j==0)
    //         return;
    
    //     if(i > 0 && D[i][j] == D[i-1][j] + 1){
    //         outputAligment(D, i-1, j, res);
    //     } else if(j>0 && D[i][j] == D[i][j-1] + 1){
    //         outputAligment(D, i, j-1, res);
    //     } else{
    //         if(D[i][j] == D[i-1][j-1]){
    //             res[0]++;
    //         }

    //         outputAligment(D, i-1, j-1, res);
    //     }
    // }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}



// WORKS !!! BUT SLOW
/*
private static int lcs2(int[] a, int[] b, int i, int j) {
    //Write your code here
    if(i == -1 || j == -1){
        return 0;
    } else if(a[i] == b[j]){
        return 1 + lcs2(a, b, i-1, j-1);
    } else{ 
        // чтобы было максимальное совпадение в подзадаче (под массиве)
        // всеравно добавление только при равенстве
        return Math.max(lcs2(a, b, i-1, j), lcs2(a, b, i, j-1));
    }
}
*/