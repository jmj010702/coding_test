import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb =new StringBuffer();
        Map<Integer,Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] st_in =  new int[n];
        int index=0;
        while (st.hasMoreTokens()) {
            st_in[index] =  Integer.parseInt(st.nextToken());
         index++;
        }  for(int a : st_in) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] m_in =  new int[m];
        int idx =0;
        while(st.hasMoreTokens()) {
            m_in[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }
//        for(int a: m_in) {
//               if(map.containsKey(a)) {
//                   map2.put(a, map.get(a)+1);
//               } else {
//                   map.put(a,0);
//               }
//        }

        for(int a : m_in) {
            sb.append(map.getOrDefault(a, 0)).append(" ");
        }
        System.out.println(sb);





    }
}
/*

 if(map.containsKey(a)) {
        if(map.get(a) == 1) {
        map.put(a,0);
                } else {
                        map.put(a, map.get(a) -1);
        }

        }*/