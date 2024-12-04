class Solution {
    public void dfs(char [][] board,int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != 'O') return;
        
        board[i][j] = 'F';
        
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        for(int j=0;j<m;j++){
            if(board[0][j] == 'O'){
                dfs(board,0,j);
            }
            if(board[n-1][j] == 'O'){
                dfs(board,n-1,j);
            }
        }
        
        for(int i=0;i<n;i++){
            if(board[i][0] == 'O'){
                dfs(board,i,0);
            }
            if(board[i][m-1] == 'O'){
                dfs(board,i,m-1);
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
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}