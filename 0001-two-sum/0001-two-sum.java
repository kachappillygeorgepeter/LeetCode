/*                              BRUTE FORCE O(n^2)
In this apporach we are just comparing adjacent values and checking
if the sum of these adjacents equal the target value.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]=new int[2];
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<nums.length;j++)
                    if(nums[i]+nums[j]==target && i!=j){
                        ans[0]=i;
                        ans[1]=j;
                    }
        return ans;                        
    }
}
*/
/*                      Optimal Solution O(n)
1. Calculate the complement.
2. Check whether the complement is already in the map.
3. If found, return both indices.
4. Otherwise, store the current number and its index.
*/
class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> seen=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int complement=target-nums[i];
            if(seen.containsKey(complement))
                return new int[]{i, seen.get(complement)};
            seen.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}