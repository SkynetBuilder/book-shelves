//Необходимо реализовать следующий метод:
//
//На вход получаем список названий книг.
//Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг.
//Все книги должны быть отсортированы по алфавиту с первой до последней полки.
//Количество полок константное — 5 штук.
//        Вернуть книги, распределенные по полкам.

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> books = new ArrayList<>(List.of("Война и Мир", "Преступление и наказание", "Евгений Онегин", "Одиссея", "Старик и море", "1984", "Отцы и дети"));
        System.out.println(putOnShelves(books));
    }

    public static List<List<String>> putOnShelves(List<String> books) {
        books = books.stream().sorted().toList();
        List<List<String>> shelves = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            shelves.add(new ArrayList<>());
        }
        int index = 0;
        int remainder = books.size() % 5;
        for (List<String> shelf : shelves) {
            for (int i = 0; i < books.size() / 5; i++) {
                shelf.add(books.get(index++));
            }
            if (remainder-- > 0){
                shelf.add(books.get(index++));
            }
        }
        return shelves;
    }
}
