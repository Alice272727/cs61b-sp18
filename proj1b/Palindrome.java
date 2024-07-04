public class Palindrome {
    /*
     * Given a String,wordToDeque should return a Deque where the characters appear
     * in the same order as in the String
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> toDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            toDeque.addLast(word.charAt(i));
        }
        return toDeque;
    }

    /* Returns true if the given word is a palindrome, and false otherwise. */
    public boolean isPalindrome(String word) {
        Deque<Character> Q = wordToDeque(word);
        if (Q.size() == 0 || Q.size() == 1) {
            return true;
        } else {
            int len = shrink(Q);
            if (len == 0 || len == 1) {
                return true;
            }
            return false;
        }
    }

    private int shrink(Deque<Character> DQ) {
        if (DQ.removeFirst() != DQ.removeLast()) {
            int newLen = DQ.size() + 2;
            return newLen;
        } else if (DQ.size() == 0 || DQ.size() == 1) {
            return DQ.size();
        } else {
            DQ.removeFirst();
            DQ.removeLast();
            return shrink(DQ);
        }
    }

    /*
     * The method will return true if the word is a palindrome according to the
     * character comparison test provided by the CharacterComparator passed in as
     * argument cc.
     */
    // @Overlod
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() <= 1) {
            return true;
        }
        Deque<Character> newDq = wordToDeque(word);
        int halflen = (newDq.size() / 2); 
        for (int i = 0; i < halflen; i++) {
            Character x = newDq.removeFirst();
            Character y = newDq.removeLast();
            if (!cc.equalChars(x, y)) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

}
