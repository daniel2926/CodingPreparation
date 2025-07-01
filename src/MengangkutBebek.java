import java.util.*;

public class MengangkutBebek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int[][] kandang = new int[K][2];

        for (int i = 0; i < K; i++) {
            kandang[i][1] = scanner.nextInt();
        }
        for (int i = 0; i < K; i++) {
            kandang[i][0] = scanner.nextInt();
        }

        Arrays.sort(kandang, Comparator.comparingInt(a -> a[0]));

        int N = scanner.nextInt();
        int[] bebek = new int[N];
        for (int i = 0; i < N; i++) {
            bebek[i] = scanner.nextInt();
        }

        Arrays.sort(bebek);
        System.out.println(Arrays.toString(bebek));

        long total = 0;
        int idx = N - 1;

        for (int i = 0; i < K; i++) {
            int kapasitas = kandang[i][1];
            int harga = kandang[i][0];

            for (int j = 0; j < kapasitas && idx >= 0; j++) {
                total += (long) bebek[idx] * harga;
                idx--;
            }
        }

        System.out.println(total);
    }
}
