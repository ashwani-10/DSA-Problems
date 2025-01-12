class Solution {

    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean helper(char board[][],String word,int i,int j,int idx){
        if(i<0 || i>= board.length || j<0 || j>=board[0].length || word.charAt(idx) != board[i][j] || board[i][j] == '#'){
            return false;
        }
        
        if(idx == word.length()-1){
            return true;
        }

        char cur_char = board[i][j];
        board[i][j] = '#';

        for(int[] dr : dir){
            if(helper(board,word,i+dr[0],j+dr[1],idx+1)){
                return true;
            }
        }

        board[i][j] = cur_char;

        return false;

    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                    if(board[i][j] == word.charAt(0) && helper(board,word,i,j,0)){
                        return true;
                }
            }
        }
        return false;
    }
}