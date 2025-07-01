
import java.util.Scanner;

public class LampuHias_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int p = input.nextInt();
        int q = input.nextInt();
        int r = input.nextInt();

        int N = input.nextInt();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            long timeQuestion = input.nextLong();

            if(timeQuestion % p == 0 && timeQuestion % q == 0 && timeQuestion % r == 0){
                builder.append("YA\n");
            }else
                builder.append("TIDAK\n");
        }

        System.out.println(builder);
    }
}



