/*Two Pointer stuff
class Solution {
    public void reverseString(char[] s) {
        int left=0, right=s.length-1;
        while(left<right) {
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}*/
//                      OPTIMAL SOLUTION
// We can simply use one pointer and go upto half of the arrya, cuz if we traverse upto half, the entire array will be sorted

class Solution {
    public void reverseString(char[] s) {
        int right=s.length;
        for(int left=0; left<right/2; left++) {
            char temp=s[left];
            s[left]=s[right-1-left];
            s[right-1-left]=temp;
        }
    }
}