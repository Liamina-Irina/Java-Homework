package homework4;

import java.util.*;

public class Homework4 {
    public static void main(String[] args) {
        task1();
        //task2();
    }

//    1. Реализовать консольное приложение, которое:
//    Принимает от пользователя и “запоминает” строки.
//    Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//    Если введено revert, удаляет предыдущую введенную строку из памяти.

    private static void task1() {
        Scanner in = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        System.out.print("Введите 'print', чтобы вывести введенные строки." +
                "\nВведите 'revert', чтобы удалить из памяти предыдущую введенную строку." +
                "\nВведите 'stop' для выхода из программы.");

        while (true) {
            System.out.print("\nВведите строку или команду: ");
            String inputString = in.nextLine();
            if (inputString.isBlank()) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            if (inputString.equalsIgnoreCase("stop")) {
                break;
            } else if (inputString.equalsIgnoreCase("revert")) {
                System.out.println("Удалена строка - " + list.removeLast());
            } else if (inputString.equalsIgnoreCase("print")) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.println(list.get(i));
                }
            } else {
                list.add(inputString);
            }
        }
    }

//   2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

    private static void task2() {
        LinkedList<String> someList = new LinkedList<>(Arrays.asList("Привет", "!", "Как", "дела", "?"));
        System.out.println(someList);
            for (int i = 0; i < someList.size() / 2; i++) {
                int index = someList.size() - 1 - i;
                String temp = someList.get(i);
                someList.set(i, someList.get(index));
                someList.set(index, temp);
            }
        System.out.println(someList);
    }
}