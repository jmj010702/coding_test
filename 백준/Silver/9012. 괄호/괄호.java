import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());


        boolean tf = false;

        for(int i =0; i< n; i++) {

            String line = br.readLine();
            Stack<String> stak = new Stack<>();
            for(char a : line.toCharArray()) {
                if(a == '(') {
                    stak.push(String.valueOf(a));
                    tf = true;
                } else if(!stak.isEmpty() && a == ')') {
                    String str = stak.pop();
                    if (str.equals("(")) {
                        tf = true;
                    } else {
                        tf =false;
                        break;
                    }

                } else {
                    tf = false;
                    break;
                }

            }
            if(stak.isEmpty()) {
                if (tf) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            } else if (stak.pop().equals("(")) {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);


    }
}
