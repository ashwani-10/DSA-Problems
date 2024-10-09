class Solution {
    public int[] maxSlidingWindow(int[] arr, int K) {
        int N = arr.length;
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<N;i++) {
            int startIndexOfWindow = i-K+1;
            if(dq.size() > 0 && dq.getLast() < startIndexOfWindow) {
                dq.removeLast();
            }
            while(dq.size() > 0 && arr[dq.getFirst()] < arr[i]) {
                dq.removeFirst();
            }
            dq.addFirst(i);
            if(i>=K-1) {
                ans.add(arr[dq.getLast()]);
            }
        }

        int a[] = new int[ans.size()];
        for(int i=0;i<ans.size();i++) {
            a[i] = ans.get(i);
        }
        return a;
    }
}
