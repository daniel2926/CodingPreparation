import java.util.Arrays;
import java.util.Scanner;

public class LampuHias {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int p = input.nextInt();
        int q = input.nextInt();
        int r= input.nextInt();

        int sizeQuestion = input.nextInt();
        int [] arr = new int[sizeQuestion];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
        int putaran;

        if(p > q && p > r){
            putaran = p;
        } else if (q > p && q > r) {
            putaran = q;
        }
        else
            putaran = r;

        int resultTime = 0;

        for (int i = 1; i <= putaran; i++) {
            int pTime = p * i;
            int qTime = q * i;
            int rTime = r * i;

            if ((pTime % p == 0 && pTime % q == 0 && pTime % r == 0) && Arrays.stream(arr).anyMatch(x -> x == pTime)) {
                resultTime = pTime;
                break;
            } else if ((qTime % p == 0 && qTime % q == 0 && qTime % r == 0) && Arrays.stream(arr).anyMatch(x -> x == qTime)) {
                resultTime = qTime;
                break;
            } else if ((rTime % p == 0 && rTime % q == 0 && rTime % r == 0) && Arrays.stream(arr).anyMatch(x -> x == rTime)) {
                resultTime = rTime;
                break;
            } else {
                resultTime = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(resultTime == arr[i]){
                System.out.println("YA");
            }
            else
                System.out.println("TIDAK");
        }
    }

}
