class Solution {
    public int solution(int[][] sizes) {
         int wrs =0;
        int hrs =0;
        for(int i =0; i< sizes.length; i++) {
            int wmax = Math.max(sizes[i][0], sizes[i][1]);
            int  hmax = Math.min(sizes[i][0], sizes[i][1]);
             if(wrs<wmax) {
                 wrs = wmax;
             }
             if(hrs < hmax) {
                 hrs = hmax;
             }
        }
        int answer = wrs * hrs;

       return answer;
    }
}