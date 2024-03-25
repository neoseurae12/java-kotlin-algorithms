package Programmers;

import java.util.HashMap;

public class P12919_KimInSeoulJ {
    public String solution(String[] seoul) {
        for(int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                return "김서방은 " + i + "에 있다";
            }
        }
        return "이게 출력되어서는 안 된다";  // 문제 조건상, 이게 출력되어서는 안 된다
    }
}
