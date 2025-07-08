import java.util.Scanner;

public class PermainanBatu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long n = input.nextLong();
        long k = input.nextLong();
        long m = input.nextLong();

        if (m % 2 == 0) {
            System.out.println("Kedua");
        } else {
            long a = n - 1;
            long b = n - k - 1;
            long xor = xorTo(a) ^ xorTo(b);
            System.out.println(xor == 0 ? "Kedua" : "Pertama");
        }
    }

    static long xorTo(long x) {
        int mod = (int)(x % 4);
        if (mod == 0) return x;
        if (mod == 1) return 1;
        if (mod == 2) return x + 1;
        return 0;
    }
}
