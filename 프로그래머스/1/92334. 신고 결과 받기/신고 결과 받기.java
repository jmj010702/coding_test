import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        //유저 ID  == id_list
        // 유저가 신고한 이용자의 ID 정보 == report  신고한 사람 신고당한 사람
        // 정지 기준이 되는 신고 횟수 == k 
  
        Map<String, Set<String>> map = new HashMap<>();
        for(int i =0; i< report.length; i++) {
            String[] s = report[i].split(" ");
            if(!map.containsKey(s[1])){ // map은 키값이 중복이 안되므로 있다면 value에 신고자만 넣고 싶음 
                    map.put(s[1], new HashSet<>());
            }
            map.get(s[1]).add(s[0]);
        }
                int[] answer = new int[id_list.length];
        int xx = 0;
        Map<String,Integer> result = new HashMap<>();

        for(Map.Entry<String, Set<String>> m : map.entrySet()) {
            String  a = m.getKey();
            Set<String> b = m.getValue();
            int c = b.size();
    if(c>=k) { // b에 있는 사람들에게 +1 시켜야됨 
        for(String s : b) {
       result.put(s,result.getOrDefault(s, 0) +1);  //누가 몇개의 메일을 받는지는 정함 허나 순서가 문제 
        //    배열의 담는다 처도 순서를 어떻게 담을 것인가 map에 있는 걸 그대로 뺴면 순서가 보장이 안될텐데            
        }
    }
        }
        for(int i=0; i< id_list.length; i++) {
         answer[i] = result.getOrDefault(id_list[i],0);
        }
            
        return answer;
    }
}