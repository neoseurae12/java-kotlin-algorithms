package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Artistry {
    static final int ROTATION_NUM = 4;
    static final int DIRECTION_NUM = 4;

    static int n;
    static int[][] image;
    static boolean[][] visited;
    static List<Set<int[]>> groups;
    static List<Integer> groupValues;
    // 상-우-하-좌
    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        n = Integer.parseInt(br.readLine());

        image = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                image[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 로직 처리
        int totalScore = 0;

        // 0~3회전마다의 예술 점수의 합 구하기
        for (int i = 0; i < ROTATION_NUM; i++) {
            totalScore += getArtistryScore();
            rotateImage();
        }

        // 출력
        System.out.println(totalScore);
    }

    static int getArtistryScore() {
        int artistryScore = 0;

        visited = new boolean[n][n];
        groups = new ArrayList<>();
        groupValues = new ArrayList<>();

        // 그룹 나누기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    groups.add(new HashSet<>());
                    groupValues.add(image[i][j]);

                    bfs(i, j);
                }
            }
        }

        // 예술 점수 구하기; 모든 그룹 쌍의 조화로움의 합
        int groupSize = groupValues.size();
        for (int a = 0; a < groupSize - 1; a++) {
            for (int b = a + 1; b < groupSize; b++) {
                Set<int[]> groupA = groups.get(a);
                Set<int[]> groupB = groups.get(b);
                int groupANum = groupValues.get(a);
                int groupBNum = groupValues.get(b);
                // 그룹 a와 그룹 b가 서로 맞닿아 있는 변의 수 구하기
                int borders = countBorders(groupA, groupB);

                int score = (groupA.size() + groupB.size()) * groupANum * groupBNum * borders;

                artistryScore += score;
            }
        }

        // 예술 점수 반환
        return artistryScore;
    }

    static int countBorders(Set<int[]> groupA, Set<int[]> groupB) {
        int borderCnt = 0;

        for (int[] pixelA : groupA) {
            for (int d = 0; d < DIRECTION_NUM; d++) {
                int r = pixelA[0] + dr[d];
                int c = pixelA[1] + dc[d];

                if (r >= 0 && r < n && c >= 0 && c < n) {
                    for (int[] pixelB : groupB) {
                        if (pixelB[0] == r && pixelB[1] == c)
                            borderCnt++;
                    }
                }
            }
        }

        return borderCnt;
    }

    static void bfs(int si, int sj) {
        Queue<int[]> q = new ArrayDeque<>();
        int[] firstPixel = new int[] {si, sj};
        q.offer(firstPixel);
        Set<int[]> group = groups.get(groups.size() - 1);
        group.add(firstPixel);
        visited[si][sj] = true;
        int groupValue = image[si][sj];

        // 큐에서 빼면서 => 방문 처리, 같은 그룹에 넣어주기
        while (!q.isEmpty()) {
            int[] pixel = q.poll();

            // 상하좌우 확인 => 같은 그룹에 속해야 하는 애들 큐에다 넣어주기
            for (int d = 0; d < DIRECTION_NUM; d++) {
                int r = pixel[0] + dr[d];
                int c = pixel[1] + dc[d];
                if (r >= 0 && r < n && c >= 0 && c < n && !visited[r][c] && image[r][c] == groupValue) {
                    int[] pixelInSameGroup = new int[] {r, c};
                    q.offer(pixelInSameGroup);
                    group.add(pixelInSameGroup);
                    visited[r][c] = true;
                }
            }
        }
    }

    static void rotateImage() {
        int[][] rotatedImage = new int[n][n];
        int m = n / 2;

        // 십자 모양 => 반시계 90도 회전
        for (int i = 0; i < n; i++) {
            rotatedImage[m][i] = image[i][m];
            rotatedImage[n - i - 1][m] = image[m][i];
        }

        // 4개의 정사각형 => 개별 시계 90도 회전
        int[][] starts = new int[][] {{0, 0}, {0, m + 1}, {m + 1, 0}, {m + 1, m + 1}};
        for (int[] start : starts) {
            int si = start[0];
            int sj = start[1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    rotatedImage[si + i][sj + j] = image[si + m - j - 1][sj + i];
                }
            }
        }

        // image 업데이트
        image = rotatedImage;
    }
}
