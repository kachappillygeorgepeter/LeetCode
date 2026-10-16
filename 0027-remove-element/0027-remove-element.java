/*            Mistake: Thought i had to return the array
class Solution
{
    public int removeElement(int[] nums, int val)
    {
        int k=0; //Consider the number of elements in nums which are not equal to val be k
        for(int num:nums)
            if(num!=val)
                k++;
        for(int i=0; i<nums.length-1; i++)
        {
            int pos=i+1;
            while(nums[i]==val)
                nums[i]=nums[pos++];
        }
        return k;
    }
}*/
class Solution
{
    public int removeElement(int[] nums, int val)
    {
        int k=0; //Consider the number of elements in nums which are not equal to val be k
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]!=val)
                nums[k++]=nums[i];
        }
        return k;
    }
}