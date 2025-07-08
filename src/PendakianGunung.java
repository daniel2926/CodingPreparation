import java.util.*;

public class PendakianGunung {
    static class Edge {
        int to;
        Edge(int to) { this.to = to; }
    }

    static class State implements Comparable<State> {
        int node;
        long cost;
        State(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }
        public int compareTo(State o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static int N, M;
    static int[] H;
    static ArrayList<Edge>[] adj;
    static final long INF = Long.MAX_VALUE / 2;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        H = new int[N + 1]; // 1-based
        for (int i = 1; i <= N; i++) H[i] = sc.nextInt();

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj[u].add(new Edge(v));
            adj[v].add(new Edge(u));
        }

        // Jalankan Dijkstra sekali dari node 1
        long[] dist = new long[N + 1];
        parent = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(1, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.cost > dist[cur.node]) continue;
            for (Edge e : adj[cur.node]) {
                long cost = Math.abs(H[cur.node] - H[e.to]);
                if (dist[e.to] > dist[cur.node] + cost) {
                    dist[e.to] = dist[cur.node] + cost;
                    parent[e.to] = cur.node;
                    pq.add(new State(e.to, dist[e.to]));
                }
            }
        }

        for (int day = 1; day <= N; day++) {
            if (dist[day] == INF) {
                System.out.println(-1);
                continue;
            }

            // Rekonstruksi path dari 1 ke day
            List<Integer> path = new ArrayList<>();
            int cur = day;
            while (cur != 0) {
                path.add(cur);
                cur = parent[cur];
            }
            Collections.reverse(path);

            // Array A = ketinggian pada path
            int p = path.size();
            int[] A = new int[p];
            for (int i = 0; i < p; i++) {
                A[i] = H[path.get(i)];
            }

            // Base fatigue
            long base = 0;
            for (int i = 1; i < p; i++) {
                base += Math.abs(A[i] - A[i - 1]);
            }
            long best = base;

            // Modifikasi satu titik dan hitung ulang dua segmen
            for (int i = 0; i < p; i++) {
                int original = A[i];
                for (int j = 0; j < p; j++) {
                    if (A[j] == original) continue;

                    int changed = A[j];
                    long delta = 0;
                    if (i > 0) delta -= Math.abs(A[i] - A[i - 1]);
                    if (i < p - 1) delta -= Math.abs(A[i + 1] - A[i]);
                    if (i > 0) delta += Math.abs(changed - A[i - 1]);
                    if (i < p - 1) delta += Math.abs(A[i + 1] - changed);

                    best = Math.min(best, base + delta);
                }
            }

            System.out.println(best);
        }
    }
}
