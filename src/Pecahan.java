import java.util.Scanner;

public class Pecahan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long a = input.nextInt();
        long b = input.nextInt();
        long c = input.nextInt();
        long d = input.nextInt();

        if ((a * d) > (b * c)){
            System.out.println("lebih besar");
        }else if( (a * d) < (b * c)){
            System.out.println("lebih kecil");
        }else
            System.out.println("sama");
    }
}
