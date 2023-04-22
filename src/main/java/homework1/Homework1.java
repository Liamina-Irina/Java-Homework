package homework1;

import java.util.Scanner;
import java.time.LocalTime;

public class Homework1 {
    public static void main(String[] args) {
        //task1(10,10);
        //task2();
        //task3(5);
        //task4();
    }


// 1. Написать метод, принимающий на вход два аргумента: len и initialValue,
// и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue

    private static void task1(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i : arr) {
            arr[i] = initialValue;
            System.out.printf("%s ", arr[i]);
        }
    }

// 2. Задать одномерный массив и найти в нем минимальный и максимальный элементы

    private static void task2() {
        int[] arr = new int[]{-101, 22, 0, 13, 34, 102, -26, 35, 47, -122};
        int minValue = 0;
        int maxValue = 0;

        for (int i : arr) {
            if (i < minValue) {
                minValue = i;
            } else if (i > maxValue) {
                maxValue = i;
            }
        }
        System.out.printf("Минимальный элемент массива: %s%nМаксимальный элемент массива: %s", minValue, maxValue);

    }

// 3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами
// (можно только одну из диагоналей, если обе сложно).
// Определить элементы одной из диагоналей можно по следующему принципу:
// индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n]

    private static void task3(int length) {
        int[][] matrix = new int[length][length];
        for (int i = 0; i <= length - 1; i++) {
            for (int j = 0; j <= length - 1; j++) {
                if ((i == j) || (j == (length - 1 - i))) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }

// 4. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
//        "Доброе утро, <Имя>!", если время от 05:00 до 11:59
//        "Добрый день, <Имя>!", если время от 12:00 до 17:59;
//        "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//        "Доброй ночи, <Имя>!", если время от 23:00 до 4:59

    private static void task4() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scan.nextLine();
        int time = LocalTime.now().getHour();
        if (time >= 5 && time < 12) {
            System.out.printf("Доброе утро, %s!", name);
        } else if (time >= 12 && time < 18) {
            System.out.printf("Добрый день, %s!", name);
        } else if (time >= 18 && time < 23) {
            System.out.printf("Добрый вечер, %s!", name);
        } else {
            System.out.printf("Доброй ночи, %s!", name);
        }
    }

}

