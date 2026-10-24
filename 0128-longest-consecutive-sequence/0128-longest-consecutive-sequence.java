
/*                                      BRUTE FORCE 

First, we sort the array in ascending order so that consecutive numbers appear next to each other.

Next, we create two TreeSets. The first set stores the consecutive numbers found in the current iteration, and the second set stores the longest consecutive sequence found so far.

We then start the outer loop, where the variable i selects the starting element of each sequence.

At the beginning of every iteration, we clear the current set and add nums[i] to it.

Next, the inner loop starts from index i and checks each pair of adjacent elements in the sorted array.

If nums[j] plus one equals nums[j + one], it means the two numbers are consecutive, so we add the next element to the current set.

We continue checking the adjacent elements until we reach the end of the array.

After the inner loop finishes, we compare the size of the current set with the size of the result set.

If the current set is larger, we clear the result set and copy all the elements from the current set into it.

This process repeats for every starting element in the array.

Finally, we return the size of the result set, which represents the length of the longest consecutive sequence found.
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set=new TreeSet<>();
        Set<Integer> result=new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            set.clear();
            set.add(nums[i]);
            for(int j=i; j<nums.length-1; j++) {
                if(nums[j]+1==nums[j+1])
                    set.add(nums[j+1]);
            }
            if(result.size()<set.size()) {
                result.clear();
                result.addAll(set);
            }
        }
        return result.size();
    }
}*/
/*                               BRUTE FORCE

Used count variable instead of a set, it saves a lot of space.
Fixed duplicater situations with continue and used break for better efficiency

PROBLEM: TO SLOWWWWWW  LEETCODE: Time Limit Exceeded  74 / 85 testcases passed

class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count=0, result=0;
        for(int i=0; i<nums.length; i++) {
            count=1;
            for(int j=i; j<nums.length-1; j++) {
                if(nums[j]+1==nums[j+1])
                    count++;
                else if(nums[j]==nums[j+1])
                    continue;
                else
                    break;
            }
            if(result<count)
            result=count;
        }
        return result;
    }
}*/
/*                                      OPTIMAL SOLUTION 

1. Create a HashSet and insert all elements of the array into it to remove duplicates and enable fast lookups.
2. Initialize count = 0 and result = 0.
3. Iterate through each number in the set.
4. Check whether num - 1 exists in the set. If it does, skip the number because it is not the beginning of a consecutive sequence.
5. If num - 1 does not exist, initialize count = 1 and set current = num.
6. Use a while loop to check whether current + 1 exists in the set. While it does, increment current and count.
7. After the sequence ends, compare count with result. If count is greater, update result = count.
8. Repeat this process for every number in the set.
9. Return result, which contains the length of the longest consecutive sequence.*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums)
            set.add(num);
        int count=0, result=0;

        for(int num:set) {
            if(!set.contains(num-1)) {
                count=1;
                int current=num;
                while(set.contains(current+1)) {
                    current++;
                    count++;
                }
                if(result<count)
                    result=count;
            }
        }
        return result;
    }
}