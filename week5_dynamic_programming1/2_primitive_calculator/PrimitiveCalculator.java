import java.util.*;
public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {

        List<Integer> sequence = new ArrayList();
        int[] numOfOperations = new int[n + 1];

        numOfOperations[0] = 0;
        numOfOperations[1] = 0;

        StringBuilder builder = new StringBuilder();
        for (int i = 2; i <= n; i++) {

            numOfOperations[i] = Integer.MAX_VALUE;
            int minOper = Integer.MAX_VALUE;
            int type = -1;

            if(i % 3 == 0){
                minOper = numOfOperations[i / 3] + 1;
                if(numOfOperations[i] > minOper){
                    numOfOperations[i] = minOper;
                    type = 0;
                }
            }

            if(i % 2 == 0){
                minOper = numOfOperations[i / 2] + 1;
                if(numOfOperations[i] > minOper){
                    numOfOperations[i] = minOper;
                    type = 1;
                }
            }

            minOper = numOfOperations[i - 1] + 1;
            if(numOfOperations[i] > minOper){
                numOfOperations[i] = minOper;
                type = 2;
            }
        }


        sequence.add(n);
        while(n > 1){
            int type = -1;
            int num = Integer.MAX_VALUE;
            
            if(n % 3 == 0){
                if(numOfOperations[n / 3] < num){
                    num = numOfOperations[n / 3];
                    type = 0;
                }
            }

            if(n % 2 == 0){
                if(numOfOperations[n / 2] < num){
                    num = numOfOperations[n / 2];
                    type = 1;
                }
            }

            if(numOfOperations[n - 1] < num){
                num = numOfOperations[n - 1];
                type = 2;
            }


            if(type == 0){
                n /= 3;
            } else if(type == 1){
                n /= 2;
            } else{
                n -= 1;
            }
            sequence.add(n);            
        }

        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

