class Solution {
    
    int[] d = {-1, 0, 1, 0, -1};
    
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
		Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        grid[0][0] = -1; // [0, 0]  was visited
        int step = 0;
        while (!q.isEmpty()) {
			Queue<int[]> q2 = new LinkedList<>(); // q2 will store obstacle cells can be reached from q
            while (!q.isEmpty()) {
                int[] node = q.poll();
                if (node[0] == m - 1 && node[1] == n - 1) {
                    return step;
                }
                for (int k = 0; k < 4; ++k) {
                    int x = node[0] + d[k];
                    int y = node[1] + d[k+1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != -1) {
                        if (grid[x][y] == 0) {
                            q.add(new int[]{x, y});
                        } else { // grid[x][y] == 1 (obstacle)
                            q2.add(new int[]{x, y});
                        }
                        grid[x][y] = -1; // [x, y]  was visited
                    }
                }
            }
            q = q2;
            step++;
        }
        return -1;
    }
}