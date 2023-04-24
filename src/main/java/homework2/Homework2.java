package homework2;

import java.io.File;

public class Homework2 {
    public static void main(String[] args) {
        //task1();
        //task2();
    }


//    1. Дана строка sql-запроса "select * from students where ".
//    Сформируйте часть WHERE этого запроса, используя StringBuilder.
//    Данные для фильтрации приведены ниже в виде json-строки.
//    Если значение null, то параметр не должен попадать в запрос.
//
//    Пример 1:
//    Параметры для фильтрации: {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"}
//    Результат: SELECT * FROM USER WHERE name = 'Ivanov' and country = 'Russia' and city = 'Moscow';
//
//    Пример 2:
//    Параметры для фильтрации: {"name:null", "country:null", "city:null", "age:null"}
//    Результат: SELECT * FROM USER;

    private static void task1() {
        String SQLRequest = "SELECT * FROM USER";
        String jsonString = "\'name:Ivanov\', \'country:Russia\', \'city:Moscow\', \'age:null\'";
//        String jsonString = "\'name:null\', \'country:null\', \'city:null\', \'age:null\'";
        String updateString = jsonString.substring(1, jsonString.length() - 1);
        String[] jsonArray = updateString.split("', \'");
        StringBuilder Filter = new StringBuilder(SQLRequest);
        for (String i : jsonArray) {
            if (!(i.contains("null"))) {
                StringBuilder append = Filter.append(" and ");
                Filter.append(i + "'");
            }
        }
        Filter.append(";");
        System.out.println(Filter.toString().replace(":", " = '")
                .replaceFirst(" and ", " WHERE "));
    }

//    2. Напишите метод, который определит тип (расширение) файлов
//    из текущей папки и выведет в консоль результат вида:
//            1 Расширение файла: txt
//            2 Расширение файла: pdf
//            3 Расширение файла:
//            4 Расширение файла: jpg

    private static void task2()  {
        File directory = new File("D:\\Программирование\\ДЗ\\Java-Homework\\src\\main\\java\\homework2");
        String files[] = directory.list();
        for(int i=0; i<files.length; i++) {
            if (files[i].toString().contains(".")) {
                String contentsString = files[i].toString();
                System.out.printf("%s Расширение файла: %s\n", i + 1,
                        contentsString.substring(contentsString.indexOf(".") + 1));
            }
            else {
                System.out.printf("%s Расширение файла: \n", i + 1);
            }
        }
    }
}
