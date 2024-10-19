class Solution {
    public boolean allocationCheck(int[] books,int st, int maxPages){
        int pages = 0;

        for(int i=0;i<books.length;i++){
            if(pages + books[i] > maxPages){
                pages=books[i];
                st--;
                if(st==0)
                return false;
            }
            else
            pages += books[i];
        }
        return true;
    }
    public int splitArray(int[] A, int B) {
        int n = A.length;
        int l = 0;
        int r = 0;
        for(int pages : A){
            r += pages;
            l = Math.max(l,pages);
        }

        while(l<r){
            int mid = l+(r-l)/2;

            if(allocationCheck(A,B,mid)){
                r=mid;
            }
            
            else
            l = mid+1;
        }
        return B > n ? -1:l;
    }
}