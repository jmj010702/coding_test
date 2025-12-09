import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //생성자인지 아닌지 체크하는 배열
        boolean[] bool = new boolean[100001];

        for(int i =1; i<=10000; i++) {
            //bool[i]가 생성자라면 true
        bool[make(i)] = true;
            if (!bool[i]) {
                sb.append(i).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    //생성자 만드는 메서드
    public static  int make(int a) {
        int sum =0;
        String numstr = String.valueOf(a);
        int strindex ;
        for(int i =0; i<numstr.length(); i++) {
            // charAt은 아스키 코드 값을 주기 때문에 -'0'
            strindex = numstr.charAt(i) -'0';
            sum+=strindex;
        }
        a+=sum;
        return a;
    }
}
