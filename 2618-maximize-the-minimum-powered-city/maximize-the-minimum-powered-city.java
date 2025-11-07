import java.util.Arrays;

class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] initialPower = new long[n];

        long currentWindowSum = 0;
       
        for (int j = 0; j <= Math.min(n - 1, r); j++) {
            currentWindowSum += stations[j];
        }
        initialPower[0] = currentWindowSum;

        for (int i = 1; i < n; i++) {
            if (i - r - 1 >= 0) {
                currentWindowSum -= stations[i - r - 1];
            }
            
            if (i + r < n) {
                currentWindowSum += stations[i + r];
            }
            initialPower[i] = currentWindowSum;
        }

        long low = 0;
        
        long high = 2_000_000_000_000_000L; 
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (check(mid, initialPower, r, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(long targetPower, long[] initialPower, int r, int k, int n) {
        long[] currentTotalPower = Arrays.copyOf(initialPower, n);
        long stationsNeeded = 0;
       
        long[] addedPowerDelta = new long[n + 1]; 

        for (int i = 0; i < n; i++) {
           
            if (i > 0) {
                addedPowerDelta[i] += addedPowerDelta[i - 1];
            }
            currentTotalPower[i] += addedPowerDelta[i];

            if (currentTotalPower[i] < targetPower) {
                long needed = targetPower - currentTotalPower[i];
                stationsNeeded += needed;
                if (stationsNeeded > k) {
                    return false; 
                }
               
                addedPowerDelta[i] += needed;
                
                if (i + 2 * r + 1 < n + 1) { 
                    addedPowerDelta[i + 2 * r + 1] -= needed;
                }
            }
        }
        return true;
    }
}