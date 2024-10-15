class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i=0,j=n-1;
        int mArea = Integer.MIN_VALUE;

        while(i<j){
            int widht = j-i;
            int height = Math.min(heights[i],heights[j]);

            int area = widht*height;
            mArea = Math.max(mArea,area);

            if(heights[i] < heights[j])
            i++;

            else
            j--;


        }

        return mArea;
    }
}