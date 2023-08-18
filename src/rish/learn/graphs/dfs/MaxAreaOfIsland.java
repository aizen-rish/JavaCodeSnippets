package rish.learn.graphs.dfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * Problem #: LC695
 * Problem link: https://leetcode.com/problems/max-area-of-island/
 * 
 */
public class MaxAreaOfIsland {

    private static final int[][] NBRS = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, findArea(i, j, grid, visited));
                }
            }
        }

        return maxArea;
    }

    private static int findArea(int i, int j, int[][] grid, boolean[][] visited) {

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

                if (isInvalid(p, q, m, n) || grid[p][q] == 0 || visited[p][q]) {
                    continue;
                }

                visited[p][q] = true;
                queue.add(new Pair(p, q));
            }
        }

        return area;
    }

    private static int[][] generateNeighbours(int x, int y) {
        int[][] answ = new int[4][2];
        int i = 0;
        for (int[] direction : NBRS) {
            int row = x + direction[0];
            int col = y + direction[1];
            answ[i++] = new int[] { row, col };
        }
        return answ;
    }

    private static boolean isInvalid(int x, int y, int rows, int cols) {
        return x < 0 || x >= rows || y < 0 || y >= cols;
    }

    public static void main(String[] args) {

        int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

        System.out.println(maxAreaOfIsland(grid));
    }

}

class Pair {

    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
