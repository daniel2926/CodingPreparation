import java.util.Scanner;

public class MengurutkanKarakter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        String word1 = input.next();
        String word2 = input.next();

        char[] A = word1.toCharArray();
        char[] B = word2.toCharArray();

        int op = 0;
        int i = 0;

        while (i < N) {
            if (A[i] > B[i]) {
                int r = i;
                while (r < N && A[r] >= B[r]) {
                    if (B[r] > A[r]) break;
                    r++;
                }
                op++;
                i = r;
            } else {
                i++;
            }
        }

        System.out.println(op);
    }
}
