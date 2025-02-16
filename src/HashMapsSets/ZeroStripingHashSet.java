package HashMapsSets;

/*
- Hash Set 버전
- 핵심 사항
    - 어떤 cell 이 0을 포함하고 있는 row 및 column 에 있다면, 해당 cell 도 0이 된다.
- 풀이 방식에 따른 시간 및 공간 복잡도의 차이
    - 브루트 포스 방식일 경우
        - 0인 cell 들의 position 을 다 기록해놓고, 각 cell 마다의 그 row 와 column 의 모든 cell 을 0으로 변환 처리
        - 시간복잡도: O(M * N * (M + N)) -- 최악의 경우: 애초부터 matrix 의 거의 모든 cell 들이 0으로 차있었을 경우
    - Hash Set 방식일 경우
        - 1. m * n 크기의 matrix 쭉 돌면서, Hash Set 에 0이 포함된 row 및 column 의 인덱스 기록
        - 2. 0이 포함되어있다고 기록된 row 및 column 의 모든 칸을 0으로 전환
        - 시간복잡도: O(M * N)
        - 공간복잡도: O(M + N) -- row 및 column 각각에 대한 Hash Set 때문에 cost of extra space 발생
    - In-place 방식일 경우 -- ZeroStripingInPlace.java 파일 참고
        - Hash Set 으로 인한 추가 공간을 없애고, 대신 matrix 자체를 'marker'로 활용
        - 시간복잡도: O(M * N) = O(M) (row 에 대한 flag 체크) + O(N) (column 에 대한 flag 체크) + O(M * N) (0 기록) + O(M * N) (0 변환)
        - 공간복잡도: O(1) -- 공간복잡도가 최적화 됨
 */

import java.util.HashSet;
import java.util.Set;

public class ZeroStripingHashSet {
    public static int[][] mMatrix;

    public static void zeroStriping(int[][] matrix) {
        mMatrix = matrix;

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroColumns = new HashSet<>();

        // Pass 1: m * n 크기의 matrix 쭉 돌면서, Hash Set 에 0이 포함된 row 및 column 의 인덱스 기록
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    zeroRows.add(r);
                    zeroColumns.add(c);
                }
            }
        }

        // Pass 2: 0이 포함되어있다고 기록된 row 및 column 의 모든 칸을 0으로 전환
        for (int r = 0; r < m; r++)
            for (int c = 0; c < n; c++)
                if (zeroRows.contains(r) || zeroColumns.contains(c))
                    matrix[r][c] = 0;
    }
}
