/**
 * @ClassName Palindrome
 * @Description: TODO
 * @Author Jiacheng Weng
 * @Date 12/6/20 3:47 下午
 * @Version V1.0
 **/
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque);
    }

    private boolean isPalindromeHelper(Deque<Character> deque) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        }
        boolean b;
        if (deque.removeFirst().equals(deque.removeLast())) {
            b = isPalindromeHelper(deque);
        } else {
            b = false;
        }
        return b;

    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper2(deque, cc);
    }

    private boolean isPalindromeHelper2(Deque<Character> deque, CharacterComparator cc) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        }
        boolean b;

        if (cc.equalChars(deque.removeFirst(), deque.removeLast())) {
            b = isPalindromeHelper2(deque, cc);
        } else {
            b = false;
        }
        return b;

    }
}
