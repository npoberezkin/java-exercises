package exercises.other;

import java.util.HashSet;
import java.util.Objects;

public class VerticalSymmetryAxisForDots {

    private static boolean symetryAxis(Point[] points) {
        HashSet<Point> pointSet = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Point point : points) {
            if (point.x < min) min = point.x;
            if (point.x > max) max = point.x;
            pointSet.add(point);
        }
        int axe = min + max;
        for (Point point : points) {
            if (!pointSet.contains(new Point(axe - point.x, point.y))) {
                return false;
            }
        }
        return true;
    }

    // array of coordinates (x,y), int numbers
    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(2, 2),
                new Point(4, 2),
                new Point(1, 4),
                new Point(5, 4),
                new Point(4, 6),
                new Point(2, 6)};
        System.out.println(symetryAxis(points));
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
