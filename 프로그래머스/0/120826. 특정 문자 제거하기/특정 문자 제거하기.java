import java.util.*;
class Solution {
    public String solution(String my_string, String letter) {
           StringBuilder sb = new StringBuilder();
         for(int i=0; i<my_string.length(); i++) {
            String as = String.valueOf(my_string.charAt(i));
            if(as.equals(letter)){
                continue;
            }
            else {
                sb.append(as);
            }
        }
        String answer = sb.toString();
        return answer;
    }
}