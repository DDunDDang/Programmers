import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        Set<Point> points = new HashSet<>();
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = getIntersection(line[i], line[j]);
                if (intersection != null) {
                    points.add(intersection);
                    minX = Math.min(minX, intersection.x);
                    minY = Math.min(minY, intersection.y);
                    maxX = Math.max(maxX, intersection.x);
                    maxY = Math.max(maxY, intersection.y);
                }
            }
        }

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        char[][] grid = new char[height][width];
        for (char[] row : grid) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x = (int) (p.x - minX);
            int y = (int) (maxY - p.y);
            grid[y][x] = '*';
        }

        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(grid[i]);
        }

        return answer;
    }

    private Point getIntersection(int[] line1, int[] line2) {
        long a = line1[0], b = line1[1], e = line1[2];
        long c = line2[0], d = line2[1], f = line2[2];
        long denominator = a * d - b * c;

        if (denominator == 0) return null;

        double x = (double) (b * f - e * d) / denominator;
        double y = (double) (e * c - a * f) / denominator;

        if (x % 1 == 0 && y % 1 == 0) {
            return new Point((long) x, (long) y);
        }

        return null;
    }

    private static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}