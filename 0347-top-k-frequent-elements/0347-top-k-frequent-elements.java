class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a min heap (PriorityQueue) based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()  // Min-heap based on frequency
        );

        // Step 3: Add elements to the heap, and maintain the top K frequent elements
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the least frequent element
            }
        }

        int[] res = new int[k];

        for(int i=0;i<k;i++){
            res[i] = minHeap.poll().getKey();
        }

        return res;
    }
}
