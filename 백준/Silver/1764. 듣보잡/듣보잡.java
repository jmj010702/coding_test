import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String > nolisten = new HashSet<>();
        Set<String> nosee = new HashSet<>();


        for (int i = 0; i < n; i++) {
        nolisten.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
        nosee.add(br.readLine());
        }

        int count = 0;
        StringBuilder sb =new StringBuilder();
        List<String> list = new ArrayList<>();
        for(String a : nolisten) {
            if(nosee.contains(a)) {
                count ++;
                list.add(a);
            }
        }
list.sort(Comparator.naturalOrder());
        for(String a : list) {
            sb.append(a).append("\n");
        }
        System.out.println(count+"\n" +sb);
    }
}
