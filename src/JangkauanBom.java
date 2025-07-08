import java.io.*;
import java.util.*;

public class JangkauanBom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int xc = Integer.parseInt(st.nextToken());
        int yc = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        long[] jarak = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            long dx = x - xc;
            long dy = y - yc;

            jarak[i] = dx * dx + dy * dy;
        }

        Arrays.sort(jarak);

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            int r = Integer.parseInt(br.readLine());
            long r2 = (long) r * r;

            int count = upperBound(jarak, r2);
            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }

    static int upperBound(long[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
