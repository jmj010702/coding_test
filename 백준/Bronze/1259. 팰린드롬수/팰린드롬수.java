import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean a = true;
        StringBuilder sb = new StringBuilder();
        while (a) {

            String sta = br.readLine();
            String end = sta;
            int star = 0;
            int endd = sta.length() - 1;

            //0이 나오면 while 루프 탈출
            if (sta.equals("0")) {
                a = false;
                break;
            }
            //판단하는 루프
            while (star < endd) {
                if (sta.charAt(star) != end.charAt(endd)) {
                    sb.append("no").append("\n");
                    break;
                }
                star++;
                endd--;
                if(star == endd) {
                    break;
                }
            }

            if(sta.charAt(star) == end.charAt(endd)) {
                sb.append("yes").append("\n");
            }
    }
    System.out.print(sb.toString());
    }
}
