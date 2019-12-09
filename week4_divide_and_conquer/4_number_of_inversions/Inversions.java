import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, left, ave);
        numberOfInversions += getNumberOfInversions(a, ave, right);
        //write your code here

        // create and init B
        int[] b = new int[ave - left];
        for (int i = left; i < ave; i++) {
            b[i-left] = a[i];
        }
        // create and init C
        int[] c = new int[right - ave];
        for (int i = ave; i < right; i++) {
            c[i-ave] = a[i];
        }

        // define working interaval
        for (int i = 0, j = 0; i < right - left && j < right - left;) {
            
            // i is bigger
            if(i == b.length){
                for (int j2 = j; j2 < c.length; j2++) {
                    a[left+i+j2] = c[j2];
                }
                break;
            }

            // j is bigger
            if(j == c.length){
                for (int j2 = i; j2 < b.length; j2++) {
                    a[left+j+j2] = b[j2];
                }
                break;
            }
            
            
            
            if(b[i] <= c[j]){
                a[left+i+j] = b[i];
                i++;
            } else{
                numberOfInversions += ave - i - left;
                a[left+i+j] = c[j];
                j++;
            }
        }





        // for (int i = left; i < ave; i++) {
        //     System.out.print(a[i]+" ");
        // }
        // System.out.print("     ");
        // for (int i = ave; i < right; i++) {
        //     System.out.print(a[i]+" ");
        // }
        // System.out.println("     ");






        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getNumberOfInversions(a, 0, a.length));
    }
}

