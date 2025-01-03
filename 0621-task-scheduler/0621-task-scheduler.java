class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();

        for(char ch : tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int maxFrq = 0;
        char maxFrqCh = '\u0000';
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            int frq = entry.getValue();
            if(frq>=maxFrq){
                maxFrq = frq;
                maxFrqCh = ch;
            }
        }

        int emptySpace = maxFrq-1;
        int slots = n*emptySpace;

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            int frq = entry.getValue();
            if(frq == maxFrq && ch != maxFrqCh){
                slots -= Math.min(frq,emptySpace);
            }else if(frq != maxFrq){
                slots -= Math.min(frq,emptySpace);
            }
        }
        if(slots > 0)
        return tasks.length + slots;

        return tasks.length;
        
    }
}