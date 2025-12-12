import java.io.IOException;
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
                    Map<String, Integer> map = new HashMap<>();
    for(String i : participant) {
       if(map.containsKey(i)) {
           map.put(i,map.get(i)+1);
       } else {
           map.put(i,1);
       }
    }
    for(String i : completion) {
        if(map.containsKey(i)) {
            if (map.get(i) == 1) {
                map.remove(i);
            } else {
                map.put(i, map.get(i)-1);
            }
        }
    }
String answer = "";
      for(String i : map.keySet()) {
          answer = i;

      }
      return answer;
    }
}