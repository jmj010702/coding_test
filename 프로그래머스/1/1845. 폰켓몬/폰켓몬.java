import java.util.*; 
    class Solution {
    public int solution(int[] nums) {
    Set<Integer> set = new HashSet<>();
        for(int a : nums) {
            set.add(a);
        }
      
        int answer = Math.min(set.size(), nums.length/2);
        return answer;
    }
}