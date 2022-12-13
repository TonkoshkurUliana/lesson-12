/**
 * @exception WrongInputConsoleParametersException
 * @author Uliana Tonkoshkur
 * @version 1.0
 **/

package Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    /**
     * Наповнюємо меню
     */
    static void menu() {

        System.out.println(" ");
        System.out.println("Натисніть 0: Чи існує такий місяць?");
        System.out.println("Натисніть 1: Вивести всі місяці з такою ж порою року");
        System.out.println("Натисніть 2: Вивести всі місяці які мають таку саму кількість днів");
        System.out.println("Натисніть 3: Вивести на екран всі місяці які мають меншу кількість днів");
        System.out.println("Натисніть 4: Вивести на екран всі місяці які мають більшу кількість днів");
        System.out.println("Натисніть 5: Вивести на екран наступну пору року");
        System.out.println("Натисніть 6: Вивести на екран попередню пору року");
        System.out.println("Натисніть 7: Вивести на екран всі місяці які мають парну кількість днів");
        System.out.println("Натисніть 8: Вивести на екран всі місяці які мають непарну кількість днів");
        System.out.println("Натисніть 9: Вивести на екран чи введений з консолі місяць має парну кількість днів");
        System.out.println(" ");
    }

    public static void main(String[] args) throws WrongInputConsoleParametersException {


        ArrayList<Months> months = new ArrayList<Months>();
        Collections.addAll(months, Task2.Months.values());

        ArrayList<Seasons> seasons = new ArrayList<Seasons>();
        Collections.addAll(seasons, Task2.Seasons.values());

        try {
            while (true) {
                /** Створюємо меню */
                menu();
                /** Зчитуємо виюір користувача */
                Scanner sc = new Scanner(System.in);
                int number = sc.nextInt();
                String text;
                /** Викликаємо потрібну конструкцію */
                switch (number) {
                    case 0: {
                        System.out.println("Введіть назву місяця");
                        sc = new Scanner(System.in);
                        text = sc.next().toUpperCase();
                        boolean flag = false;
                        /** Перевіряємо правельність введення користувачем назви */

                        for (Months m : months) {
                            if (m.name().equalsIgnoreCase(text)) {
                                flag = true;
                            }
                        }
                        if (!flag) {
                            System.out.println("Цього місяця не існую");
                        } else {
                            System.out.println("Цей місяць існую");
                        }
                        break;
                    }
                    case 1: {
                        /** Перевіряємо правельність введення користувачем назви */
                        System.out.println("Введіть пору року");
                        sc = new Scanner(System.in);
                        text = sc.next().toUpperCase();
                        boolean flag = false;

                        for (Seasons s : seasons) {
                            if (s.name().equalsIgnoreCase(text)) {
                                flag = true;
                            }
                        }
                        if (!flag) {
                            System.out.println("Цієї пори року не існую");
                        } else {
                            for (Months m : months) {
                                if (m.seasons.name().equals(text)) {
                                    System.out.println(m.name());
                                }
                            }
                    }
                    break;
                }
                    case 2: {
                        /** Шукаємо  кількість днів, яку ввів користувач */
                        System.out.println("Введіть кількість днів:");
                        sc = new Scanner(System.in);
                        number = sc.nextInt();
                        /** Перевіряємо правельність введення користувачем кількість днів */
                        boolean flag = MonthOfCountDay(months, number);
                        if (!flag) {
                            System.out.println("Немає такої кількості");
                        } else {
                            System.out.println("Кількість днів: " + number);
                            for (Months m : months) {
                                if (m.getDays() == number) {
                                    System.out.println(m.name());
                                }
                            }
                        }
                        break;
                    }

                    case 3: {
                        int max = 0;
                        /** Шукаємо найменьшу кількість днів і вовидимо місяці */
                        for (Months m : months) {
                            if (m.getDays() > max) {
                                max = m.getDays();
                            }
                        }
                        for (Months m : months) {
                            if (m.getDays() != max) {
                                System.out.println(m.name());
                            }
                        }
                        break;
                    }

                    case 4: {
                        /** Шукаємо найбільшу кількість днів і вовидимо місяці */
                        int max = 0;
                        for (Months m : months) {
                            if (m.getDays() > max) {
                                max = m.getDays();
                            }
                        }
                        for (Months m : months) {
                            if (m.getDays() == max) {
                                System.out.println(m.name());
                            }
                        }
                        break;
                    }

                    case 5: {
                        /**  Шукаємо наступну пору року */
                        System.out.println("Введіть пору року:");
                        sc = new Scanner(System.in);
                        text = sc.next().toUpperCase();
                        boolean flag = false;
                        /** Перевіряємо правельність введення користувачем назви */
                        for (Seasons s : seasons) {
                            if (s.name().equals(text)) {
                                flag = true;
                            }
                        }
                        if (!flag) {
                            System.out.println("Цієї пори року не існую");
                        } else {
                            Seasons s = Seasons.valueOf(text);
                           if (s.ordinal() == seasons.size()-1) {
                                System.out.println(seasons.get(s.ordinal() - 3));
                            } else {
                                System.out.println(seasons.get(s.ordinal() + 1));
                            }
                        }
                        break;
                    }

                    case 6: {
                        /** Шукаємо попередню пору року*/
                        System.out.println("Введіть пору року:");
                        sc = new Scanner(System.in);
                        text = sc.next().toUpperCase();
                        boolean flag = false;
                        /** Перевіряємо правельність введення користувачем назви */
                        for (Seasons s : seasons) {
                            if (s.name().equals(text)) {
                                flag = true;
                            }
                        }
                        if (!flag) {
                            System.out.println("Цієї пори року не існую");
                        } else {
                            Seasons s = Seasons.valueOf(text);
                            if (s.ordinal() == 0) {
                                System.out.println(seasons.get(s.ordinal() + 3));
                            } else {
                                System.out.println(seasons.get(s.ordinal() - 1));
                            }
                        }
                        break;
                    }
                    case 7: {
                        /** Шукаємо парну кількість днів */
                        for (Months m : months) {
                            if (m.getDays() % 2 == 0) {
                                System.out.println(m.name());
                            }
                        }
                        break;
                    }
                    case 8: {
                        /** Шукаємо не парну кількість днів */

                        for (Months m : months) {
                            if (m.getDays() % 2 == 1) {
                                System.out.println(m.name());
                            }
                        }
                        break;
                    }
                    case 9: {
                        /** Перевіряємо правельність введення користувачем назви і
                         *  чи має цей місяць парне число днів */
                        System.out.println("Введіть назву місяця");
                        sc = new Scanner(System.in);
                        text = sc.next().toUpperCase();
                        boolean flag = false;
                        for (Months m : months) {
                            if (m.name().equals(text)) {
                                flag = true;
                            }
                        }
                        if (!flag) {
                            System.out.println("Цього місяця не існую");
                        } else {
                            Months m = Months.valueOf(text);
                            if (m.getDays() % 2 == 0) {
                                System.out.println("Цей місяць має парну кількість днів");
                            } else {
                                System.out.println("Цей місяць має не парну кількість днів");
                            }
                        }
                        break;
                    }
            }
        }
        /** Перевіряємо на помилку і викликаємо виключення */
    } catch(
    InputMismatchException e)

    {
        String msg = "Значення повинні бути від 0 до 9";
        throw new WrongInputConsoleParametersException(msg);
    }

}

    /**
     * Перевіряємо кількість днів з введенним користувачем числом
     */
    private static boolean MonthOfCountDay(ArrayList<Months> months, int inputsc) {
        boolean flag = false;

        for (Months m : months) {
            if (m.getDays() == inputsc) {
                flag = true;
            }
        }
        return flag;
    }
}
