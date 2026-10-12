/*                      BRUTE FORCE O(n^2)

String.toLowerCase iterates n times to convert each character
w+=s.charAt(i); runs n^2 times since String is immutable

class Solution
{
    public boolean isPalindrome(String s)
    {
        s=s.toLowerCase();                                              O(n)
        String w="";
        for(int i=0;i<s.length();i++)
            if(Character.isLetterOrDigit(s.charAt(i)))
                w+=s.charAt(i);                                         O(n^2)
        for(int i=0, j=w.length()-1 ;i<j; i++, j--)
            if(w.length()>0 && w.charAt(i)!=(w.charAt(j)))
            return false;                                               O(n)
        return true;
    }
}*/
/*                           OPTIMAL SOLUTION O(n)

1. Initialize pointers: left = 0, right = s.length() - 1.
2. Loop while left < right:
   - If the left character is non-alphanumeric, increment left.
   - Else if the right character is non-alphanumeric, decrement right.
   - Otherwise, compare both characters after converting them to lowercase.
3. Mismatch: If characters differ, return false.
4. Match: Move both pointers inward (left++, right--).
5. Finish: If the loop completes, return true
 */
class Solution
{
    public boolean isPalindrome(String s)
    {
        int left=0, right=s.length()-1;
        while(left<right)
        {
            if(!Character.isLetterOrDigit(s.charAt(left)))
                left++;
            else if(!Character.isLetterOrDigit(s.charAt(right)))
                right--;
            else
            {
                if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right)))
                    return false;
                left++;
                right--;
            }
        }
        return true;
    }
}