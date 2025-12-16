import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            int a = Integer.parseInt(br.readLine());
            list.add(a);
        }
        list.sort(Comparator.naturalOrder());
        if(n==0) {
            System.out.println(0);
            return;
        }
int x= (int) Math.round(n*0.15);
/*
for(int i = 0; i<x; i++) {
    list.remove(0);
}

for (int i = 0; i<x; i++) {
    list.remove(list.size()-1);
}*/
        list = list.subList(x,list.size()-x);
int rs = 0;
        int sum =0;
for(int i : list) {
    sum +=i;
}
rs = Math.round((float) sum/list.size());

        System.out.println(rs);
    }
}
