import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        int n = values.length;
        double[][] ratios = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            ratios[i][0] = ((double) values[i]) / weights[i];
            ratios[i][1] = (double) i;
        }

        Arrays.sort(ratios, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o1[0], o2[0]);
            }
        });

        // System.out.println(ratios[0][0]);
        // System.out.println(ratios[1][0]);
        // System.out.println(ratios[2][0]);
        // return 0;

        for (int j = n - 1; j >= 0; j--) {

            if(capacity == 0){
                return value;
            }

            int i = (int) ratios[j][1];
            double ratio = ratios[j][0];

            double toFill = Math.min(weights[i], capacity);

            value += toFill * values[i]*1.0/weights[i];
            capacity -= toFill;
        }

        return value;
    }

/*
3 50
60 20
100 50
120 30
*/


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }

}
