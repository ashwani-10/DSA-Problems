class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        res.add(prev);
        if(rowIndex==0) return res.get(0);

        for(int i=2;i<=rowIndex+1;i++){
            List<Integer> curr = new ArrayList<>();
            curr.add(1);

            for(int j=1;j<i-1;j++){
                curr.add(prev.get(j-1)+prev.get(j));
            }
            curr.add(1);
            res.add(curr);
            prev = curr;
        }
        return res.get(rowIndex);
    }
}