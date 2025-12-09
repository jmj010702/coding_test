import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i <= n; i++) {
            //1이면 한수라는 뜻
            if (deng(i) == 1) {
                count++;
            }

        }
        System.out.print(count);
    }


    public static int deng(int a) {
        String strnum = String.valueOf(a);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < strnum.length(); i++) {
            list.add(strnum.charAt(i) - '0');
        }

        boolean bool = true;
        int rs = 0;
        //한,두자리는 무조건 한수
        if (strnum.length() < 3) {
            //한수면 1반환
            return 1;
        }

        for (int i = 0; i < list.size() - 2; i++) {
            int sum = list.get(i) - list.get(i + 1);
            int sum2 = list.get(i + 1) - list.get(i + 2);
            if (sum != sum2) {
                //하나라도 다르면 한수 X
                return 0;
            }
        }
        //모두 같으면 한수 1
        return 1;
    }
}
