import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] arr = input.split("");

        int starIndex = -1; //*의 위치
        int sum =0; //*을 제외한 가중합
        /*
        int[] arr1 = new int[input.length()];
        int index =0;
*/
        for(int i=0; i<input.length(); i++) {
            if(arr[i].equals("*")) {
                starIndex = i; // 위치 저장

                continue;
            }
            int num = Integer.parseInt(arr[i]);
            //짝수 인덱스
            if(i%2 ==0) {
                sum+=num;
            } else { //홀수 인덱스
                sum +=num * 3;
            }
        }
        //현재 합의 mod 10값
        int r = sum %10;
        int rs;

        //위치가 짝수 인덱스인가 홀수 인덱스인가
        if(starIndex % 2 == 0) {
            //짝수 인덱스 -> weight = 1
            rs = (10-r) %10;
        } else {
            //홀수 인덱스 -> weight = 3
            //3 * x = (10-r) (mod 10)
            rs = ((10 -r) * 7) % 10;
        }

        System.out.println(rs);
        /*
        for(int i = 0; i<input.length(); i++) {
            if (i%2 !=0) {
            arr1[i] *= 3;
            }
            index +=arr1[i];
        }
        int rs = index%10;
       ///짝수일 경우
        (rs+x) %10 == 0
        x= (10-(rs%10)) %10;
        rsf = (10-rs)%10;
        //홀수일 경우
        (rs+3x) %10 == 0
                3x = (10-(rs%10)) %10;
                x = ((10-(rs))*7)%10
            rsf = ((10-rs)*7)%10;
        System.out.println(rsf);
*/
        //*전까지 숫자들에 짝수 인덱스면 3곱해줌
        //그 값들을 다 더하기
        //더한 값을 10으로 나눔
        //여기서 나머지가 0이면 *은 0
        //나머지(aaa)가 있다면
        //aaa를 나눠서 나머지가 없도록 만들어야 됨
        // 2or3 해당 값이 m
    }
}
