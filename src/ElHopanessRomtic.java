import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ElHopanessRomtic {
    public static void main(String[] args) {
//        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Scanner input1 = new Scanner(System.in);

        int n = input1.nextInt();
        int m = input1.nextInt();
        int l = input1.nextInt();
        int r = input1.nextInt();

        String [] text = new String[n];
        for (int i = 0; i < n ; i++) {
            text[i] = input1.next();
        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < m; i++) {
            if(i >= l - 1 && i <= r - 1){
                builder.append(text[0].charAt(i));
            }else
                builder.append("*");
        }
        System.out.println(builder);

        StringBuilder builder1 = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if( l -1 <= j && r -1 >= j){
                    if(i + 1 < n){
                        builder1.append(text[i + 1].charAt(j));
                    }
                    else
                        builder1.append("*");
                }
                else
                    builder1.append(text[i].charAt(j));
            }
            builder1.append("\n");
        }
        System.out.println(builder1);
    }

    }
