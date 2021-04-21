import java.util.LinkedList;
import java.util.ArrayDeque;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            deque.addLast(word.charAt(i));
        }
        return  deque;
    }

    private Deque<Character> rwordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            deque.addFirst(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        }
        Deque<Character> deque1 = wordToDeque(word);
        Deque<Character> deque2 = rwordToDeque(word);
        for (int i = 0; i < word.length(); i += 1) {
            if (deque1.removeFirst() != deque2.removeFirst()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 1 || word.length() == 0) {
            return true;
        }
        Deque<Character> deque1 = wordToDeque(word);
        Deque<Character> deque2 = rwordToDeque(word);
        for (int i = 0; i < word.length(); i += 1) {
            if (!cc.equalChars(deque1.get(i), deque2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
