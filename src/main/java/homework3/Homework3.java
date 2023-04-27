package homework3;

import java.util.*;

public class Homework3 {
    public static void main(String[] args) {
        //task1();
        //task2();
        //task2_2();
    }

//    1. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа.
//    Пройти по списку, найти и удалить целые числа.
//
//    Пример: {"Яблоко", "11", "13", "Апельсин", "Дыня", "17"} -> {"Яблоко", "Апельсин", "Дыня"}

    private static void task1() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Яблоко", "11", "13", "Апельсин", "Дыня", "17"));
        System.out.println(list);
        int index = 0;
        while (index < list.size()) {
            String currentElement = list.get(index);
            try {
                Integer.parseInt(currentElement);
                list.remove(index);
            } catch (Exception e) {
                index++;
            }
        }
        System.out.println(list);
    }

//    2. Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
//    что на 0й позиции каждого внутреннего списка содержится название жанра,
//    а на остальных позициях - названия книг. Напишите метод для заполнения данной структуры(можно через консоль).
//    Пример:
//            "Классика", "Преступление и наказание", "Война и мир", "Анна Каренина".
//            "Научная фантастика", "Солярис", "Ночной дозор", "Братья Стругацкие".
//            "Детектив", "Десять негритят".
//            "Фантастика", "Хроники Нарнии", "Гарри Поттер и философский камень", "Грозовой перевал".

    private static void task2() {

        Scanner in = new Scanner(System.in);
        List<ArrayList<String>> catalog = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.println("Введите в одной строке через запятую сначала жанр книги, далее названия книг в этом жанре " +
                    "также через запятую.\nЧтобы вывести каталог на экран напишите слово 'стоп'.");
            String inputString = in.nextLine();
            ArrayList<String> rowsBooks = new ArrayList<>();

            if (inputString.isBlank()) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            final int GENRE = 0;
            int genreRow;
            if (!inputString.equalsIgnoreCase("стоп")) {
                getBooks(inputString, rowsBooks);
                genreRow = getGenresRow(rowsBooks.get(GENRE), catalog);
                if (genreRow == -1) {
                    catalog.add(catalog.size(), rowsBooks);
                } else {
                    rowsBooks.remove(GENRE);
                    catalog.get(genreRow).addAll(rowsBooks);
                }
            } else {
                printToConsoleCatalog(catalog);
            }
        }

    }

    private static void getBooks(String inputString, ArrayList<String> rowsBooks) {
        String[] tmp = inputString.split("\\s*,\\s*");
        for (String book :
                tmp)
            rowsBooks.add(book);

    }

    private static int getGenresRow(String inputString, List<ArrayList<String>> catalog) {
        int row = -1;
        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).contains(inputString)) {
                row = i;
                return row;
            }
        }
        return row;

    }

    private static void printToConsoleCatalog(List<ArrayList<String>> catalog) {
        System.out.println("Каталог товаров книжного магазина: \nЖанр \t\t [Книги]");
        for (int i = 0; i < catalog.size(); i++) {
            System.out.print(catalog.get(i).get(0) + " [");
            for (int j = 1; j < catalog.get(i).size(); j++) {
                if (j < catalog.get(i).size() - 1) System.out.print(catalog.get(i).get(j) + ", ");
                else System.out.print(catalog.get(i).get(j) + ".");
            }
            System.out.print("]\n");
        }
    }


//    Задание № 2.2
//    Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.

    private static void task2_2() {
        String[] planetsNamesStringArray = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus", "Pluto"};
        List<String> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            list.add(planetsNamesStringArray[random.nextInt(planetsNamesStringArray.length)]);
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        Collections.sort(list);
        int index = 0;
        while (index < list.size() - 1) {
            if (list.get(index).equals(list.get(index + 1))) {
                list.remove(index);
            } else {
                index++;
            }
        }
        System.out.println(list);
    }

}
