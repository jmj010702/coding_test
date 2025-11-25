import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력받은 값을 3,5로 나눈값으로 반복문을 짜면 될 거 같다

        //숫자 담을 변수
        int abc = 0;
        //아래서 쓸 숫자인지 아닌지 체크하는 변수
        boolean intej = false;

        for (int i = 0; i < 3; i++) {
            String str = br.readLine();

            //입력받은 문자열의 앞 문자만 따로 빼서 비교
            //charAt으로
            char c = str.charAt(0);
            //만약 입력받은 문자열이 숫자면 인티제 변경
            if (c != 'F' && c != 'B') {
                abc = Integer.parseInt(str);
                intej = true;
            }
            //숫자를 찾은 상태면 다음에 뭐가 오든 +1하여 다음수 추측
            if (intej) {
                abc++;
            }
        }

            //조건 분기로 답 출력
            if (abc % 3 == 0) {
                if (abc % 5 == 0) {
                    System.out.println("FizzBuzz");
                }
                else {
                    System.out.println("Fizz");
                }
            }
            else{
                if (abc % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    // i
                    System.out.println(abc);
                }
            }

        
    }
}



