package homework5;

import java.util.*;

public class Homework5 {
    public static void main(String[] args) {
        Map<String, String> phoneBook = task1();
        task2(phoneBook);
        //task3();
    }

//    1. Реализуйте структуру телефонной книги с помощью HashMap,
//    учитывая, что 1 человек может иметь несколько телефонов.
//    Пусть дан список сотрудников:
//    Иван Иванов
//    Светлана Петрова
//    Кристина Белова
//    Анна Мусина
//    Анна Крутова
//    Иван Юрин
//    Петр Лыков
//    Павел Чернов
//    Петр Чернышов
//    Мария Федорова
//    Марина Светлова
//    Мария Савина
//    Мария Рыкова
//    Марина Лугова
//    Анна Владимирова
//    Иван Мечников
//    Петр Петин
//    Иван Ежов
    public static Map<String, String> task1() {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Иван Иванов", "9180011000");
        phoneBook.put("Иван Иванов", "9180022000");
        phoneBook.put("Светлана Петрова", "9180033000");
        phoneBook.put("Светлана Петрова", "9180044000");
        phoneBook.put("Кристина Белова", "9180055000");
        phoneBook.put("Анна Мусина", "9180066000");
        phoneBook.put("Анна Крутова", "9180077000");
        phoneBook.put("Иван Юрин", "9180088000");
        phoneBook.put("Петр Лыков", "9180099000");
        phoneBook.put("Петр Лыков", "9180000000");
        phoneBook.put("Павел Чернов", "9180012000");
        phoneBook.put("Петр Чернышов", "9180013000");
        phoneBook.put("Мария Федорова", "9180014000");
        phoneBook.put("Мария Федорова", "9180015000");
        phoneBook.put("Марина Светлова", "9180016000");
        phoneBook.put("Мария Савина", "9180017000");
        phoneBook.put("Мария Рыкова", "9180018000");
        phoneBook.put("Марина Лугова", "9180019000");
        phoneBook.put("Анна Владимирова", "9180020000");
        phoneBook.put("Иван Мечников", "9180021000");
        phoneBook.put("Петр Петин", "9180022000");
        phoneBook.put("Петр Петин", "9180023000");
        phoneBook.put("Иван Ежов", "9180024000");
        return phoneBook;
    }

//    2. Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
//    Отсортировать по убыванию популярности.
    public static void task2(Map<String, String> book) {
        int nameIndex = 0;
        List<String> names = new ArrayList<>(book.keySet().stream().map(s -> s.split(" ")[nameIndex]).toList());
        Set<String> uniqueNames = new HashSet<>(names);
        Map<String, Integer> mapNameCount = new HashMap<>();
        for (String name : uniqueNames) {
            int count = Collections.frequency(names, name);
            mapNameCount.put(name, count);
        }
        List<Integer> values = new ArrayList<>();
        for (int value : mapNameCount.values()) {
            if (!values.contains(value)) {
                values.add(value);
            }
        }
        values.sort(Comparator.reverseOrder());
        for (int value : values) {
            for (String name : mapNameCount.keySet()) {
                if (value == mapNameCount.get(name)) {
                    System.out.println(name + " - " + value);
                }
            }
        }
    }


//    3. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга
//    (обратите внимание на алгоритм backtracking(поиск с возвратом)).
    private static void task3() {
        turnQ(0);
    }

    static int len = 8;
    static int num = 1;
    static int[][] place = new int[len][len];

    private static void turnQ(int row) {
        if (row == place.length) {
            printPlace();
            return;
        }
        for (int j = 0; j < place.length; j++) {
            if (checkQ(row, j)) {
                place[row][j] = 1;
                turnQ(row + 1);
            }
            place[row][j] = 0;
        }
    }

    private static boolean checkQ(int row, int column) {
        for (int k = 0; k < place.length; k++) {
            if (place[row][k] == 1 || place[k][column] == 1) {
                return false;
            }
            int q = row - column + k;
            if (q >= 0 && q < place.length) {
                if (place[q][k] == 1) {
                    return false;
                }
            }
            q = row + column - k;
            if (q >= 0 && q < place.length) {
                if (place[q][k] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printPlace() {
        System.out.println("№ " + num);
        num++;
        for (int[] i : place) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
