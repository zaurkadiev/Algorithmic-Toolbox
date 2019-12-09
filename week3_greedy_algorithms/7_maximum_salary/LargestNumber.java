import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {

        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                
                Integer i1 = Integer.parseInt(o1+o2);
                Integer i2 = Integer.parseInt(o2+o1);

                
                return -Integer.compare(i1, i2);
            }
        });

        //write your code here
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            stringBuilder.append(a[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

