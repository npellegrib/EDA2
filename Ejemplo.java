import java.util.Scanner;

public class Ejemplo {
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i;
        int vector[] = new int[10];
        for ( i = 0; i < 10; i++) {
            vector[i] = scan.nextInt();
        }
        int max = -1000000000;

        for ( i = 0; i < vector.length; i++) {
            if (vector[i] % 2 == 0) {
                if (vector[i] > max) {
                    max = vector[i];
                }
            }
        }

        System.out.print(max);
    }


}
