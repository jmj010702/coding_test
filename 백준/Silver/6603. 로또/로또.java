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

        StringTokenizer st;


        String line;
        while (true) {
//            st = new StringTokenizer(br.readLine());
            line = br.readLine();

            if (line.equals("0")) {
                break;
            } else {
                List<List<Integer>> result = new ArrayList<>();

                List<Integer> list = new ArrayList<>();
                st = new StringTokenizer(line);

                int k = Integer.parseInt(st.nextToken());

                for (int i = 0; i < k; i++) {
                    list.add(Integer.parseInt(st.nextToken()));
                }


                Combie(list, 6, 0, new ArrayList<>(), result);


                for (List<Integer> a : result) {
                    for (int b : a) {
                        System.out.print(b + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }

    }

   /* public static void Permu(List<Integer> list, int k, boolean[] visit, List<Integer> temp, List<List<Integer>> result) {

        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (visit[i]) continue;
            temp.add(list.get(i));
            visit[i] = true;
            Permu(list, k, visit, temp, result);
            temp.remove(temp.size() - 1);
            visit[i] = false;
        }
    }*/

    public static void Combie(List<Integer> list, int k, int start, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <list.size(); i++) {
            temp.add(list.get(i));
            Combie(list, k, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
