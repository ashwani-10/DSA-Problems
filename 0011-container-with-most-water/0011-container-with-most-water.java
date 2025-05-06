class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int i=0;
        int j=n-1;
        int maxArea = Integer.MIN_VALUE;
        System.out.println(n);
        System.out.println(j);

        while(i<j){
            int width = j-i;
            System.out.println(width);
            int height = Math.min(heights[i],heights[j]);

            int area = height*width;
            maxArea = Math.max(maxArea,area);

            if(heights[i] < heights[j]){
                i++;
            }

            else{
                j--;
            }
        }

        return maxArea;
    }
}