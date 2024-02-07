package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN

/**
 * Класс для выполнения домашнего задания 1. содержит метод scrabble
 */
public class App {

    public static void main(String[] args) {
        boolean result = App.scrabble("rkqodlw", "woRld");
        System.out.println(result);
    }

    /**
     * Метод, который выясняет, можно ли из букв первого слова сложить второе.
     *
     * @param letterString    - слово, буквы которого мы хотим использовать для создания второго слова
     * @param word            - слово, которое мы хотим сложить
     * @param isCaseImportant - если true, то регистр мы учитываем (заглавные и строчные символы считаются разными)
     * @return true, если word можно сложить из letterString, false иначе.
     */
    public static boolean scrabble(String letterString, String word, Boolean isCaseImportant) {
        if (!isCaseImportant) {
            letterString = letterString.toLowerCase();
            word = word.toLowerCase();
        }

        //С помощью Stream API мы конвертируем String -> List<Character>
        Map<Character, Integer> letters = makeDict(
                letterString.chars().mapToObj(c -> (char) c).collect(Collectors.toList())
        );


        //Проходим по каждому символу строки word. Если символ содержится в letters,
        // то мы отнимаем у него на число вхождений.
        // Если их число будет 0, то мы return false
        for (char w : word.toCharArray()) {
            int count = letters.getOrDefault(w, 0);
            if (count == 0) {
                return false;
            }
            letters.put(w, count - 1);
        }
        return true;
    }

    /**
     * Метод scrabble. По-умолчанию считаем, что регистр не имеет значения
     *
     * @param letterString - слово, буквы которого мы хотим использовать для создания второго слова
     * @param word         - слово, которое мы хотим сложить
     * @return true, если word можно сложить из letterString, false иначе.
     */
    public static boolean scrabble(String letterString, String word) {
        return scrabble(letterString, word, false);
    }

    /**
     * Метод, который возвращает словарь с подсчетов вхождения каждого элемента List.
     *
     * @param list - Лист, элементы которого мы хотим посчитать
     * @param <T>  - Дженерик. То есть мы можем передать List с любым типом
     * @return Словарь с разбиением
     */
    private static <T> Map<T, Integer> makeDict(List<T> list) {
        Map<T, Integer> dict = new HashMap<>();
        for (T c : list) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }

        return dict;
    }
}
//END
