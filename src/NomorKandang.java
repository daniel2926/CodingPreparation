import java.util.*;

public class NomorKandang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] harga = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            harga[i] = sc.nextInt();
        }

        int M = sc.nextInt();

        // Cari digit termurah
        int digitTermurah = 0;
        int hargaTermurah = harga[0];
        for (int i = 1; i <= N; i++) {
            if (harga[i] <= hargaTermurah) {
                hargaTermurah = harga[i];
                digitTermurah = i;
            }
        }

        // Hitung berapa banyak pelat yang bisa dibeli
        int banyakPelat = M / hargaTermurah;
        if (banyakPelat == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder nomor = new StringBuilder();
        int sisaUang = M;

        // Susun digit paling besar di depan sebanyak mungkin
        for (int i = 0; i < banyakPelat; i++) {
            for (int d = N; d >= 0; d--) {
                if (sisaUang - harga[d] >= (banyakPelat - i - 1) * hargaTermurah && harga[d] <= sisaUang) {
                    nomor.append(d);
                    sisaUang -= harga[d];
                    break;
                }
            }
        }

        System.out.println(nomor.length());

        if (nomor.length() <= 50) {
            System.out.println(nomor);
            System.out.println(nomor);
        } else {
            System.out.println(nomor.substring(0, 50));
            System.out.println(nomor.substring(nomor.length() - 50));
        }
    }
}
