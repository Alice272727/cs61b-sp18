public class OffByN implements CharacterComparator {
    private int difference;

    public OffByN(int N) {
        difference = N;
    }

    /* returns true for characters that are off by N */
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (diff == difference || diff == -difference) {
            return true;
        }
        return false;
    }
}
