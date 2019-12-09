import java.util.*;

public class DifferentSummands {
    private static TreeSet<Integer> optimalSummands(int n) {
        TreeSet<Integer> summands = new TreeSet<Integer>();
        int r = 1;
        int c = 0;
        while(true){
            c = n - r;
            if(c > r && !summands.contains(c)) {
                summands.add(r);
                n = c;
                r++;
            } else{
                summands.add(n);
                break;
            }
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeSet<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand);
            System.out.print(' ');
        }
    }
}

