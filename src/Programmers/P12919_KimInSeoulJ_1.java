package Programmers;

import java.util.HashMap;

public class P12919_KimInSeoulJ_1 {
    public String solution(String[] seoul) {
        // HashMap을 사용한 시간복잡도 최적화
            // HashMap => 삽입, 삭제, 조회의 시간복잡도가 모두 O(1) 이다.
        HashMap<String, Integer> seoulWithIndex = new HashMap<>();
        for (int i = 0; i < seoul.length; i++) {
            seoulWithIndex.put(seoul[i], i);
        }
        String kimsLocation = seoulWithIndex.get("Kim").toString();
        return "김서방은 " + kimsLocation + "에 있다";
    }
}
