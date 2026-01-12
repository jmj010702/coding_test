import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < t.length(); i++) {
            list2.add(String.valueOf(t.charAt(i)));
        }
        while (list2.size() != s.length()) {
            if (list2.get(list2.size() - 1).equals("A")) {
                list2.remove(list2.size() - 1);
//                System.out.println(list2);
            } else { //b인 경우
                list2.remove(list2.size() - 1);
                    Collections.reverse(list2);
                
            }
        }
//        System.out.println(list2);
        String x = "";
        for(String bb : list2) {
            x+=bb;
        }
//        System.out.println(x);
        if (x.equals(s)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
