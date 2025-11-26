import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int d = gcd2(a, b);

        System.out.println(d);
        System.out.println(a * b / d);
    }
        /*
        //최대 공약수 반복문 방식
        int gcd1(int a,int b) {
            while(b != 0) {
                int r = a%b; //나머지 구하기

                //gcd(a,b) = gcd(b,r)이므로 변환한다
                a=b;
                b=r;
            }
            return a;
        }
        */

    //최대공약수 재귀 방식
    public static int gcd2(int a, int b) {
        if (b == 0) return a;
        return gcd2(b, a % b);
    }
}

        /*
        //최소 공배수 : Least Common multiple
        int lcm( a, b) {
            return a*b/gcd2(a,b);
        }
        */