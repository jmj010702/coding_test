import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
                  Set<String> set = new HashSet<>();
for(String a : phone_book) {
    set.add(a);
}

            boolean answer = true;

            for(int i =0; i< phone_book.length; i++) {
                for (int j=1; j<phone_book[i].length(); j++) {
                  String as =  phone_book[i].substring(0,j);
                        if (set.contains(as)) {
                            answer = false;
                            break;
                        }
                }
            }
        return answer;
    }
}