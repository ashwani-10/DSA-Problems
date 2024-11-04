class Solution {
    private void dfs(int[][] g, int i, int j, int m, int n) {
    if (i < 0 || i >= m || j < 0 || j >= n || g[i][j] == 0) {
      return;
    }
    g[i][j] = 0;

    dfs(g, i + 1, j, m, n);
    dfs(g, i - 1, j, m, n);
    dfs(g, i, j + 1, m, n);
    dfs(g, i, j - 1, m, n);
  }
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++) {
      dfs(grid, i, 0, m, n);
      dfs(grid, i, n - 1, m, n);
    }

    for (int i = 0; i < n; i++) {
      dfs(grid, 0, i, m, n);
      dfs(grid, m - 1, i, m, n);
    }

    int res = 0;
    for (int i = 1; i < m - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        if (grid[i][j] == 1) res++;
      }
    }
    return res;
    }
}