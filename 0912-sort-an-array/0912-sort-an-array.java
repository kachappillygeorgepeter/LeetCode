class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp=new int[nums.length];
        mergeSort(nums, temp, 0, nums.length-1);
        return nums;
    }

    void mergeSort(int nums[], int temp[], int left, int right) {
        if(left>=right)
            return;
        int mid=left+(right-left)/2; // This is the formula since we are not starting from 0 index, rather we are statring from a left index
        mergeSort(nums, temp, left, mid);
        mergeSort(nums, temp, mid+1, right);
        if(nums[mid]<=nums[mid+1])
            return;
        merge(nums, temp, left, mid, right);
    }

    void merge(int[] nums,int[] temp,int left,int mid,int right) {
        System.arraycopy(nums, left, temp, left, right-left+1);
        int i=left, j=mid+1, pos=left;
        while(i<=mid&&j<=right) {
            if(temp[i]<=temp[j])
                nums[pos++]=temp[i++];
            else
                nums[pos++]=temp[j++];
        }
        while(i<=mid)
            nums[pos++]=temp[i++];
        while(j<=right)
            nums[pos++]=temp[j++];
    }
}