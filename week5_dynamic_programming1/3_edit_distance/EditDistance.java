import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
    int n = s.length();
    int m = t.length();
    int[][] D = new int[n+1][m+1];

    for (int i = 0; i <= n; i++) {
      D[i][0] = i;
    }
    for (int i = 0; i <= m; i++) {
      D[0][i] = i;
    }


    for (int j = 1; j <= m; j++) {
      for (int i = 1; i <= n; i++) {
        int insertion = D[i][j-1] + 1;
        int deletion = D[i-1][j] + 1;
        int match = D[i-1][j-1];
        int mismatch = D[i-1][j-1] + 1;

        if(s.charAt(i-1) == t.charAt(j-1)){
          D[i][j] = Math.min(insertion, deletion);
          D[i][j] = Math.min(D[i][j], match);
        } else{
          D[i][j] = Math.min(insertion, deletion);
          D[i][j] = Math.min(D[i][j], mismatch);
        }
      }
    }


    return D[n][m];
  }

  // private static int outputAligment(int[][] D, int i, int j){
  //   int res = 0;
  //   if(i==0 && j==0)
  //     return res;

  //   if(i > 0 && D[i][j] == D[i-1][j] + 1){
  //     res += outputAligment(D, i-1, j);
  //   } else if(j>0 && D[i][j] == D[i][j-1] + 1){
  //     res += outputAligment(D, i, j-1);
  //   } else{
  //     res += outputAligment(D, i-1, j-1);
  //   }


  //   return res;
  // }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
