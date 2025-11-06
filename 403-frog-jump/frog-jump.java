import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length == 0) {
            return true;
        }

   
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

    
        map.get(0).add(0); 

        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (int k : map.get(stone)) { 
            
                for (int jump = k - 1; jump <= k + 1; jump++) {
                    if (jump > 0) { 
                        int nextStonePos = stone + jump;
                        if (map.containsKey(nextStonePos)) {
                            if (nextStonePos == stones[stones.length - 1]) {
                                return true;
                            }
                            map.get(nextStonePos).add(jump);
                        }
                    }
                }
            }
        }

        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}