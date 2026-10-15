/*            FAILS for negative array entries

class Solution
{
    public int majorityElement(int[] nums)
    {
        int max=nums[0],pos=0;
        for(int ele:nums)
            if(ele>max)
                max=ele;
        int count[]=new int[max+1];
        for(int ele:nums)
            count[ele]++;
        max=-1;
        for(int i=0;i<count.length;i++)
            if(count[i]>max)
            {
                max=count[i];
                pos=i;
            }
        return pos;
    }
}*/
/*The Boyer–Moore Voting Algorithm efficiently finds the majority element in an array—an element that appears more than N/2 times—using two passes. In the first pass, it selects a potential candidate by increasing a counter when the same element is encountered and decreasing it when a different element appears, effectively canceling out non-majority elements. In the second pass, the algorithm verifies whether this candidate actually occurs more than N/2 times. This method runs in O(N) time and requires only O(1) extra space, making it both fast and memory-efficient.

                            o(n)                            */

class Solution
{
    public int majorityElement(int[] nums)
    {
        int candidate=0, count=0;
        for (int num:nums)
        {
            if (count==0)
                candidate=num;
            if (num==candidate) 
                count++;
            else
                count--;
        }
        return candidate;
    }
}
/*                  O(n logn)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return nums[n/2];
    }
}*/
