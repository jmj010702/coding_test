class Solution {
    public int solution(String A, String B) {
        // A와 B가 이미 같으면 0 반환
        if(A.equals(B)) {
            return 0;
        }
        
        // A를 왼쪽으로 밀기 (오른쪽으로 회전)
        String temp = A;
        for(int i = 1; i < A.length(); i++) {
            // 맨 뒤 문자를 맨 앞으로 이동
            temp = temp.charAt(temp.length() - 1) + temp.substring(0, temp.length() - 1);
            
            if(temp.equals(B)) {
                return i;
            }
        }
        
        // A를 아무리 밀어도 B가 될 수 없음
        return -1;
    }
}