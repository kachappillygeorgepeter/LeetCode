/*                       BRUTE FORCE O(n)
class Solution
{
    public int[] getConcatenation(int[] nums) 
    {
        int result[]=new int[2*nums.length];
        for(int i=0;i<nums.length;i++)                       O(n)
            result[i]=nums[i];
        for(int i=nums.length;i<2*nums.length;i++)           O(n)
            result[i]=nums[i-nums.length];
        return result;
    }
}*/
class Solution
{
    public int[] getConcatenation(int[] nums) 
    {
        int n=nums.length;
        int result[]=new int[2*n];
        for(int i=0;i<n;i++)                       
            result[i]=nums[i];
        for(int i=n;i<2*n;i++)                      
            result[i]=nums[i-n];
        return result;
    }
}