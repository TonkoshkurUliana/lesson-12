package Task1;

import java.util.*;


public class Main {
    static void menu() {
        System.out.println("Натисніть 1: Вивести дані на консоль ");
        System.out.println("Натисніть 2: Засетити одинаковий об`єкт класу Авто");
    }

    public static String material(int number) {

        if (number == 1) {
            return "lather";
        } else {
            return "alkantara";
        }
    }

    public static int getRandomValueFromRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("min value must be smaller than max value");
        }

        Random r = new Random();
        return r.nextInt(max - min + 1) + min; // 1-10
    }

    public static void main(String[] args) {

        /*          Task 1         */
        System.out.println("************** Завдання 1 **************");
        System.out.println("");
        ArrayList array = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 12; i++) {
            array.add(r.nextInt(100 - 0));
        }
        System.out.println("Початковий масив:");
        System.out.println(array);

        Collections.sort(array);
        System.out.println("Відсортований масив:");
        System.out.println(array);


        /*          Task 2         */
        System.out.println("");
        System.out.println("************** Завдання 2 **************");
        System.out.println("");
        int size1 = getRandomValueFromRange(2, 5);

        ArrayList arrayCar = new ArrayList<String>();
        for (int i = 0; i < size1; i++) {
                arrayCar.add(new Car(getRandomValueFromRange(4, 8), getRandomValueFromRange(18, 25), material(getRandomValueFromRange(1, 2)), getRandomValueFromRange(1990, 2022), getRandomValueFromRange(220, 450)).toString());
        }
        while (true) {
            menu();
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            switch (number) {
                case 1: {
                    System.out.println(arrayCar);
                    break;
                }
                case 2: {
                    String value = new Car(getRandomValueFromRange(4, 8), getRandomValueFromRange(18, 25), material(getRandomValueFromRange(1, 2)), getRandomValueFromRange(1990, 2022), getRandomValueFromRange(220, 450)).toString();
                    System.out.println("Встановлюємо наступне значення:" + value);

                        for(int i = 0; i < size1; i++) {
                            arrayCar.set(i, value);
                        }
                    break;
                }
            }
        }
    }
}