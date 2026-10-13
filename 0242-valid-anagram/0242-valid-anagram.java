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
}*/
/*                      BRUTE FORCE - 2 O(n) 

1. Check if both strings have equal length
2. Increment for letters in s and Decrement for letters in t
3. If array entries are zero, its an anagram

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
}*/

/*                 Bad solution using array was better than using hashmap

Why the array wins

Speed ---- Indexing is just arr[ch - 'a'], a direct memory access. A hash map has to compute a hash, handle possible collisions, and often box or allocate objects.
Memory ---- 26 ints is about 104 bytes, contiguous and cache-friendly. A hash map has per-entry overhead and is scattered in memory.
Simplicity ---- There’s no resizing and no key lookup logic.


class Solution {
    public boolean isAnagram(String s, String t)
    {
        if (s.length()!=t.length())
            return false;
        HashMap<Character, Integer> freq=new HashMap<>();
        for (int i=0;i<s.length();i++)
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
        for (int i=0;i<t.length();i++) {
            if (!freq.containsKey(t.charAt(i)) || freq.get(t.charAt(i))==0)
                return false;
            freq.put(t.charAt(i), freq.get(t.charAt(i))-1);
        }
        return true;
    }
}
*/


class Solution
{
    public boolean isAnagram(String s, String t)
    {
        char newS[]=s.toCharArray();
        char newT[]=t.toCharArray();
        Arrays.sort(newS);
        Arrays.sort(newT);
        return Arrays.equals(newS, newT);
    }
}