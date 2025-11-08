import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1); 

        HashMap<Integer, Integer> lakeToLastRainDay = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>(); 

        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) { 
                if (lakeToLastRainDay.containsKey(rains[i])) {
                   
                    int lastRainDay = lakeToLastRainDay.get(rains[i]);
                    
                    Integer dryDayToUse = dryDays.higher(lastRainDay);

                    if (dryDayToUse == null) {
                        return new int[0]; 
                    }

                    ans[dryDayToUse] = rains[i]; 
                    dryDays.remove(dryDayToUse);
                }
                lakeToLastRainDay.put(rains[i], i); 
            } else { 
                dryDays.add(i);
                ans[i] = 1; 
            }
        }
        return ans;
    }
}