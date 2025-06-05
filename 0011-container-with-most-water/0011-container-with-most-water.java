class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int area = 0;
        int i=0,j=n-1;

        while(i<j){
            int breadth = Math.min(height[i],height[j]);
            int curArea = breadth * (j-i);
            area = Math.max(area,curArea);

            if(height[i] < height[j]) i++;
            else if(height[j] < height[i]) j--;
            else{
                i++;
                j--;
            }
        }
        return area;
    }
}