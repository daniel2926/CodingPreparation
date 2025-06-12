import java.util.LinkedHashSet;
import java.util.Scanner;

public class MembuangPerulangan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedHashSet<Integer> data = new LinkedHashSet<>();
        int size = input.nextInt();
        for (int i = 0; i < size; i++) {
            int number = input.nextInt();
            data.add(number);
        }
        for(int result : data){
            System.out.println(result);
        }
    }
}

