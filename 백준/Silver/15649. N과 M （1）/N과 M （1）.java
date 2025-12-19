import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //수열 최대값
        int m = Integer.parseInt(st.nextToken()); //길이
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        Permu(list, n, m, new boolean[n], new ArrayList<>(), result);


        for (List<Integer> a : result) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    public static void Permu(List<Integer> list, int n, int m, boolean[] visit, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == m) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;

            temp.add(list.get(i));
            visit[i] = true;
            Permu(list, n, m, visit, temp, result);
            temp.remove(temp.size() - 1);
            visit[i] = false;
        }
    }

}
