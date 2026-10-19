/*                              BRUTE FORCE O(n^2)

1. Split each word in the string array into a char array and sort it using sort()
2. We will use a nested for loop to chechk each word with all other words and see if we can match the sorted strings
3. We will implement a boolean visited flag to enusre tht copies of already parsed strings doesnt appear in the final output

NOTE: List is stored using reference

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String sorted_strs[]=new String[strs.length];
        for(int i=0; i<strs.length; i++) {                           O(n)
            char temp[]=strs[i].toCharArray();
            Arrays.sort(temp);
            sorted_strs[i]=new String(temp);
        }
        List<List<String>> outer_list=new ArrayList<>();
        boolean[] visited=new boolean[strs.length];
        for(int i=0; i<strs.length; i++) {                          O(n^2)
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
}*/

/* Lost it in betweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeen
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String sorted_strs[]=new String[strs.length];
        for(int i=0; i<strs.length; i++) {                           
            char temp[]=strs[i].toCharArray();
            Arrays.sort(temp);
            sorted_strs[i]=new String(temp);
        }
        Set<String> tempSet=new HashSet<>();
        List<List<String>> outer_list=new ArrayList<>();
        for(int i=0; i<strs.length; i++) {
            List<String> inner_list=new ArrayList<>();
            if(!tempSet.add(sorted_strs[i]))
                inner_list.add(strs[])
                wefuywguiywfwiuyfgfgheqiuygrewruygeruygbheiuygrbeuygrberuyhgdftywerhjyejfgywefnrf
        }
    }
}*/  
/*1. Take a word and count each char of it
  2. Using this count, built a unique key for HashMap
  3. Store words based on the key in the HashMap
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for(String s:strs) {
            int freq[]=new int[26];
            for(char c:s.toCharArray())
                freq[c-'a']++;
            StringBuilder key=new StringBuilder();
            for(int count:freq)
                key.append('#').append(count);
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>())
               .add(s);
        }
        return new ArrayList<>(map.values());
    }
}*/
/*Instead of building a complex key, we will use the sorted string as key*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}