package rish.learn.graphs.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 
 * Problem link: https://leetcode.com/discuss/interview-question/763001/count-number-of-freshwater-lakes-in-2d-matrix
 * 
 * Given a 01 matrix, return area of freshwater lakes sorted by size.
 * Here 0 indicates water and its value can be either saltwater or freshwater and 1 is land.
 * The input matrix is implicitly surrounded by an infinite ocean .
 * 
 */
public class AreaOfFreshwaterLakes {

    class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final int[][] NBRS = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public int[] findLakes(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0 && !visited[i][0]) {
                findArea(i, 0, grid, visited);
            }
            if (grid[i][n - 1] == 0 && !visited[i][n - 1]) {
                findArea(i, n - 1, grid, visited);
            }
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0 && !visited[0][j]) {
                findArea(0, j, grid, visited);
            }
            if (grid[m - 1][j] == 0 && !visited[m - 1][j]) {
                findArea(m - 1, j, grid, visited);
            }
        }

        // Now find freshwater lakes
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    int area = findArea(i, j, grid, visited);
                    ans.add(area);
                }
            }
        }

        return ans.stream().mapToInt(i -> i).sorted().toArray();
    }

    private int findArea(int i, int j, int[][] grid, boolean[][] visited) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(i, j));
        visited[i][j] = true;

        int area = 0;

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();
            int ni = curr.x;
            int nj = curr.y;

            area++;

            for (int[] side : generateNeighbours(ni, nj)) {

                int p = side[0];
                int q = side[1];

                if (isInvalid(p, q, m, n) || grid[p][q] == 1 || visited[p][q]) {
                    continue;
                }

                visited[p][q] = true;
                queue.add(new Pair(p, q));
            }
        }

        return area;
    }

    private int[][] generateNeighbours(int x, int y) {
        int[][] answ = new int[4][2];
        int i = 0;
        for (int[] direction : NBRS) {
            int row = x + direction[0];
            int col = y + direction[1];
            answ[i++] = new int[] { row, col };
        }
        return answ;
    }

    private boolean isInvalid(int x, int y, int rows, int cols) {
        return x < 0 || x >= rows || y < 0 || y >= cols;
    }

    public static void main(String[] args) {

        int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 0 ... 0
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, // 0 ... 0
                { 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

        AreaOfFreshwaterLakes solution = new AreaOfFreshwaterLakes();

        System.out.println(Arrays.toString(solution.findLakes(grid)));
    }

}
