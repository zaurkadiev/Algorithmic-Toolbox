import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        //write your code here

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0; i < points.length; i++) {
            int a = binarySearch1(starts, 0, starts.length - 1, points[i]);
            int b = binarySearch2(ends, 0, ends.length -1, points[i]);

            cnt[i] = a - b;
        }

        return cnt;
    }

/*
    
2 1
6 12
8 10
6
<< 1
    
3 1
2 2
2 2
2 2
3
<< 0

3 1
2 2
2 2
2 2
2
<< 3

6 1
2 2
2 2
0 2
0 2
-2 -1
-2 -1
0
<< 2

2 3
0 5
7 10
1 6 11
<<1 0 0

1 3
-10 10
-100 100 0
<<0 0 1

3 2
0 5
-3 2
7 10
1 6
<<2 0
*/

    private static int binarySearch1(int[] arr, int left, int right, int key){
        int m = left + (right - left) / 2;

        if(left > right){
            return left;
        }

        if(arr[m] == key){
            while(m + 1 < arr.length && arr[m + 1] == key){
                m++;
            }
            return m+1;
        } else if(arr[m] > key){
            return binarySearch1(arr, left, m - 1, key);
        } else{
            return binarySearch1(arr, m + 1, right, key);
        }
    }

    private static int binarySearch2(int[] arr, int left, int right, int key){
        int m = left + (right - left) / 2;

        if(left > right){
            return left;
        }

        if(arr[m] == key){
            while(m - 1 >= 0 && arr[m - 1] == key){
                m--;
            }
            return m;
        } else if(arr[m] > key){
            return binarySearch2(arr, left, m - 1, key);
        } else{
            return binarySearch2(arr, m + 1, right, key);
        }
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

