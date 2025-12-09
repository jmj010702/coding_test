import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        while (n >= 5) {
            n = n / 5;
            count += n;
        }
                System.out.println(count);

        }
    }


 /*
        int sum =1 ;
        while(N != 0) {
            sum = sum *N;
            N--;
        }
        System.out.println(sum);
    */
/*
    public static int[] stack;
    public static  int size = 0;

 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = factorial(N);
        String strfac = String.valueOf(sum);
        int count = 0;
        for(int i=strfac.length() -1 ; i>=0; i--) {
            String tf = String.valueOf(strfac.charAt(i));
            if(tf.equals("0")) count++;
            else {
            break;
            }
        }

        System.out.println(count);




    }


    public static int factorial(int N) {
        if(N<=1) return 1;
        return N * factorial((N-1));
    }
*/