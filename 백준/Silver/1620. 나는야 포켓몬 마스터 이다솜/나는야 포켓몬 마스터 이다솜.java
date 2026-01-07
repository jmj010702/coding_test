import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] staa = new String[n];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            String aa = br.readLine();
            staa[idx] = aa;
            map.put(aa, i);
            idx++;
        }

        for (int i = 0; i < m; i++) {
            String p = br.readLine();

            if (isint(p)) {
                int num = Integer.parseInt(p);
                sb.append(staa[num-1]).append("\n");
            } else {

                sb.append(map.get(p)).append("\n");
            }
        }

        System.out.println(sb);
    }
    static boolean isint(String s) {
        return s != null && s.matches("-?\\d+");
    }
}
