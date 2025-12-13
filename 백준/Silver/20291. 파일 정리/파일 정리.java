import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuffer sb =new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        String[] strarr = new String[n];
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken(".");
            strarr[i] = st.nextToken(".");
        }  
        for (String a : strarr) {
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        int max =Integer.MIN_VALUE;
        String[][] as = new String[map.size()][];
        Integer[] aa = new Integer[map.size()];
        int index = 0;
        for (String a : map.keySet()) {
            sb.append(a).append(" ").append(map.get(a)).append("\n");
        }
        System.out.println(sb);

    }
}
