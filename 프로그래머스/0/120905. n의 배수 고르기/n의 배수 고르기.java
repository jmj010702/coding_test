import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] solution(int n, int[] numlist) {
    
        List<Integer> list = new ArrayList<>();
        for(int i : numlist) {
            if( i% n == 0) {
           list.add(i);
        }
        }
int[] answer = new int[list.size()];
        int index =0;
        for(int i : list) {
            answer[index] = i;
            index++;
        }
         
        return answer;
    }
}