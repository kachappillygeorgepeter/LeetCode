// char c[]=s.toCharArray();
// s.charAt(left)-->c[left]          s.charAt(right)-->c[right]          Speed improves!!!!!!
class Solution {
    public boolean validPalindrome(String s) {
        int left=0, right=s.length()-1;
        char c[]=s.toCharArray();
        while(left<right) {
            if(c[left]!=c[right]) {
                return isPal(s, left+1, right) || isPal(s, left, right-1);
            }
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    boolean isPal(String s, int left, int right) {
        while (left<right) {
            if(s.charAt(left++)!=s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
