import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        // we need a matri here W by n
        int[][] value = new int[W + 1][w.length + 1];
        // init for all j==0 or i==0
        for (int i = 0; i <= W; i++) {
          value[i][0] = 0;
        }
        for (int i = 0; i <= w.length; i++) {
          value[0][i] = 0;
        }
        // check table
        // printTable(value);
        
        for (int i = 1; i <= w.length; i++) {
          for (int j = 1; j <= W; j++) {
            value[j][i] = value[j][i-1];
            if(w[i-1] <= j){
              int val = value[j - w[i-1]][i-1] + w[i-1];
              if(value[j][i] < val){
                value[j][i] = val;
              }
            }
          }
        }

        // printTable(value);
        
        return value[W][w.length];
    }

    private static void printTable(int[][] value){
      String border = "";
      for (int i = 0; i < value.length; i++) {
        border += "==";
      }
      System.out.println(border);
      for (int j = 0; j < value[0].length; j++) {
        for (int i = 0; i < value.length; i++) {
          System.out.print(value[i][j]+" ");
        }
        System.out.println();
      }
      System.out.println(border);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

