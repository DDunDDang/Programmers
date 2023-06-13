import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 사용자 정보가 id_list에 존재

        // 0. 사용자별로 신고당한 횟수를 기록하는 자료 생성: reported[user] = 0
        // 1. report를 순회하면서 아래 작업을 수행
        // 1.0. 신고자와 신고당한 자를 구분: src -> dst
        // 1.1. 각 유저별로 신고한 사람을 기록: reporter[src] = Set("dst")
        // 1.2. 각 유저별로 신고당한 횟수를 기록: reported[dst] = reported[dst] + 1
        // 1.2.1. 이 때 각 동일한 사람에게 신고한 경우 횟수를 업데이트 하지 않는다.

        Map<String, Integer> reported = new HashMap<>();
        Map<String, Set<String>> reporter = new HashMap<>();
        
        // 초기화
        for (String id : id_list) {
            reported.put(id, 0);
            reporter.put(id, new HashSet<>());
        }
        
        // 각 유저별 신고한 유저 정보 기록
        for (String r : report) {
            String[] s = r.split(" ");
            String src = s[0];
            String dst = s[1];
            
            if (!reporter.get(src).contains(dst)) {
                reported.put(dst, reported.get(dst) + 1);
                reporter.get(src).add(dst);
            }
        }
        
        // 각 유저별 신고당한 횟수가 k 이상인 유저 수 카운팅
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            int count = 0;
            for (String r : reporter.get(id)) {
                if (reported.get(r) >= k) {
                    count++;
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
}