package Task3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ArrayList array = new ArrayList<>();

        Random r = new Random();

        for (int i = 0; i < r.nextInt(10 - 0); i++) {
            array.add(r.nextInt(100 - 0));
        }
        System.out.println(array);
        System.out.println("За яким індексом видалити значення?");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        array.remove(number);
        System.out.println(array);


    }
}
