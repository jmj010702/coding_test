import java.io.IOException;
import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
              Map<String, Integer> map = new HashMap<>();
        int answer = 1;

        for (String[] a : clothes) { //clothes의 2차원 배열이 a로 전달됨
            if (map.containsKey(a[1])) {
                map.put(a[1], map.get(a[1]) + 1);
            } else {
                map.put(a[1], 1);
            }
        }

    for(String a : map.keySet()) {
        int n = map.get(a) + 1;
        answer *= n;
    }
//        1번 인덱스에 어떻게 접근을 할 것인가
return answer-1;
    }
}