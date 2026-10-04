package com.rajamohan.problem;

import java.util.LinkedList;
import java.util.Queue;

public class IslandProblem {
      static int numIsIslands(int[][] grid){
          if(grid == null || grid.length == 0){
              return 0;
          }
          int rows = grid.length;
          int columns = grid[0].length;
          boolean[][] visited = new boolean[rows][columns];
          int islandCounts = 0;

          for(int i=0; i < rows; i++){
              for(int j=0; j < columns; j++){
                  if(grid[i][j] == 1 && !visited[i][j]){
                      islandCounts++;
                      //dfs(grid, visited, i, j);
                      bfs(grid, visited, i, j);
                  }
              }
          }
          return islandCounts;
      }

      /*         r0:   1  1  0  0  0
                 r1:   1  1  0  0  0
                 r2:   0  0  1  0  0
                 r3:   0  0  0  1  1      */

      static void dfs(int[][] grid, boolean[][] visited, int r, int c){
          int row = grid.length; int col = grid[0].length;

          if(r < 0 || r >= row  || c < 0 || c >= col) {
              return;
          }
          if(grid[r][c] == 0 || visited[r][c]){
              return;
          }

          visited[r][c] = true;

          dfs(grid, visited, r+1, c); // down
          dfs(grid, visited, r-1, c); // Up
          dfs(grid, visited, r, c+1); // right
          dfs(grid, visited, r,c-1);  // left
      }

      /*
         Think of it like ripples in a pond Drop a stone in water — first the point of impact gets wet,
         then a ring around it, then a wider ring, and so on. BFS works the same way: start at one cell,
         then visit all its direct neighbors, then all of their unvisited neighbors, spreading outward one "ring" at a time.
         A queue is just a waiting line that keeps track of "who's next to spread from."
       */
      static void bfs(int[][] grid, boolean[][] visited, int startR, int startC){
          // A queue is just a waiting line: first one added is the first one processed
          Queue<int[]> queue = new LinkedList<>();
          // Step 1: put the starting cell in the queue, and mark it visited right away
          queue.add(new int[]{startR, startC});
          visited[startR][startC] = true;

          int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

          // Step 2: keep going as long as there's something waiting in the queue
          while (!queue.isEmpty()) {
              int[] cell = queue.poll();
              int r = cell[0], c = cell[1];

              for (int[] dir : directions) {
                  int newR = r + dir[0];
                  int newC = c + dir[1];
                  if (isValidLandCell(grid, visited, newR, newC )) {
                      visited[newR][newC] = true;
                      queue.add(new int[]{newR, newC});
                  }
              }
          }
      }

    // A helper method just to keep the "is this a safe cell to visit" logic in one place
    static boolean isValidLandCell(int[][] grid, boolean[][] visited, int row, int col) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;

        if (row < 0 || row >= totalRows) return false;   // row is out of bounds
        if (col < 0 || col >= totalCols) return false;   // col is out of bounds
        if (grid[row][col] == 0) return false;           // it's water, not land
        if (visited[row][col]) return false;             // already visited before

        return true; // it's a valid, unvisited land cell
    }

      public static  void main(String args[]){
          int[][] grid = {
                  {1, 1, 0, 0, 0},
                  {1, 1, 0, 0, 1},
                  {0, 0, 1, 0, 0},
                  {0, 0, 0, 1, 1}
          };

          System.out.println("Number of islands: " + numIsIslands(grid));
      }

}
