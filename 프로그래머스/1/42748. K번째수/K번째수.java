import java.io.IOException;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
      int j=0, k=0;
        int index =0;
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
                 j = commands[i][0]-1;
                 k = commands[i][1];
               index = commands[i][2];
                int[] arr2 = Arrays.copyOfRange(array, j, k);
                Arrays.sort(arr2);
                answer[i] = arr2[index-1];
        }
        return answer;
    }
}