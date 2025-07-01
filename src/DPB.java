import java.io.*;
import java.util.*;

public class DPB {
    static class Pair implements Comparable<Pair> {
        int ego, index;
        Pair(int ego, int index) {
            this.ego = ego;
            this.index = index;
        }
        public int compareTo(Pair o) {
            return Integer.compare(this.ego, o.ego);
        }
    }

    public static void main(String[] args) throws IOException {
        // Fast IO
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Pair[] bebek = new Pair[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bebek[i] = new Pair(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(bebek); // sort berdasarkan ego

        int[] maxSize = new int[n];
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (bebek[right].ego - bebek[left].ego > p) {
                left++;
            }
            int size = right - left + 1;
            for (int i = left; i <= right; i++) {
                maxSize[bebek[i].index] = Math.max(maxSize[bebek[i].index], size);
            }
        }

        // Jawab query dengan BufferedWriter (cepat)
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(br.readLine());
            bw.write(maxSize[x - 1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
