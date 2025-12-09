import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());


       while(t --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

       LinkedList<int[]> q = new LinkedList<>();
       st = new StringTokenizer(br.readLine());

       for(int i=0; i<n; i++) {
           // {초기 위치, 중요도}
           q.offer(new int[] { i,Integer.parseInt(st.nextToken()) });
       }
        int count = 0; // 출력 횟수

           //한 케이스에 대한 반복문
            while (!q.isEmpty()) {

                int[] front = q.poll(); //가장 첫 원소
                boolean ismax = true; //front가 가장 큰 원소인지 판단하는 변수

                //큐에 남아있는 원소들과 중요도를 비교
                for(int i=0; i<q.size(); i++) {

                    //처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우
                    if(front[1] < q.get(i)[1]) {

                        //뽑은 원소 및 i 이전에 원소들을 뒤로 보냄
                        q.offer(front);
                        for(int j=0; j<i; j++) {
                            q.offer(q.poll());
                        }

                        //front 원소가 가장 큰 원소가 아니었으므로 false를 하고 탐색 마침
                        ismax = false;
                        break;
                    }
                }

                //front 원소가 가장 큰 원소가 아니었으므로 다음 반복문으로 넘어감
                if(!ismax) {
                    continue;
                }

                //front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서임
                count++;
                if(front[0] == m) { //찾고자 하는 문서라면 해당 테스트케이스 종료
                    break;
                }


            }
           sb.append(count).append("\n");
        }
        System.out.println(sb);
       br.close();
    }
}






/*
            boolean hashigh = false;
             for(int[] doc: q) {
              if(doc[1]>prio) {
                  hashigh = true;
                  break;
              }
             }
             if(hashigh) {
                 q.offer(front);
             } else {
                 count ++;//q에서 빠짐
                 if(index == m) {
                     break;
                 }
             }
          }*/
