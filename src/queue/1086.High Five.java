//1086. High Five - https://leetcode.com/problems/high-five/
//Time Complexity: O(n log n) and Space Complexity: O(n)
import java.util.*;

class solution{
    public int[][] highFive(int[][] items){
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for(int[] item : items){
            int id = item[0];
            int score = item[1];

            if(!map.containsKey(id)){
                map.put(id, new PriorityQueue<>( (a,b) -> b-a));
            }
            map.get(id).offer(score);
        }

        List<int[]> ans = new ArrayList<>();

        for(int id : map.keySet()){
            int sum = 0;

            for(int i=0; i<5; i++){
                sum = sum + map.get(id).poll();
            }
            ans.add(new int[]{id, sum/5});
        }

        int[][] result = new int[ans.size()][2];

        return ans.toArray(result);
    }
}
