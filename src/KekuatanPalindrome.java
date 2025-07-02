import java.util.*;

public class KekuatanPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        String S = scanner.next();

        int[] pref = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int c = S.charAt(i - 1) - 'a';
            pref[i] = pref[i - 1] ^ (1 << c);
        }

        int[][] cum = new int[N + 1][];
        for (int d = 1; d <= N; d++) {
            int cnt = (N + d - 1) / d;
            cum[d] = new int[cnt + 1];

            for (int j = 0; j < cnt; j++) {
                int l = j * d + 1;
                int r = Math.min(l + d - 1, N);

                int mask = pref[r] ^ pref[l - 1];
                boolean valid = (mask & (mask - 1)) == 0;
                cum[d][j + 1] = cum[d][j] + (valid ? 1 : 0);
            }
        }

        int[] ans = new int[N + 1];
        for (int L = 1; L <= N; L++) {
            int best = L;

            for (int i = 1; i * i <= L; i++) {
                if (L % i == 0) {
                    int k1 = i, d1 = L / i;
                    if (d1 <= N && cum[d1][L / d1] == L / d1)
                        best = Math.min(best, k1);

                    if (i != L / i) {
                        int k2 = L / i, d2 = i;
                        if (d2 <= N && cum[d2][L / d2] == L / d2)
                            best = Math.min(best, k2);
                    }
                }
            }

            ans[L] = best;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append(i == N ? '\n' : ' ');
        }
        System.out.print(sb);

    }
}
