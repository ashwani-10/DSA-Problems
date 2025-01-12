class Solution {

    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean helper(char board[][],String word,boolean[][] vis, int i,int j,int idx){
        if(idx == word.length()){
            return true;
        }
       
        if(i<0 || i>= board.length || j<0 || j>=board[0].length || word.charAt(idx) != board[i][j] || vis[i][j]){
            return false;
        }

        vis[i][j] = true;

        for(int[] dr : dir){
            if(helper(board,word,vis,i+dr[0],j+dr[1],idx+1)){
                return true;
            }
        }

        vis[i][j] = false;


        return false;

    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                    if(board[i][j] == word.charAt(0) && helper(board,word,vis,i,j,0)){
                        return true;
                }
            }
        }
        return false;
    }
}