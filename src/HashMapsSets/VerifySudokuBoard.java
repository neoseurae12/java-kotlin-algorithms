package HashMapsSets;

/*
- Hash Set
    - Hash Map 의 간단한 형태
    - key 들만 저장한다.
    - 주요 시나리오
        - unique 한 요소들 저장하기
        - '사용됨' 또는 '방문함'으로 요소들 표시하기
        - 중복 체크하기
- 문제의 주요 목표: 행, 열, 서브 그리드 내 중복 확인하기
    - 관건 1: 중복 확인하기 => Hash Set 사용
        - 행, 열, 서브 그리드의 Hash Set 내에 이미 숫자가 존재한다면 => duplicate 존재 => false 반환
        - Hash Set 내에 숫자가 없다면 => 해당하는 행, 열, 서브 그리드의 Hash Set 에 새로 추가해주기
    - 관건 2: 특정 칸에 해당하는 행 & 열 지정하기 => 인덱스 사용
    - 관건 3: 서브 그래드 지정하기 => adjusted index 사용
        - '9*9 그리드 -> 3*3 그리드'로 축소 및 응집시킨다.
        - 3으로 나누면 (0, 1, 2) / (3, 4, 5) / (6, 7, 8) 이렇게 크게 3묶음으로 축소 및 응집되게 된다.
- 풀이 방식에 따른 시간 및 공간 복잡도의 차이
    - linear search 방식으로 풀이할 경우 => 중복을 확인하는 데만 O(N^2)
    - Hash Set 방식으로 풀이할 경우
        - 시간 복잡도
            - 중복을 확인하는 데만 O(1)
            - 총 O(N^2)
        - 공간 복잡도
            - O(N^2)
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VerifySudokuBoard {
    public static final int BOARD_SIZE = 9;
    public static final int GRID_SIZE = 3;

    public static boolean verifySudokuBoard(int[][] board) {
        List<Set<Integer>> rowSets = new ArrayList<>(BOARD_SIZE);
        List<Set<Integer>> columnSets = new ArrayList<>(BOARD_SIZE);
        List<List<Set<Integer>>> subgridSets = new ArrayList<>(GRID_SIZE);

        for (int i = 0; i < BOARD_SIZE; i++) {
            rowSets.add(new HashSet<>());
            columnSets.add(new HashSet<>());
        }

        for (int i = 0; i < GRID_SIZE; i++) {
            List<Set<Integer>> subgridRow = new ArrayList<>(GRID_SIZE);
            for (int j = 0; j < GRID_SIZE; j++)
                subgridRow.add(new HashSet<>());
            subgridSets.add(subgridRow);
        }

        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                int num = board[r][c];

                if (num == 0)
                    continue;

                if (rowSets.get(r).contains(num) ||
                    columnSets.get(c).contains(num) ||
                    subgridSets.get(r / 3).get(c / 3).contains(num))
                    return false;

                rowSets.get(r).add(num);
                columnSets.get(c).add(num);
                subgridSets.get(r / 3).get(c / 3).add(num);
            }
        }

        return true;
    }
}
