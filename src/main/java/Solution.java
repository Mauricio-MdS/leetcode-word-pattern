import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> characterToWord = new HashMap<>();
        Map<String, Character> wordToCharacter = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            String mappedWord = characterToWord.putIfAbsent(c, word);
            if (mappedWord != null && !mappedWord.equals(word)) return false;

            Character mappedCharacter = wordToCharacter.putIfAbsent(word, c);
            if (mappedCharacter != null && mappedCharacter != c) return false;
        }

        return true;
    }
}