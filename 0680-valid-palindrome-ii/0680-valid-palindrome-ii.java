// char c[]=s.toCharArray();
// s.charAt(left)-->c[left]          s.charAt(right)-->c[right]          Speed improves!!!!!!
class Solution {
    public boolean validPalindrome(String s) {
        int left=0, right=s.length()-1;
        char c[]=s.toCharArray();
        while(left<right) {
            if(c[left]!=c[right]) {
                return isPal(c, left+1, right) || isPal(c, left, right-1);
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    boolean isPal(char c[], int left, int right) {
        while (left<right) {
            if(c[left++]!=c[right--]) {
                return false;
            }
        }
        return true;
    }
}
