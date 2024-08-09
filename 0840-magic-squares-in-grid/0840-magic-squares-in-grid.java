class Solution {
     public int numMagicSquaresInside(int[][] grid) {
    
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Magic Squares In Grid.
    Memory Usage: 37 MB, less than 89.81% of Java online submissions for Magic Squares In Grid.
    */

    int numberOfMagicSquares = 0; // what we'll return
    
    for (int rowOffset = 0; rowOffset <= grid.length - 3; ++rowOffset) {
      for (int colOffset = 0; colOffset <= grid[0].length - 3; ++colOffset) {
        if (isMagicSquare(grid, rowOffset, colOffset)) {
          ++numberOfMagicSquares;
        }
      }
    }
    
    return numberOfMagicSquares;
  }
  
  private boolean isMagicSquare(int[][] grid, int offsetRow, int offsetCol) {

    // check for 1st condition: digits 1 through 9
    // note quick technique using XOR!
    int waxTablet = 0;
    for (int i = 1; i <= 9; ++i) {
      waxTablet ^= i;
    }
    
    for (int i = 0; i <= 2; ++i) {
      for (int j = 0; j <= 2; ++j) {
        waxTablet ^= grid[offsetRow + i][offsetCol + j];
      }
    }
    
    if (waxTablet != 0) {
      return false;
    }
    
    // check for 2nd condition: same sums in all directions
    
    // get NW-SE diagonal to get a baseline for subsequent checks
    int masterSum = 0;
    for (int k = 0; k <= 2; ++k) {
      masterSum += grid[offsetRow + k][offsetCol + k];
    }
    
    // get SW-NE diagonal
    int sum = 0;
    for (int k = 0; k <= 2; ++k) {
      sum += grid[offsetRow + (2 - k)][offsetCol + k];
    }
    
    if (sum != masterSum) {
      return false;
    }
    
    // get rows
    for (int y = 0; y <= 2; ++y) {
      sum = 0;
      for (int x = 0; x <= 2; ++x) {
        sum += grid[offsetRow + y][offsetCol + x];
      }
      
      if (sum != masterSum) {
        return false;
      }
    }
    
    // get columns
    for (int x = 0; x <= 2; ++x) {
      sum = 0;
      for (int y = 0; y <= 2; ++y) {
        sum += grid[offsetRow + y][offsetCol + x];
      }
      if (sum != masterSum) {
        return false;
      }
    }
    
    return true;// if we haven't returned false yet, return true!
  }
}