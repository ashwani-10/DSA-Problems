class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        res.add(prev);
        if(n==1) return res;

        for(int i=2;i<=n;i++){
            List<Integer> curr = new ArrayList<>();
            curr.add(1);

            for(int j=1;j<i-1;j++){
                curr.add(prev.get(j-1)+prev.get(j));
            }
            curr.add(1);
            res.add(curr);
            prev = curr;
        }
        return res;
    }
}