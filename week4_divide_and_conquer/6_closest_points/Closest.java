import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public double distance(Point p){
            double ax = this.x*1.0 - p.x;
            double ay = this.y*1.0 - p.y;
            return Math.sqrt(ax*ax+ay*ay);
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    static double minimalDistance(List<Point> points) {
        double ans = Double.POSITIVE_INFINITY;
        if(points.size() == 2){
            return points.get(0).distance(points.get(1));
        } else if(points.size() == 1){
            return ans;
        }
        // write your code here
        // define middle point
        Point mid = points.get(points.size() / 2);
        // divide list into 2 halfs
        List<Point> half1 = points.subList(0, points.size() / 2);
        List<Point> half2 = points.subList(points.size() / 2, points.size());
        // get smallest distances from halfes
        double d1 = minimalDistance(half1);
        double d2 = minimalDistance(half2);
        // find minimal of d1 d2
        double d = Math.min(d1, d2);
        ans = d;
        // create strip
        List<Point> strip = new ArrayList<>();
        for (Point point : points) {
            if(point.x >= mid.x - d && point.x <= mid.x + d){
                strip.add(point);
            }
        }
        // sort strip by y
        Collections.sort(strip, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Long.compare(o1.y, o2.y);
            }
        });
        // find minimal in strip
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j <= i + 7 && j < strip.size(); j++) {
                double dist = strip.get(i).distance(strip.get(j));
                if(dist < ans){
                    ans = dist;
                }
            }
        }
        

        // for (Point point : half1) {
        //     System.out.println(point.x+"<<<>>>"+point.y);
        // }
        // System.out.println("\n");
        // for (Point point : half2) {
        //     System.out.println(point.x+"<<<>>>"+point.y);
        // }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            points.add(new Point(x,y));
        }
        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return Long.compare(o1.x, o2.x);
            }
        });
        System.out.println(minimalDistance(points));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}


/*
11
4 4
-2 -2
-3 -4
-1 3
2 3
-4 0
1 1
-1 -1
3 -1
-4 2
-2 4
*/