/*                  OPTIMAL SOLUTION O(n)
1.Create a HashMap to store each number and its most recent index.
2.Traverse the array using index i.
3.Check whether the current number already exists in the map.
4.If it exists, calculate the distance between the current index and its previous index.
5.If the distance is less than or equal to k, return true. Otherwise, update the number's index in the map to the current index.
6.If the loop finishes without finding a valid pair, return false. */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        HashMap<Integer, Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++) 
        {
            if (map.containsKey(nums[i]) && i-map.get(nums[i])<= k)
                return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
