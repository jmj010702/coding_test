import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
StringBuffer sb = new StringBuffer();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<=n; i++) {
            list.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        Comnie(list,m,new ArrayList<>(), result);
        for(List<Integer> a : result) {
            for(int b : a) {
            sb.append(b).append(" ");
            }
            sb.append("\n");
        }
bw.write(String.valueOf(sb));
bw.flush();
bw.close();
br.close();
    }

    public static void Comnie(List<Integer> list , int m , List<Integer> temp, List<List<Integer>> result) {
        if(temp.size() == m) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i =0; i<list.size(); i++) {
            temp.add(list.get(i));
            Comnie(list,m,temp, result);
            temp.remove(temp.size()-1);
        }
    }
}
