import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class Solution {
    public int[] solution(int[] sequence, int k) {
     int s = 0;
        int e = 0;

        int sum = sequence[s];
      int[] answer = new int[2];
answer[0] = Integer.MAX_VALUE;
answer[1] = Integer.MAX_VALUE;
    List<Integer> list = new ArrayList<>();
    list.add(Integer.MAX_VALUE);

        while (e < sequence.length) {
            if (sum == k) {
                sum -= sequence[s];
                if(e-s < list.get(list.size()-1)) {
                    list.add(e-s);
                    answer[0] = s;
                    answer[1] = e;
                } else if(e-s == list.get(list.size()-1)) {
                    if (answer[0] > s) {
                        answer[0] = s;
                        answer[1] = e;
                    }
                }

                s++;
            } else if (sum > k) {
                sum -= sequence[s];
                s++;

            } else if (sum < k) {
                e++;
                if (e == sequence.length) break;
                sum += sequence[e];
            }
        }
        list.sort(Comparator.naturalOrder());
        Arrays.sort(answer);
        return answer;
    }
}