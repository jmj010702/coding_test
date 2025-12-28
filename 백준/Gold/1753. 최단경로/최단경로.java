import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
//   정점 개수 v, 간선 개수 e , 시작점 k
  static int v,e,k;
//  그래프 구조 -> graph[n]에서 갈 수 있는 모든 간선 목록을 저장한 리스트 배열
  static List<edge>[] graph;
//시작점에서 k에서 dist[n]까지의 현재까지 알려진 최단 거리를 저장 하는 배열
  static int[] dist;
//  아직 도착 못한 정점 거리
  static final int INF = Integer.MAX_VALUE;

//  간선 저장할 클래스
  static class edge {
//      도착 정점 to, 가중치 cost
      int to, cost;
      edge(int to, int cost) {
          this.to = to;
          this.cost = cost;
      }
  }


  static void dijk(int start) {
//      우선 순위 큐 생성 -> 가장 비용이 작은 정점부터 꺼내는 큐
      PriorityQueue<edge> pq = new PriorityQueue<>( (a,b) -> a.cost - b.cost);
//  거리 배열 무한대로 초기화
      Arrays.fill(dist, INF);
//      시작정점은 비용 0
      dist[start] = 0;
//      시작점, 가중치 삽입
      pq.offer(new edge(start, 0));

      while(!pq.isEmpty()) {
//          cur이라는 참조 변수 생성 -> 아직 처리 안한 정점 중 가장 가까운 거 선택
          edge cur = pq.poll();
//         최단 거리로 처리할 정점/ 위에 정점 번호
          int now = cur.to;
//          now까지의 비용  / 시작점에서 그 정점까지의 거리
          int nowcost = cur.cost;

//          더 좋은 경로가 이미 있으면 무시
          if(dist[now] < nowcost) continue;
//          now 정점에서 나가는 모든 간선
          for(edge e : graph[now]) {
//              도착 정점 번호
              int next = e.to;
//              시작점에서 now -> next로 가는 총 가중치
              int nextcost = nowcost + e.cost;
//              dist[next] : 현재까지 알고 있는 최선의 값
//              nextcost : 이번에 새로 발견한 후보 값
              if(dist[next] > nextcost) {
                  dist[next] = nextcost;
//              next 정점을 다음 탐색 출발점으로 등록
                  pq.offer(new edge(next,nextcost));
              }
          }
      }
  }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
//      정점 개수, 간선 개수, 시작 정점
        v= Integer.parseInt(st.nextToken());
        e= Integer.parseInt(st.nextToken());
        k= Integer.parseInt(br.readLine());
//      그래프 배열 생성(정점 번호 1부터 시작하기 때문에 +1)
        graph = new ArrayList[v+1];

//        각 정점에 리스트 할당
        for(int  i=1; i<=v; i++) graph[i] = new ArrayList<>();

//        간선 입력 받고 저장
        for(int i =0; i< e; i++) {
            st = new StringTokenizer(br.readLine());
//            시작 정점 u, 도착정점 v2, 가중치 w
            int u = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
//          graph[u]에 v2,w저장
            graph[u].add(new edge(v2,w));
        }
//      최단거리 배열 생성
        dist = new int[v+1];
//     시작점부터 i까지의 가중치 값을 배열에 채우는 과정
        dijk(k);

//        1부터 v까지 만약 INF면 갈수 없는 정점 아니면 sb에 저장 
        for(int i =1; i<= v; i++) {
            if(dist[i] == INF) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }
}
