class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int a : nums){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == 2) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}