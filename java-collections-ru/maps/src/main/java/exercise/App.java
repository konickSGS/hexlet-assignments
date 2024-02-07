package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
/**
 * Класс для выполнения домашнего задания 1. содержит метод getWordCount(string) и toString(map)
 */
public class App {
    public static void main(String[] args) {
        String sentence = "the java is the best programming language java";
        Map wordsCount = getWordCount(sentence);

        System.out.println(toString(wordsCount));
    }

    /**
     * Метод, который разбивает предложение на слова, а эти слова посчитать с помощью Map.
     * @param sentence - предложение.
     * @return - Словарь с количеством слов
     */
    public static Map<String, Integer> getWordCount(String sentence) {
        sentence = removeUnnecessaryCharacters(sentence);

        if (sentence.equals("")) {
            return new HashMap<>();
        }
        Map<String, Integer> wordCount = makeDict(
                List.of(sentence.split(" "))
        );

        return wordCount;
    }

    /**
     * Метод, который очищает из предложения лишние символы:
     * 1) Пробелы вначале и в конце
     * Потенциально можно улучшить очень сильно.
     * @param sentence - предложение, которое нужно отчистить
     * @return Чистое предложение без лишних символов
     */
    private static String removeUnnecessaryCharacters(String sentence) {
        sentence = sentence.trim();
        return sentence;
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

    /**
     * Метод для красивого вывода Map.
     * @param map - Словарь для красивого вывода
     * @return красивая строка
     * @param <K> - key
     * @param <V> - value
     */
    public static <K, V> String toString(Map<K, V> map) {
        StringBuilder str = new StringBuilder();
        str.append("{");
        if (map.size() != 0) {
            str.append("\n");
        }
        for (var c : map.entrySet()) {
            str.append("  ");
            str.append(c.getKey());
            str.append(": ");
            str.append(c.getValue());
            str.append("\n");
        }
        str.append("}");

        return str.toString();
    }
}
//END
