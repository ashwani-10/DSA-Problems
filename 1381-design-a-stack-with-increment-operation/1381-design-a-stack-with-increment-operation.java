class CustomStack {
    ArrayList<Integer> arr = new ArrayList();
    ArrayList<Integer> inc = new ArrayList();
    int n;
    
    public CustomStack(int maxSize) {
        n = maxSize;
    }
    
    public void push(int x) {
        if(arr.size() < n){
            arr.add(x);
            inc.add(0);
        }
    }
    
    public int pop() {
        if(arr.size() == 0)
            return -1;
        
        int idx = arr.size()-1;
        
        if(idx > 0){
            inc.set(idx-1,inc.get(idx-1) + inc.get(idx));
        }
        
        int top_val = arr.get(idx) + inc.get(idx);
    
        arr.remove(arr.size()-1);
        inc.remove(inc.size()-1);
        
        return top_val;
    }
    
    public void increment(int k, int val) {
        int idx = Math.min(k,arr.size())-1;
        
        if(idx >=0){
            inc.set(idx,inc.get(idx)+val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */