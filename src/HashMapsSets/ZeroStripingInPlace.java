package HashMapsSets;

/*
- 'ZeroStriping - Hash Set 버전'에서 "공간복잡도"를 더 개선한 버전
    - Hash Set 으로 인한 추가 공간을 없애고, 대신 matrix 자체를 'marker'로 활용
    - marker (첫 번째 행 & 첫 번째 열) & sub-matrix
    - marker 에 대한 flag
        - marker 로 쓰일 첫 번째 행/열이 본래부터 0을 가진 행/열은 아니었나 미리 체크 필요
        - true 일 경우 => marker 로 사용 -> 첫 번째 행/열도 모두 0 변환 처리
        - false 일 경우 => marker 로 사용
- ZeroStriping - In-place
    - 1. flag 체크
    - 2. sub-matrix 에 대한 0 존재 여부를 marker 에 반영
    - 3. marker 를 토대로 sub-matrix 에서 0 변환 처리
    - 4. flag 처리
- '기록' 후에 '0 변환 처리'가 이루어져야 한다.
    - '기록'과 '0 변환 처리'가 동시에 이루어지게 되면 원래 0이었는지 변환되어 0이 된 것인지 구분하지 못하게 됨
 */

public class ZeroStripingInPlace {
    public static int[][] mMatrix;

    public static void zeroStriping(int[][] matrix) {
        mMatrix = matrix;

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        // 첫 row 및 column 에 원래부터 0이 존재했는지 체크
            // 없다면 => marker 로서만 역할
            // 있다면 => marker 로서 역할 후 해당 row 및 column 도 전체 0 변환 처리
        boolean firstColHasZero = false;
        for (int[] rows : matrix) {
            if (rows[0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        boolean firstRowHasZero = false;
        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // submatrix 돌면서 0 있다면 marker(첫 row 및 column)에 기록
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // marker 에 0 으로 기록되어있는 row 및 column 전체 0 변환 처리
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0)
                    matrix[r][c] = 0;
            }
        }

        // 아까 첫 row 및 column 에 원래부터 0 존재했는지 여부에 따라 marker 도 0 변환 처리
        if (firstRowHasZero)
            for (int c = 0; c < n; c++)
                matrix[0][c] = 0;

        if (firstColHasZero)
            for (int r = 0; r < m; r++)
                matrix[r][0] = 0;
    }
}
