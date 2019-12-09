import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {

        String d = "";
        String op = "";

        for (int i = 0; i < exp.length(); i++) {
            if(i % 2 == 0){
                d += exp.charAt(i)+"";
            } else{
                op += exp.charAt(i)+"";
            }
        }

        //write your code here
        int n = d.length();
        long[][] m = new long[n][n];
        long[][] M = new long[n][n];

        for (int i = 0; i < M.length; i++) {
            m[i][i] = Integer.parseInt(d.charAt(i)+"");
            M[i][i] = Integer.parseInt(d.charAt(i)+"");
        }

        for (int s = 1; s < n; s++) {
            for (int i = 0; i < n - s; i++) {
                int j = i + s;
                long[] minMax = MinAndMax(i, j, op, m, M);
                m[i][j] = minMax[0];
                M[i][j] = minMax[1];
            }
        }

        // print Table
        // printTable(Ms

        return M[0][n-1];
    }

    private static void printTable(long[][] t){
        System.out.println("========================");
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                System.out.print(t[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private static long[] MinAndMax(int i, int j, String op, long[][] m, long[][] M){
        long[]minMax = {0,0};
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int k = i; k < j; k++) {
            long a = eval(M[i][k], M[k+1][j], op.charAt(k));
            long b = eval(M[i][k], m[k+1][j], op.charAt(k));
            long c = eval(m[i][k], M[k+1][j], op.charAt(k));
            long d = eval(m[i][k], m[k+1][j], op.charAt(k));

            min = Math.min(min, a);
            min = Math.min(min, b);
            min = Math.min(min, c);
            min = Math.min(min, d);

            max = Math.max(max, a);
            max = Math.max(max, b);
            max = Math.max(max, c);
            max = Math.max(max, d);
        }

        minMax[0] = min;
        minMax[1] = max;

        return minMax;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

