//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        //Getting no. of each type of tasks
        for(int i=0;i<tasks.length;i++){
            if(map.containsKey(tasks[i])) map.replace(tasks[i],map.get(tasks[i]),map.get(tasks[i])+1);
            else map.put(tasks[i],1);
        }
        
        //Logic
        int count=0;
        //map.forEach((k, v) -> System.out.println(k + " : " + (v))); 
        
        //Creating a priority queue [max heap] and adding all the values onto th epriority queue [Here we are trying to start with the most frequent value, hence we use a maxHeap]
       
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        
        maxHeap.addAll(map.values());
         while(!maxHeap.isEmpty()){
            List<Integer> list = new ArrayList<>(); 
            for(int i=0;i<n+1;i++){
              if(!maxHeap.isEmpty()) list.add(maxHeap.remove());
            }
            //System.out.println(list);
            
            for(int k : list){
                if(--k>0) maxHeap.add(k);
            }
            
            //System.out.println(list);
            if(!maxHeap.isEmpty()) count += n+1;
            else count+=list.size();
        }    
        return count;       
    }
}
