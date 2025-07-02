import java.util.*;
import java.math.BigInteger;

public class ManipulasiDigit {
    static BigInteger pw10(int exp) {
        return BigInteger.TEN.pow(exp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();

        List<long[]> dig = new ArrayList<>();
        int maxLen = 0;

        List<String> nums = new ArrayList<>();
        for (long i = 0; i < n; ++i) {
            String num = sc.next();
            nums.add(num);
            maxLen = Math.max(maxLen, num.length());
        }

        for (int i = 0; i < maxLen; i++) dig.add(new long[10]);

        // isi frekuensi digit per posisi
        for (String num : nums) {
            int len = num.length();
            for (int idx = 0; idx < len; ++idx) {
                int d = num.charAt(len - 1 - idx) - '0';
                dig.get(idx)[d]++;
            }
        }

        // optimasi: upgrade bulk digit dari besar ke kecil
        for (int i = dig.size() - 1; i >= 0 && k > 0; --i) {
            for (int j = 8; j >= 0 && k > 0; --j) {
                long cnt = dig.get(i)[j];
                if (cnt == 0) continue;

                int stepsTo9 = 9 - j;
                long maxUpgrade = cnt * stepsTo9;

                if (maxUpgrade <= k) {
                    dig.get(i)[j] -= cnt;
                    dig.get(i)[9] += cnt;
                    k -= maxUpgrade;
                } else {
                    long canStep = k / cnt;
                    if (canStep > 0) {
                        int newDigit = j + (int) canStep;
                        dig.get(i)[j] -= cnt;
                        dig.get(i)[newDigit] += cnt;
                        k -= canStep * cnt;
                        j = newDigit - 1; // lanjutan upgrade
                    }
                    long remain = Math.min(k, cnt);
                    if (remain > 0) {
                        dig.get(i)[j] -= remain;
                        dig.get(i)[j + 1] += remain;
                        k -= remain;
                    }
                }
            }
        }

        // fallback jika masih sisa k: putar satu digit saja, aman
        if (k > 0) {
            k %= 10; // cukup k kecil agar tidak overflow index
            outer:
            for (long[] longs : dig) {
                for (int j = 0; j < 10; ++j) {
                    if (longs[j] == 0) continue;
                    longs[j]--;
                    longs[(j + (int) k) % 10]++;
                    break outer;
                }
            }
        }

        // hitung hasil akhir
        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < dig.size(); ++i) {
            for (int j = 1; j < 10; ++j) {
                BigInteger contrib = BigInteger.valueOf(dig.get(i)[j])
                        .multiply(BigInteger.valueOf(j))
                        .multiply(pw10(i));
                ans = ans.add(contrib);
            }
        }

        System.out.println(ans);
    }
}
