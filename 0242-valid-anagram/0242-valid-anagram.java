/*                          BRUTE FORCE O(n)
class Solution
{
    public boolean isAnagram(String s, String t) 
    {
        if(s.length()!=t.length())
            return false;
        List<Character> letters=new ArrayList<>();
        for(int i=0;i<s.length();i++)                               O(n)
            letters.add(s.charAt(i));
        for(int i=0;i<t.length();i++)                               O(n)
            if(!letters.remove(Character.valueOf(t.charAt(i))))
            return false;
        if(letters.isEmpty())
            return true;
        return false;
    }
}
*/
/*                      OPTIMAL SOLUTION O(n) 

1. Check if both strings have equal length
2. Increment for letters in s and Decrement for letters in t
3. If array entries are zero, its an anagram
*/
class Solution
{
    public boolean isAnagram(String s, String t)
    {
        if (s.length() != t.length())
            return false;
        int[] frequency=new int[26];
        for (int i=0;i<s.length();i++)
        {
            frequency[s.charAt(i) - 'a']++;         // To get index of alphabets
            frequency[t.charAt(i) - 'a']--;
        }
        for (int count:frequency)
            if (count!=0) 
                return false;
        return true;
    }
}