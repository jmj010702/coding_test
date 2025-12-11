import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, String> map1 = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        StringTokenizer    st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){

            map1.put(st.nextToken(), "1");
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){

            String str = st.nextToken();
            if(map1.containsKey(str)) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
/*  for(int i=0; i<n; i++) {

            arr[i] = st.nextToken();
        }

      String[] arr2 = new String[m];

        for(int i=0; i<m; i++) {
            StringTokenizer   st = new StringTokenizer(br.readLine());
            arr2[i] = st.nextToken();
        }

        for(int i =0; i< arr.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr[i].equals(arr2[j])) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.print(sb.toString());
*/

//boolean : true or false
