import java.util.Arrays;class Solution {

        public long solution(int n, int[] times) {
int[] arr = new int[times.length];
        arr= times.clone();
            Arrays.sort(arr);
            long s = 0;
            long e = (long) arr[times.length - 1] * n;

            long answer = -1;
            while (s<=e) {
//                mid는 심사 시간 기준값
                long mid = (s+e) / 2;
//               total은 시간내에 심사가능한 사람 수
                long total = 0;
                for(int i=0; i<arr.length; i++) {
                    total += mid/arr[i];
                    if(total>=n) break;
                }
                if(total < n) {
                    s = mid +1;
                } else if (total >= n) {
                    answer = mid;
                    e  = mid -1;
                }
            }
            return answer;


        }
    }