class comp implements Comparator<Integer> {
    public int compare(Integer a , Integer b) {
        if(a > b)
            return 1;
        if(a < b)
            return -1;
        return 0;
    }
}
class KthLargest {
    int K;
    PriorityQueue <Integer> pq;
    public KthLargest(int k, int[] nums) {
        K = k;
        pq = new PriorityQueue <Integer> (new comp());
        for(int x : nums) {
            pq.add(x);
            if(pq.size() > k) {
                pq.remove();
            }
        }
    }
    int add(int val) {
        pq.add(val);
        if(pq.size() > K)
            pq.remove();
        return pq.peek();
    }
}
class KthLargestInStream {
    public static void main(String args[]) {
        int k = 3;
        int[] nums = {4 , 5 , 8 , 2};
        KthLargest stream = new KthLargest(k , nums);
        System.out.print(stream.add(3) + " ");
        System.out.print(stream.add(5) + " ");
        System.out.print(stream.add(10) + " ");
        System.out.print(stream.add(9) + " ");
        System.out.print(stream.add(4) + " ");
        System.out.println();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */