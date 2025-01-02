

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();

         for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
         }

        List<Integer> list = new ArrayList<>(map.values());

        Collections.sort(list);
        
        int i=0;
        while(k>0 && i<list.size()){

            if(list.get(i) <= k){
                k -= list.get(i);
                i++;
            }else{
                break;
            }
        }
        return list.size()-i;
    }
}