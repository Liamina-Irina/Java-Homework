package homework6;

import java.util.*;
import java.util.Map.Entry;
public class MainHomework6 {

/*
1. Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
2. Создать множество ноутбуков.
3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
   и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
   Например:
        “Введите цифру, соответствующую необходимому критерию:
        1 - ОЗУ
        2 - Объём ЖД
        3 - Операционная система
        4 - Цвет …
   Далее нужно запросить минимальные значения для указанных критериев
   — сохранить параметры фильтрации можно также в Map.
   Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
*/

    public static void main(String[] args) {
        HashSet<Notebook> Notebooks = Notebook();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Введите 'фильтр' или 'выход': ");
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("выход")) {
                break;
            } else if (input.equalsIgnoreCase("фильтр")) {
                Map<String, Object> findNotebook = criteriaList(scan);
                HashSet<Notebook> requestNotebooks = requestSet(Notebooks, findNotebook);
                System.out.println("Ноутбуки согласно выбранному критерию: ");
                System.out.println(requestNotebooks);
            } else {
                System.out.println("'" + input + "'" + " - команда не найдена");
            }
        }
    }

    public static HashSet<Notebook> Notebook() {
        HashSet<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Huawei", "Matebook D14",14,8, 256, "Windows 11 Home", "space grey", 46000));
        notebooks.add(new Notebook("Huawei", "Magicbook", 16, 16, 512, "не установлена","grey", 56000));
        notebooks.add(new Notebook("Huawei", "Matebook D16", 16, 16, 512, "Windows 11 Home","space grey", 80000));
        notebooks.add(new Notebook("ASUS", "VivoBook 16X", 16, 16, 512, "не установлена","silver", 56000));
        notebooks.add(new Notebook("ASUS", "TUF Gaming F15", 15.6, 8, 512, "Windows 11 Home","black", 73000));
        notebooks.add(new Notebook("ASUS", "TUF Gaming A15", 15.6, 8, 512, "Windows 11 Home","black", 65000));
        notebooks.add(new Notebook("Apple", "MacBook Air", 13.3, 8, 256, "Mac OS","silver", 94000));
        notebooks.add(new Notebook("Apple", "MacBook Pro", 13.3, 8, 256, "Mac OS","silver", 132000));
        notebooks.add(new Notebook("Apple", "MacBook Pro", 14.2, 16, 512, "Mac OS","silver", 210000));
        return notebooks;
    }

    public static Map<String, Object> criteriaList(Scanner scan) {

        System.out.println("Введите цифру, соответствующую необходимому критерию: \n1 - Бренд \n2 - Модель" +
                               "\n3 - Диагональ \n4 - ОЗУ/RAM \n5 - SSD" +
                               "\n6 - Операционная система \n7 - Цвет \n8 - Цена \n->");

        Integer criteriaDigit = scan.nextInt();
        scan.nextLine();
        Map<String, Object> findNotebook = new HashMap<>();

        if (criteriaDigit == 1) {
            System.out.println("Введите бренд: ");
            String temp = scan.nextLine();
            findNotebook.put("Бренд", temp);
        }
        if (criteriaDigit == 2) {
            System.out.println("Введите модель: ");
            String temp = scan.nextLine();
            findNotebook.put("Модель", temp);
        }
        if (criteriaDigit == 3) {
            System.out.println("Введите минимальную диагональ: ");
            double temp = scan.nextDouble();
            scan.nextLine();
            findNotebook.put("Диагональ", temp);
        }
        if (criteriaDigit == 4) {
            System.out.println("Введите минимальный размер ОЗУ/RAM: ");
            int temp = scan.nextInt();
            scan.nextLine();
            findNotebook.put("ОЗУ/RAM", temp);
        }
        if (criteriaDigit == 5) {
            System.out.println("Введите минимальный размер SSD: ");
            int temp = scan.nextInt();
            scan.nextLine();
            findNotebook.put("SSD", temp);
        }
        if (criteriaDigit == 6) {
            System.out.println("Введите операционную систему: ");
            String temp = scan.nextLine();
            findNotebook.put("Операционная система", temp);
        }
        if (criteriaDigit == 7) {
            System.out.println("Введите цвет: ");
            String temp = scan.nextLine();
            findNotebook.put("Цвет", temp);
        }
        if (criteriaDigit == 8) {
            System.out.println("Введите минимальную цену: ");
            int temp = scan.nextInt();
            scan.nextLine();
            findNotebook.put("Цена", temp);
        }
        if (criteriaDigit < 1 || criteriaDigit > 8) {
            System.out.println("Ошибка ввода критерия");

        }
        return findNotebook;
    }

    public static HashSet<Notebook> requestSet(HashSet<Notebook> thisNotes, Map<String, Object> thisFindNotebook) {
        HashSet<Notebook> filteredNotebooks = new HashSet<>();
        Iterator it = thisNotes.iterator();

        for (Entry<String, Object> entry : thisFindNotebook.entrySet()) {
            if (entry.getKey().equals("Бренд")) {
                while (it.hasNext()) {
                    Notebook item = (Notebook) it.next();
                    if (item.brand.equals(entry.getValue())) {
                        filteredNotebooks.add(item);
                    }
                }
            }
            if (entry.getKey().equals("Модель")) {
                while (it.hasNext()) {
                    Notebook item = (Notebook) it.next();
                    if (item.model.equals(entry.getValue())) {
                        filteredNotebooks.add(item);
                    }
                }
            }
            if (entry.getKey().equals("Диагональ")) {
                while (it.hasNext()) {
                    Notebook item = (Notebook) it.next();
                    if (item.diagonal >= (Double) entry.getValue()) {
                        filteredNotebooks.add(item);
                    }
                }
            }
            if (entry.getKey().equals("ОЗУ/RAM")) {
                while (it.hasNext()) {
                    Notebook item = (Notebook) it.next();
                    if (item.rAM >= (Integer) entry.getValue()) {
                        filteredNotebooks.add(item);
                    }
                }
            }
            if (entry.getKey().equals("SSD")) {
                while (it.hasNext()) {
                    Notebook item = (Notebook) it.next();
                    if (item.sSD >= (Integer) entry.getValue()) {
                        filteredNotebooks.add(item);
                    }
                }
            }
            if (entry.getKey().equals("Операционная система")) {
                while (it.hasNext()) {
                    Notebook item = (Notebook) it.next();
                    if (item.operationSystem.contains((CharSequence) entry.getValue())) {
                        filteredNotebooks.add(item);
                    }
                }
            }
            if (entry.getKey().equals("Цвет")) {
                while (it.hasNext()) {
                    Notebook item = (Notebook) it.next();
                    if (item.colour.equals(entry.getValue())) {
                        filteredNotebooks.add(item);
                    }
                }
            }
            if (entry.getKey().equals("Цена")) {
                while (it.hasNext()) {
                    Notebook item = (Notebook) it.next();
                    if (item.price >= (Integer) entry.getValue()) {
                        filteredNotebooks.add(item);
                    }
                }
            }
        }
        return filteredNotebooks;
    }
}