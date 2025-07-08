import java.util.Scanner;

public class Ubin {
    static final long MOD = (long)1e9 + 7;

    static long[][] mul(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    c[i][k] = (c[i][k] + a[i][j] * b[j][k]) % MOD;
                }
            }
        }
        return c;
    }

    static long modex(long n) {
        long[][] res = {{1, 0}, {0, 1}};
        long[][] a = {{1, 1}, {1, 0}};
        while (n > 0) {
            if ((n & 1) == 1) res = mul(res, a);
            a = mul(a, a);
            n >>= 1;
        }
        return res[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = 2;
        long ans = modex(n);
        System.out.println((ans * ans) % MOD);
    }
}
