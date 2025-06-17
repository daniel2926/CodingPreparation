import java.util.Scanner;

public class PetakMenarik {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int column = input.nextInt();;
        int K = input.nextInt();


        int [][] arr = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        int resultRow = 0;
        int resultColumn = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++){
                int resultMultiply = 1;
                int kanan,kiri,atas,bawah;
                if (i - 1 >= 0){
                    atas =arr[i - 1][j];
                    resultMultiply *= atas;
                }
                if (i + 1 < arr.length){
                    bawah = arr[i + 1][j];
                    resultMultiply *= bawah;
                }
                if (j - 1 >= 0){
                    kiri = arr[i][j - 1];
                    resultMultiply *= kiri;
                }
                if (j + 1 < arr[0].length){
                    kanan = arr[i][j + 1];
                    resultMultiply *= kanan;
                }

                if(K == resultMultiply){
                    if (resultRow == 0 || j + 1 < resultColumn || (j + 1 == resultColumn && i + 1 < resultRow)){
                        resultRow = i + 1;
                        resultColumn = j + 1;
                    }
                }
            }
        }
        if(resultRow == 0){
            System.out.println("0 0");
        }
        else
            System.out.println(resultRow + " " + resultColumn);
    }
}
