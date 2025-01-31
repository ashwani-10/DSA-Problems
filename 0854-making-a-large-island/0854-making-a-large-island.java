class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int dfs(int[][] grid,int i,int j,int id){
        if(i<0 || i>=grid.length || j<0 || j>=grid.length || grid[i][j] != 1)
        return 0;

        grid[i][j] = id;
        int size = 1;

        for(int[] d : dir){
            int ni = i +d[0];
            int nj = j +d[1];

            size += dfs(grid,ni,nj,id);
        }

        return size;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        
        
        int maxArea = 0;
        int id = 2;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                int area = dfs(grid,i,j,id);
                maxArea = Math.max(maxArea,area);
                map.put(id,area);
                id++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    Set<Integer> set = new HashSet<>();
                    for(int[]d : dir){
                        int ni = i+d[0];
                        int nj = j+d[1];
                        if(ni>=0 && ni<n && nj>=0 && nj<n && grid[ni][nj] != 0){
                            set.add(grid[ni][nj]);

                        }
                    }
                    int size = 1;
                    for(int num : set){
                        size += map.get(num);
                    }

                    maxArea = Math.max(maxArea,size);
                }
            }
        }

        return maxArea;
    }
}