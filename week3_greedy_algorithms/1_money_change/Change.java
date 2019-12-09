import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int c = 0;
        
        while(true){

            if(m <= 0){
                return c;
            }

            int d = 1;
            if(m / 10 > 0){
                d = 10;
            } else if(m / 5 > 0){
                d = 5;
            }
            
            m -= d;
            c++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

