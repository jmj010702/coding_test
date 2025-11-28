import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        ArrayList<String> list = new ArrayList<>();
        int min = 1;
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        for (int i = 0; i < str.length; i++) {
                list.add(str[i]);
        }
        //::는 메서드 참조 연산자 C++과는 다름 C++은 ~의 라고 쓰이는 스코프연결 연산자
        //Comparator.comparingInt(String::length)
        //문자열의 길이 = int값
        //int값을 기준으로 비교하는 comparator를 만들어주는 static
        //String:: length = String s -> s.length

        //.thenComparing(String::compareTo)
        //then~ comparator의 인스턴스 메서드
        //compareto()는 사전순 비교 메서드

        Collections.sort(list,Comparator.comparingInt(String::length).thenComparing(String::compareTo));
        //list 복사한후
        ArrayList<String> listcp = new ArrayList<>();
        //반복문 돌려서  s에 저장
        for(String s : list){
            //contains 포함 여부 검사 s가 있다면 true 없으면  false
            //listcp에 s가 포함되어 있지 않다면 
            if(!listcp.contains(s)) {
                listcp.add(s);
            }
        }
        for(String s : listcp) {
            System.out.println(s);
        }
       /* for (int i = 0; i < str.length; i++) {
            if(str[i].length() <=str[0].length()) {
                list.add(0,str[i]);
            }
        }*/
        /*
        for (String s : list) {
            if(s.equals(list))
            {
                list.remove(s);
            }
            System.out.println(s);

        }*/
    }
}
/*
// Collections.sort()는 내부적으로 이렇게 동작
for (int i = 0; i < list.size(); i++) {
        for (int j = i + 1; j < list.size(); j++) {
String s1 = list.get(i);  // 리스트에서 꺼낸 첫 번째 문자열
String s2 = list.get(j);  // 리스트에서 꺼낸 두 번째 문자열

// 여기서 String::length가 사용
int length1 = s1.length();  // String::length의 s가 s1
int length2 = s2.length();  // String::length의 s가 s2

// 비교해서 정렬
        if (length1 > length2) {
        // swap
        }
        }
        }*/

