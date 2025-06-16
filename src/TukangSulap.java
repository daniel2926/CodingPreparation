import java.util.Scanner;

public class TukangSulap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] arr = new int[2][1001]; 

        int kolomDiisi = input.nextInt();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < kolomDiisi; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            String P1 = input.next();
            int x = input.nextInt();
            String P2 = input.next();
            int y = input.nextInt();

            int positionA = P1.charAt(0) - 'A';
            int positionB = P2.charAt(0) - 'A';

            x--;
            y--;

            int temp = arr[positionA][x];
            arr[positionA][x]= arr[positionB][y];
            arr[positionB][y] = temp;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < kolomDiisi; j++) {
                System.out.print(arr[i][j]);
                if (j + 1 < kolomDiisi) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
