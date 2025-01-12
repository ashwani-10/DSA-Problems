class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        
        return helper(coins,amount,memo);
    }

    public int helper(int[] coins,int amount,int[] memo){
        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return -1;
        }

        if(memo[amount] != 0){
            return memo[amount];
        }

        int minCoins = Integer.MAX_VALUE;

        for(int coin : coins){
            int res = helper(coins,amount-coin,memo);
            if(res >= 0 && res < minCoins){
                minCoins = res + 1;
            }
        }

        memo[amount] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;

        return memo[amount];
    }
}