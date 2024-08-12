class Solution {
    // there is always one land in a top-right corner where 2 sides (up and left) are water -> max ans is 2
    public int minDays(int[][] grid) {
        int lands = 0;
        for (int [] row : grid) lands += Arrays.stream(row).sum();
        if (!isConnected(grid, lands)) return 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    grid[i][j] = 0;
                    if (!isConnected(grid, lands - 1)) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    static final int[][] dirs = new int [][]{{1, 0} ,{-1, 0}, {0, 1}, {0, -1}};
    boolean isConnected(int[][] grid, int lands){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    Queue<Integer> q = new LinkedList();
                    q.add(31 * i + j);
                    Set<Integer> seen = new HashSet();
                    seen.add(31 * i + j);
                    while(!q.isEmpty()){
                        int size = q.size();
                        for (int k = 0; k < size; k++){
                            int cur = q.poll(), curI = cur / 31, curJ = cur % 31;
                            for (int [] dir: dirs){
                                int nextI = curI + dir[0], nextJ = curJ + dir[1], qIndex = nextI * 31 + nextJ;
                                if (nextI >= 0 && nextI < grid.length && nextJ >= 0 && nextJ < grid[0].length && grid[nextI][nextJ] == 1 && seen.add(qIndex)) q.add(qIndex);
                            }
                        }
                    }
                    return (seen.size() == lands);
                }
            }
        }
        return lands > 0;
    }
}