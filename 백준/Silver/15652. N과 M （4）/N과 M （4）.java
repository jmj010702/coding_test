import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i =1; i<=n; i++) {
            list.add(i);
        }

        Combie(list, m, 0, new ArrayList<>(), result);

        for(List<Integer> a  : result) {
            for(int b : a) {
                System.out.print(b+ " ");
            }
            System.out.println();
        }
    }

    public static void Combie(List<Integer> list,int m,int start, List<Integer> temp, List<List<Integer>> result) {
        if(temp.size() == m) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<list.size(); i++) {
            temp.add(list.get(i));
            Combie(list, m,start++, temp,result);
            temp.remove(temp.size()-1);


        }
    }
}
