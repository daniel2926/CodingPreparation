import java.util.Scanner;

public class PetakMenarik {
    public static void main(String[] args) {



        int[][] arr = new int[2][2];
        arr[0][0] = 3;
        arr[0][1] = 1;
        arr[1][0] = 1;
        arr[1][1] = 2;
        int resultMultiply = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++){
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
                System.out.println(resultMultiply);
            }
        }
    }
}
