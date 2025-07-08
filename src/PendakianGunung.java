

import java.util.*;

public class PendakianGunung {
    static class Edge {
        int to;
        Edge(int to) { this.to = to; }
    }

    static int N, M;
    static int[] H;
    static ArrayList<Edge>[] adj;

    static final long INF = Long.MAX_VALUE / 2;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        N = sc.nextInt();
        M = sc.nextInt();
        H = new int[N+1]; // 1-based

        for (int i=1; i<=N; i++) H[i]=sc.nextInt();

        adj = new ArrayList[N+1];
        for (int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        for (int i=0; i<M; i++) {
            int u=sc.nextInt(), v=sc.nextInt();
            adj[u].add(new Edge(v));
            adj[v].add(new Edge(u));
        }

        for (int day=1; day<=N; day++) {
            long res = solve(1, day);
            System.out.println(res);
        }
    }

    static long solve(int start, int end) {
        parent = new int[N+1];
        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);
        PriorityQueue<State> pq = new PriorityQueue<>();

        dist[start]=0;
        pq.add(new State(start,0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.cost > dist[cur.node]) continue;

            for (Edge e: adj[cur.node]) {
                long addCost = Math.abs(H[cur.node]-H[e.to]);
                if (dist[e.to] > cur.cost + addCost) {
                    dist[e.to] = cur.cost + addCost;
                    parent[e.to]=cur.node; // save parent to recover path
                    pq.add(new State(e.to, dist[e.to]));
                }
            }
        }

        if (dist[end]==INF) return -1; // unreachable

        ArrayList<Integer> path=new ArrayList<>();
        int cur=end;
        while (cur!=start) {
            path.add(cur);
            cur=parent[cur];
        }
        path.add(start);
        Collections.reverse(path);

        long minFatigue=calcFatigue(path,H);

        for (int node : path) {
            for (int tvalNode : path) {
                int[] Hcopy=H.clone();
                Hcopy[node]=H[tvalNode];
                long tmp=calcFatigue(path,Hcopy);
                minFatigue=Math.min(minFatigue,tmp);
            }
        }
        return minFatigue;
    }

    static long calcFatigue(ArrayList<Integer> path, int[] Htmp) {
        long total=0;
        for (int i=1;i<path.size();i++) {
            total+=Math.abs(Htmp[path.get(i-1)]-Htmp[path.get(i)]);
        }
        return total;
    }

    static class State implements Comparable<State> {
        int node;
        long cost;
        State(int node, long cost) { this.node=node; this.cost=cost; }
        public int compareTo(State o) { return Long.compare(this.cost, o.cost);}
}
}
