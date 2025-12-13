import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuffer sb = new StringBuffer();
        String line;
        while(true) {
        line = br.readLine();

        if(line.equals(".")) {
            break;
        }
        sb.append(sta(line)).append("\n");
        }

        System.out.println(sb);
    }

    public static String sta(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '[') {
                st.push(ch);
            } else if(ch == ')') {
                if(st.isEmpty() || st.peek() !='(') {
                    return "no";
                } else {
                  st.pop();
                }
            } else if (ch == ']') {
                if (st.isEmpty() || st.peek() != '[') {
                    return "no";
                } else {
                   st.pop();
                }
            }
        }

        if (st.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }


}
