public class OffByOne implements CharacterComparator {
    /* returns true for characters that are different by exactly one. */
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff == 1 || diff == -1) {
            return true;
        }
        return false;
    }
}
