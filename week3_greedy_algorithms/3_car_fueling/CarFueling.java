import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numRefills = 0;
        int lastRefill = 0;
        int currentRefill = 0;
        int n = stops.length;

        while(currentRefill < n - 1){

            while(currentRefill < n - 1 && stops[currentRefill + 1] - stops[lastRefill] <= tank){
                currentRefill +=  1;
            }

            if(currentRefill == lastRefill){
                return -1;
            }

            if(currentRefill < n - 1){
                numRefills++;
            }

            lastRefill = currentRefill;
        }
        
        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            stops[i] = scanner.nextInt();
        }
        stops[0] = 0;
        stops[n+1] = dist;
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
