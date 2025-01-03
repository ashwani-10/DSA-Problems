class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] sch = new int[26];

        for(char ch : tasks){
            sch[ch-'A']++;
        }

        Arrays.sort(sch);
        int maxF = sch[25];
        int emptySpace = maxF-1;
        int slots = n*emptySpace;

        for(int i=24;i>=0;i--){
            slots -= Math.min(sch[i],emptySpace);
        }

        if(slots > 0)
        return tasks.length + slots;

        return tasks.length;
    }
}