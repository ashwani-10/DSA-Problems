class Solution {
    public void dfs(char [][] board,int i,int j,int vis[][]){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || vis[i][j] == 1 || board[i][j] != 'O') return;
        
        board[i][j] = 'F';
        vis[i][j] = 1;
        
        dfs(board,i+1,j,vis);
        dfs(board,i-1,j,vis);
        dfs(board,i,j+1,vis);
        dfs(board,i,j-1,vis);
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];
        
        for(int j=0;j<m;j++){
            if(board[0][j] == 'O'){
                dfs(board,0,j,vis);
            }
            if(board[n-1][j] == 'O'){
                dfs(board,n-1,j,vis);
            }
        }
        
        for(int i=0;i<n;i++){
            if(board[i][0] == 'O'){
                dfs(board,i,0,vis);
            }
            if(board[i][m-1] == 'O'){
                dfs(board,i,m-1,vis);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'F')
                    board[i][j] = 'O';
            }
        }
        
    }
}