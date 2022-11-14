class solution{
public int removeStones(int[][] stones) {
        Set visit = new HashSet();
        int count = 0;
        int offset = 10000;
        HashMap <Integer,List<int []>>map = new HashMap();

       
        for (int i = 0; i < stones.length; i++) {
            int [] node = stones[i];
            List<int []> list =   map.getOrDefault(node[0]-offset,new ArrayList<>());
            list.add(node);
            map.put(node[0]-offset,list);

            List<int []> list1 = map.getOrDefault(node[1],new ArrayList<>());
            list1.add(node);
            map.put(node[1],list1);
        }
       
        for (int i = 0; i < stones.length; i++) {
            int [] node = stones[i];
            if (!visit.contains((node))){
                visit.add((node));
                dfs(node,visit,map);
                count++;
            }
        }
        return stones.length-count;
    }

   
    public void dfs(int[]node, Set set,HashMap <Integer,List<int []>>map){
        int offset = 10000;
        List<int []> list =   map.getOrDefault(node[0]-offset,new ArrayList<>());
        for (int i = 0; i < list.size(); i++) {
            int[] item = list.get(i);
            if (!set.contains((item))){
                set.add((item));
                dfs(item,set,map);
            }
        }
        List<int []> list2 =   map.getOrDefault(node[1],new ArrayList<>());
        for (int i = 0; i < list2.size(); i++) {
            int[] item = list2.get(i);
            if (!set.contains((item))){
                set.add((item));
                dfs(item,set,map);
            }
        }
    }
}
