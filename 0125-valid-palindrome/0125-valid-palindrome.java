class Solution
{
    public boolean isPalindrome(String s)
    {
        s=s.toLowerCase();
        String w="";
        for(int i=0;i<s.length();i++)
            if(Character.isLetterOrDigit(s.charAt(i)))
                w+=s.charAt(i);
        for(int i=0, j=w.length()-1 ;i<j; i++, j--)
            if(w.length()>0 && w.charAt(i)!=(w.charAt(j)))
            return false;
        return true;
    }
}