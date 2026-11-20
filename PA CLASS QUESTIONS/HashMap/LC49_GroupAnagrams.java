import java.util.*;

class LC49_GroupAnagrams {
    public void sortString(String s){

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String st:strs){
            char[] x=st.toCharArray();
            Arrays.sort(x);
            String newstr=new String(x);

            map.putIfAbsent(newstr,new ArrayList<>());
            map.get(newstr).add(st);
        }
        return new ArrayList<>(map.values());
    }
}