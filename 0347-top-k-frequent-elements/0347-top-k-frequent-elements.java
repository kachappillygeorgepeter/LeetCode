/*class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i] , 0)+1);
            //map.putIfAbsent(nums[i], 0);
            //map.put(nums[i], map.get(nums[i]) + 1);
        int maxKey1=0, maxKey2=0, maxCount1=Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if(maxCount1<entry.getValue()) {
                maxKey2=maxKey1;
                maxKey1=entry.getKey();
                maxCount1=entry.getValue();
            }
        }
        return new int[]{maxKey1, maxKey2};
    }
}*/
/*
1.Count the frequency of each number using a HashMap.
2.Create buckets where each index represents a frequency and store numbers in the bucket matching their frequency.
3.Create a result array of size k to store the top k frequent numbers.
4.Traverse the buckets from highest frequency to lowest, adding numbers to the result array until it contains k elements. */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            //map.putIfAbsent(nums[i], 0);
            //map.put(nums[i], map.get(nums[i]) + 1);

        List<Integer> buckets[]=new List[nums.length+1];
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            int count=entry.getValue();
            if (buckets[count]==null)
                buckets[count]=new ArrayList<>();
            buckets[count].add(entry.getKey());
        }

        int result[]=new int[k];
        int index=0;
        for (int i=buckets.length-1; i>=0 && index<k; i--) {
            if (buckets[i]!=null) {
                for (int num:buckets[i]) {
                    result[index++]=num;
                    if (index==k)
                        break;
                }
            }
        }
        return result;
    }
}