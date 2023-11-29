import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        while (i >= 0){
            System.out.println(i);
            i-=1;
        }
    }
}

