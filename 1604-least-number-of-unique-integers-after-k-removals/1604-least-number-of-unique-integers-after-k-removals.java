

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();

         for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
         }

        List<Pair<Integer,Integer>> list = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(new Pair<>(entry.getKey(),entry.getValue()));
        }

        list.sort(Comparator.comparing(Pair::getValue));

        int i=0;
        while(k>0 && i<list.size()){
            Pair<Integer,Integer> pair = list.get(i);
            int freq = pair.getValue();

            if(freq <= k){
                k -= freq;
                list.remove(i);
            }else{
                break;
            }
        }
        return list.size();
    }
}