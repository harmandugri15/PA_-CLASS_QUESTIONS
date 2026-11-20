import java.util.*;

class LC347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hmap=new HashMap<>();
        for(int i:nums){
            hmap.put(i,hmap.getOrDefault(i,0)+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue();
        for(int i:hmap.values()){
            pq.add(i);
        }

        ArrayList<Integer> arr=new ArrayList<>();

        while(pq.size()>k){
            pq.poll();
        }
        
         for(int i:hmap.keySet()){
            if(pq.contains(hmap.get(i))){
                arr.add(i);
                pq.remove(hmap.get(i));
            }
        }
        int[] arr1=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            arr1[i]=arr.get(i);
        }
        return arr1;
    }
}