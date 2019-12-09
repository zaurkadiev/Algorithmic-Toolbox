import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        // here we use standart DP approach
        // compute app subproblems from 0 to W
        // and try to maximize weight using previous subproblems
        int[] weights = new int[W+1];
        weights[0] = 0;
        for (int i = 1; i <= W; i++) {
          for (int j = 0; j < w.length; j++) {
            if(w[j] <= i){
              int maxWei = weights[i-w[j]] + w[j];
              if(maxWei > weights[i]){
                weights[i] = maxWei;
              }
            }
          }
        }
        return weights[W];
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

