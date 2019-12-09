import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] coins = {1,3,4};
        //write your code here
        int[] minNumOfCoins = new int[m + 1];

        minNumOfCoins[0] = 0;
        for (int i = 1; i <= m; i++) {
            minNumOfCoins[i] = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++) {
                if(i >= coins[j]){
                    int numCoins = minNumOfCoins[i - coins[j]] + 1;
                    if(minNumOfCoins[i] > numCoins){
                        minNumOfCoins[i] = numCoins;
                    }
                }
            }
        }

        return minNumOfCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

