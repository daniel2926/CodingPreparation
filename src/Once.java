import java.util.Scanner;

public class Once {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       int [] cards = new int[n];
        for (int i = 0; i < n; i++) {
          cards[i] = sc.nextInt();
        }
        long [] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
          prefix[i + 1] = prefix[i] + cards[i];
        }
        long max = prefix[n];
        for (int j = 1; j <= n ; j++) {
            long result = prefix[j - 1] * cards[j - 1] + (prefix[n] - prefix[j]);
            max = Math.max(max,result);
        }
        System.out.println(max);
    }
}
