/*          BRUTE FORCE
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int result[]=new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            result[i]=1;
            for(int j=0; j<nums.length; j++)
                if(i!=j)
                    result[i]*=nums[j];
        }
        return result;
    }
}*/
/*                              OPTIMAL SOLUTION
1.Store the product of elements to the left
2.Multiply by the product of elements to the right
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result=new int[nums.length]; 
        result[0]=1;

        for (int i=1; i<nums.length; i++) {
            result[i]=result[i-1]*nums[i-1];
        }

        int rightProduct=1;

        for (int i=nums.length-1; i>=0; i--) {
            result[i]*=rightProduct;
            rightProduct*=nums[i];
        }

        return result;
    }
}
