

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min-Heap
        
        // Insert first k elements
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) { // Maintain heap size of k
                minHeap.poll(); // Remove smallest element
            }
        }
        return minHeap.peek(); // k-th largest element
    }
}
