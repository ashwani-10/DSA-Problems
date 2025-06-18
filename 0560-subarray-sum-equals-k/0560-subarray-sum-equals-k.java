/* One way to Solve this problem is just find all subarrays and
check if the sum iss eqaulas with the target.
Start with every index (i) as the beginning of a subarray.
Keep adding the next elements (j) one by one.
If the sum of the current subarray matches the target, we can increase the counter by +1.
move to the next starting index (i + 1) and do the same.
In the end we can have the count of subarray that sums to target.
Time Complexity here is O(N^2) as we iterating over the array twice
Space Complexity here is O(1) we just created ans,sum variables which is constant space.
*/

class Solution {
    public int subarraySum(int[] arr, int tar) {
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            int sum = 0;
            for(int j = i; j < arr.length; j++) {
                sum += arr[j];
                if(sum == tar) ans++;
            }
        }
        return ans;
    }

/*
Above Solution works but is too slow because it checks every possible subarray,
 making the time complexity O(N²) which will fail for larger inputs.

 So,Here we can solve this problem in O(N) only using prefix sum methodology instead of
 calculating sum of every sub array again and again, And we will also use Map here to keep on
 Storing the current subarrsy sum so that if at cuurent (i) position
            pSum = pSum + arr[i];
 Here, if map.containsKey(pSum - target) == true, which means there must be an subaraay
 somewhere between (0,i) in arr whose sum is == target, so here we can increase the counter 
 by +map.get((pSum-target)) and will store the current (pSum) with its map(pSum,map.get(pSum,0)+1).
 So, this we can solve this in -
 Time complexity - O(N) bcoz we traversing the whole array only once
 Spance complexity - O(N) Using map 
 */

// class Solution {
//     public int subarraySum(int[] arr, int tar) {
//         HashMap<Integer,Integer>hm = new HashMap<>();
//         int sum = 0;
//         int ans = 0;
//         hm.put(0,1);
//         for(int i=0;i<arr.length;i++){
//             sum = sum + arr[i];
//             System.out.println(sum+" ");
//             if(hm.containsKey(sum-tar)){
//                 ans = ans + hm.get(sum-tar);
//             }
//             hm.put(sum,hm.getOrDefault(sum,0)+1);
//             System.out.println(ans);
//             System.out.println(hm);
//             System.out.println();
//         }
//         return ans;
//     }
}
