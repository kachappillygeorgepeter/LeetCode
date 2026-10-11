/*                  OPTIMAL SOLUTION O(n)
1. Check whether the current number is already in the set.
2. If it is, a duplicate exists within distance k, so return true.
3. Otherwise, add the current number.
4. If the set now contains more than k elements, remove the element that is too far away.
5. If no duplicate is found, return false. */

class Solution 
{
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        HashSet<Integer> set=new HashSet<>();
        for (int i=0;i<nums.length;i++) 
        {
            if (!set.add(nums[i])) 
                return true;
            if (set.size()>k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
