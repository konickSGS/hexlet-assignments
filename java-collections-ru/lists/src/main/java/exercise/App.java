package exercise;

import java.util.*;

// BEGIN
public class App {

    public static void main(String[] args) {
        boolean result = App.scrabble("rkqodlw", "woRld");
        System.out.println(result);
    }

    public static boolean scrabble(String letterString, String word) {
        Map<Character, Integer> letters = makeDict(letterString.toLowerCase());

        for (char w : word.toLowerCase().toCharArray()) {
            int count = letters.getOrDefault(w, 0);
            if (count == 0) return false;
            letters.put(w, count - 1);
        }

        return true;
    }
    private static Map<Character, Integer> makeDict(String str) {
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : str.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }

        return dict;
    }
}
//END
