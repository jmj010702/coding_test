import java.util.*;
import java.time.LocalDate;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // today == 오늘 날짜  yyyy.mm.dd 
        // terms == 각 약관의 유효 기간 1차원 배열  A n 
        // privacies  == 개인 정보의 정보를 담은 1차원 배열 i+1번  yyyy.mm.dd A
        LocalDate date = LocalDate.parse(today.replace(".","-"));
        List<Integer> list = new ArrayList<>();
        

        for(int i=0; i< privacies.length; i++) {
            // 각각의 개인정보의 정보를 분리함 
            String[] s = privacies[i].split(" ");
            LocalDate endDate = LocalDate.parse(s[0].replace(".","-")); // 공백을 기준으로 앞뒤로 분리해야함 
            String eachTermsType = s[1];
            for(int j =0; j< terms.length; j++) {
                // 각 약관의 정보를 분리 
                String[] t = terms[j].split(" ");
                String termsType = t[0];
                int termsDate = Integer.parseInt(t[1]);
                // 각 약관종류와 동일한 개인정보를 찾음 
                if(termsType.equals(eachTermsType)){
                    LocalDate endTotalDate = endDate.plusMonths(termsDate); // 해당 일자에 약관의 개월 수를 더함 (월만)
                    // 만약 현재 날짜보다 적은 날짜라면 해당 번호를 answer 배열에 담음 
                    if(endTotalDate.isBefore(date) || endTotalDate.isEqual(date) ) {
                    list.add(i+1);
                    }
                }
            }
            
        }
                        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i]= list.get(i);
        }

        return answer;
    }
}