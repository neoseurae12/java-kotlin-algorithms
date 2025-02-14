package HashMapsSets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerifySudokuBoardTest {
    @Test
    void testVerifySudokuBoardTest() {
        assertFalse(VerifySudokuBoard.verifySudokuBoard(new int[][] {
                {3, 0, 6, 0, 5, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {1, 0, 2, 5, 0, 0, 3, 2, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {0, 3, 0, 0, 0, 8, 2, 5, 0},
                {0, 1, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 0, 0, 0},
            }
        ));
    }
}