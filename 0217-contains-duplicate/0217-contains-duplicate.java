/*                          BRUTE FORCE SOLUTION O(n^2)

1. Pick an element from the array using the outer loop (i).
2. Compare it with every element in the array using the inner loop (j).
3. Skip the comparison if i == j, because both indices point to the same element.
4. If two elements at different indices have the same value, return true.
5. If no duplicate is found, move to the next element and repeat the process.
6. If all elements have been checked and no duplicates are found, return false.
class Solution 
{
    public boolean containsDuplicate(int[] nums) 
    {
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<nums.length;j++)
                if(i!=j && nums[i]==nums[j])
                    return true;
        return false;
    }
}*/

/*                              OPTIMAL SOLUTION O(n)

1. Create an empty HashSet to store numbers we have already seen.
2. Traverse the array one element at a time.
3.If the number is already in the set, return true. Otherwise, add it to the set.
4.If the loop finishes without finding a duplicate, return false.*/
class Solution 
{
    public boolean containsDuplicate(int[] nums) 
    {
        HashSet<Integer> set=new HashSet<>();
        for (int num:nums) 
        {
            /*if (set.contains(num))
                return true;
            set.add(num);*/
            if(!set.add(num)) //Returns false if it fialed to add it, else true therum
                return true;
        }
        return false;
    }
}
