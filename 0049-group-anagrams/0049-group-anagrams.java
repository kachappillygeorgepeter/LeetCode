/*            
1. Split each word in the string array into a char array and sort it using sort()
2. We will use a nested for loop to chechk each word with all other words and see if we can match the sorted strings
3. We will implement a boolean visited flag to enusre tht copies of already parsed strings doesnt appear in the final output

NOTE: List is stored using reference
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String sorted_strs[]=new String[strs.length];
        for(int i=0; i<strs.length; i++) {
            char temp[]=strs[i].toCharArray();
            Arrays.sort(temp);
            sorted_strs[i]=new String(temp);
        }
        List<List<String>> outer_list=new ArrayList<>();
        boolean[] visited=new boolean[strs.length];
        for(int i=0; i<strs.length; i++) {
            if(visited[i]) continue;
            List<String> inner_list=new ArrayList<>();
            inner_list.add(strs[i]);
            visited[i]=true;
            for(int j=i+1; j<strs.length; j++) {
                if(!visited[j] && sorted_strs[i].equals(sorted_strs[j])) {
                    inner_list.add(strs[j]);
                    visited[j]=true;
                }
            }
            outer_list.add(inner_list);
        }
        return outer_list;
    }
}