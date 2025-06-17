import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Banjir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        ArrayList<String> result = new ArrayList<String>();
        boolean status = false;
        input.nextLine();

        for (int i = 0; i < T; i++) {
            System.out.println("Input N: ");
            int N = input.nextInt();
            System.out.println("Input M: ");
            int M = input.nextInt();
            input.nextLine();
            for (int j = 0; j < N; j++) {
                String [] arr = new String[M];
                String pagar = input.nextLine();
                arr[j] = pagar;
                if(j == 0 && j == N - 1) {
                    if (!arr[j].isBlank()) {
                        status = true;
                    }
                }
            }
            if(status){
                result.add("IYA");
            }
            else
            {
                result.add("TIDAK");
            }
        }
        for(String print : result){
            System.out.println(print);
        }

    }
}
