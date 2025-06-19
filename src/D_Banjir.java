import java.util.*;

public class D_Banjir {
    static int n, m;
    static char[][] grid;
    static boolean[][] visited;

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && grid[i][j] == ' ') {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && grid[nx][ny] == ' ') {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static boolean hasSafeZone() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == ' ' && !visited[i][j])
                    return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < T; t++) {
            String[] dims = sc.nextLine().split(" ");
            n = Integer.parseInt(dims[0]);
            m = Integer.parseInt(dims[1]);

            grid = new char[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < n; j++) {
                String line = sc.nextLine();
                while (line.length() < m) line += " ";
                grid[j] = line.toCharArray();
            }

            bfs();

            System.out.println(hasSafeZone() ? "YA" : "TIDAK");
        }
    }
}
