import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Banjir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        input.nextLine();

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int N = input.nextInt();
            int M = input.nextInt();
            input.nextLine();

            char[][] matrix = new char[N][M];
            boolean[][] visited = new boolean[N][M];

            for (int j = 0; j < N; j++) {
                String line = input.nextLine();
                while (line.length() < M) line += " ";
                matrix[j] = line.toCharArray();
            }

            // BFS mulai dari spasi yang berada di tepi grid
            Queue<int[]> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if ((j == 0 || j == N - 1 || k == 0 || k == M - 1) && matrix[j][k] == ' ') {
                        queue.add(new int[]{j, k});
                        visited[j][k] = true;
                    }
                }
            }

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (!visited[nx][ny] && matrix[nx][ny] == ' ') {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }

            boolean status = false;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (matrix[j][k] == ' ' && !visited[j][k]) {
                        status = true;
                        break;
                    }
                }
            }

            if (status) {
                result.add("YA");
            } else {
                result.add("TIDAK");
            }
        }

        for (String r : result) {
            System.out.println(r);
        }
    }
}
