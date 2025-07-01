import java.util.Scanner;

public class SatuKaliSatu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        long max = prefix[n];

        for (int i = 1; i <= n; i++) {
            long sumLeft = prefix[i - 1];
            long sumRight = prefix[n] - prefix[i];
            long result = sumLeft * arr[i - 1] + sumRight;
            if (result > max) {
                max = result;
            }
        }
        System.out.println(max);
    }
}
