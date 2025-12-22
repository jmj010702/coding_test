import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static void Permu(List<Integer> list, int m, boolean[] visit, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == m) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (visit[i]) continue;
            temp.add(list.get(i));
            visit[i] = true;
            Permu(list, m, visit, temp, result);
            temp.remove(temp.size() - 1);
            visit[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Comparator.naturalOrder());

        Permu(list, m, new boolean[list.size()], new ArrayList<>(), result);

        /*result.sort(new Comparator<List<Integer>>() {
    @Override
    public int compare(List<Integer> o1, List<Integer> o2) {
        if (o1.get(0) == o2.get(0)) {
return o1.get(1) - o2.get(1);
    } else {
            return o1.get(0) - o2.get(0);
        }
}

});*/

        for (List<Integer> a : result) {
            for (int b : a) {
                sb.append(b).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
