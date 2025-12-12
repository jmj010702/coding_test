import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int n = Integer.parseInt(br.readLine());
        Map<String , Integer> map = new HashMap<>();
        String[] name = new String[n];
        for(int i=0; i<n; i++) {
             name[i] = br.readLine();
        }
        for(String i: name) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }
        String maxkey = "";
        List<String> list = new ArrayList<>();
        for(String a: map.keySet()) {
            if (max< map.get(a)) {
                max = map.get(a);
                maxkey = a;
            }
        }
for(String a : map.keySet()) {
    if(max == map.get(a)) {
        list.add(a);
    }
}
        list.sort(Comparator.naturalOrder());
        System.out.println(list.get(0));

    }
}
