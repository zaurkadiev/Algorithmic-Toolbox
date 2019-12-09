import java.util.*;

import javax.swing.text.Segment;

public class CoveringSegments {

    private static int[] optimalPoints(List<Segment> segments) {
        //write your code here

        segments.sort(new Comparator<Segment>() {
            @Override
            public int compare(Segment o1, Segment o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });

        List<Integer> points = new ArrayList<>();

        while(!segments.isEmpty()) {
            int minRight = segments.get(0).end;
            points.add(minRight);
            int i = 0;
            while(i < segments.size()){
                if(segments.get(i).start <= minRight && segments.get(i).end >= minRight){
                    segments.remove(i);
                } else{
                    i++;
                }
            }
        }

        int[] p = new int[points.size()];
        for (int i = 0; i < p.length; i++) {
            p[i] = points.get(i);
        }
  
        return p;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List segments  = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments.add(new Segment(start, end));
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
